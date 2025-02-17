package Atendimento;

import Usuarios.Medico;
import Usuarios.Paciente;
import db.DBGlobal;
import db.DBItem;

import java.time.LocalDateTime;

public class Ficha extends DBItem implements Comparable<Ficha> {

	private int pacienteId;
	private int fichaAcolhimentoId;
	private int medicoId;
	private FichaStatus status;
	private LocalDateTime horaDaChegada;

	public Ficha(int id, int pacienteId, int fichaAcolhidmentoId, FichaStatus status, LocalDateTime horaDaChegada) {
		super(id);
		this.pacienteId = pacienteId;
		this.fichaAcolhimentoId = fichaAcolhidmentoId;
		this.status = status;
		this.horaDaChegada = horaDaChegada;
	}

	public Ficha(int id, int pacienteId) {
		super(id);
		this.pacienteId = pacienteId;
		this.fichaAcolhimentoId = 0;
		this.status = FichaStatus.RECEPCAO;
		this.horaDaChegada = LocalDateTime.now();
	}

	public int getFichaAcolhimentoId() {
		return fichaAcolhimentoId;
	}

	public FichaStatus getStatus() {
		return status;
	}

	public void setStatus(FichaStatus status) {
		this.status = status;
		DBGlobal.fichas.onUpdateData(this);
	}

	public FichaAcolhimento getFichaAcolhimento() {
		return DBGlobal.fichasAcolhimento.getFichaAcolhimentoById(this.fichaAcolhimentoId);
	}

	public Paciente getPaciente() {
		return DBGlobal.pessoas.getPacienteById(this.pacienteId);
	}

	@Override
	public int compareTo(Ficha o) {
		if (this == o) return 0;
		int peso = 0;

		boolean chegouAntes = this.getHoraDaChegada().isBefore(o.getHoraDaChegada());
		if (chegouAntes) {
			peso += 1;
		}

		if (this.isAtrasado()) {
			peso += 200;
		}
		if (o.isAtrasado()) {
			peso -= 200;
		}

		Paciente pacienteA = this.getPaciente();
		int idadeA = pacienteA.getIdade();
		if (idadeA >= 60) {
			peso += 100 + ((idadeA - 60) * 10);
		}

		Paciente pacienteB = o.getPaciente();
		int idadeB = pacienteB.getIdade();
		if (idadeB >= 60) {
			peso -= 100 + ((idadeB - 60) * 10);
		}

		if (this.status == FichaStatus.TRIAGEM_FINALIZADA) {
			FichaAcolhimento fichaAcolhimentoA = this.getFichaAcolhimento();
			FichaAcolhimento fichaAcolhimentoB = o.getFichaAcolhimento();

			peso += (fichaAcolhimentoA.getPrioridadeInt() - fichaAcolhimentoB.getPrioridadeInt()) * 100;
		}

		return -1 * peso;
	}

	public LocalDateTime getHoraDaChegada() {
		return horaDaChegada;
	}

	public boolean isAtrasado() {
		LocalDateTime a = LocalDateTime.from(this.horaDaChegada);

		FichaAcolhimento acolhimento = this.getFichaAcolhimento();
		switch (acolhimento.getPrioridade()) {
			case EMERGENCIA: {
				break;
			}
			case MUITO_URGENTE: {
				a.plusMinutes(10);
				break;
			}
			case URGENTE: {
				a.plusMinutes(50);
				break;
			}
			case POUCO_URGENTE: {
				a.plusMinutes(120);
				break;
			}
			case NAO_URGENTE: {
				a.plusMinutes(240);
				break;
			}
		}

		if (a.isBefore(LocalDateTime.now())) {
			return true;
		}
		return false;

	}

	public int getPacienteId() {
		return pacienteId;
	}

	public void setEmTriagem() {
		this.setStatus(FichaStatus.EM_TRIAGEM);
	}

	public void setTriagemFinalizada(int fichaAcolhimentoId) {
		this.fichaAcolhimentoId = fichaAcolhimentoId;
		this.setStatus(FichaStatus.TRIAGEM_FINALIZADA);
	}

	public void setAtendido(Medico medico) {
		this.medicoId = medico.getId();
		this.setStatus(FichaStatus.ATENDIMENTO_FINALIZADO);
	}
}
