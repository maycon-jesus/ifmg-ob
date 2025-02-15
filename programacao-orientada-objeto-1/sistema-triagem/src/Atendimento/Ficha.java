package Atendimento;

import Usuarios.MedicoEspecialidade;
import db.DBItem;

import java.time.LocalDateTime;

public class Ficha extends DBItem implements Comparable<Ficha> {

	int pacienteId;
	int fichaAcolhimentoId;
	FichaStatus status;
	LocalDateTime horaDaChegada;

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

	public void setFichaAcolhimentoId(int fichaAcolhimentoId) {
		this.fichaAcolhimentoId = fichaAcolhimentoId;
		this.status = FichaStatus.TRIAGEM_FINALIZADA;
	}

	public FichaAcolhimento getFichaAcolhimento() {
		switch (this.getId()) {
			case 1:
				return new FichaAcolhimento(1, 101, "Dor de cabeça", "2 dias", "Hipertensão", "Aspirina", "Sim", "Nenhuma", "Não", "Não", "Histórico de diabetes", true, false, "Dor intensa na cabeça", 38.5, "120/80", 80, 18.0, 98, 90, true, "Desmaios", "Febre alta", MedicoEspecialidade.PEDIATRA, PrioridadeManchester.URGENTE);

			case 2:
				return new FichaAcolhimento(2, 102, "Tosse seca", "1 semana", "Asma", "Salbutamol", "Não", "Nenhuma", "Não", "Sim", "Histórico de asma", false, true, "Desconforto ao respirar", 37.0, "110/70", 75, 16.0, 99, 85, true, "Dificuldade respiratória", "Suspeita de infecção pulmonar", MedicoEspecialidade.PEDIATRA, PrioridadeManchester.POUCO_URGENTE);

			case 3:
				return new FichaAcolhimento(3, 103, "Dor abdominal", "3 dias", "Gastrite", "Omeprazol", "Sim", "Nenhuma", "Não", "Não", "Histórico de úlcera", false, false, "Dor intensa no abdômen", 37.8, "115/75", 78, 17.5, 97, 100, false, "Vômito", "Dor intensa", MedicoEspecialidade.PEDIATRA, PrioridadeManchester.URGENTE);

			case 4:
				return new FichaAcolhimento(4, 104, "Febre e calafrios", "2 dias", "Nenhuma", "Paracetamol", "Não", "Nenhuma", "Sim", "Não", "Histórico de infecções recorrentes", true, false, "Calafrios intensos", 39.0, "120/85", 82, 20.0, 96, 95, true, "Confusão mental", "Sinais de infecção severa", MedicoEspecialidade.CLINICO_GERAL, PrioridadeManchester.URGENTE);

			case 5:
				return new FichaAcolhimento(5, 105, "Dor no peito", "1 hora", "Nenhuma", "Nenhuma", "Não", "Nenhuma", "Não", "Não", "Histórico de doenças cardíacas", false, false, "Dor aguda no peito", 36.5, "130/90", 85, 19.0, 99, 110, false, "Falta de ar", "Suspeita de infarto", MedicoEspecialidade.CLINICO_GERAL, PrioridadeManchester.EMERGENCIA);

		}
		return null;
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

}
