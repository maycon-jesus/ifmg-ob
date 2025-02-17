package db;

import Atendimento.Ficha;
import Atendimento.FichaStatus;
import Usuarios.MedicoEspecialidade;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DBFicha extends DBManager<Ficha> {

	public DBFicha() {
		super("db/ficha", "id, pacienteId, fichaAcolhidmentoId, status, " +
				"horaDaChegada", 10);
	}

	@Override
	Ficha createInstaceOfData(String[] dataArr) {

		int id = Integer.parseInt(dataArr[0]);
		int pacienteId = Integer.parseInt(dataArr[1]);
		int fichaAcolhidmentoId = Integer.parseInt(dataArr[2]);
		FichaStatus status = FichaStatus.valueOf(dataArr[3]);
		LocalDateTime horaDaChegada = LocalDateTime.parse(dataArr[4]);

		Ficha ficha = new Ficha(id, pacienteId, fichaAcolhidmentoId, status, horaDaChegada);


		return ficha;
	}


	@Override
	String instanceToStringData(Ficha data) {
		return data.getId() + "," + data.getPacienteId() + "," + data.getFichaAcolhimentoId() + "," + data.getStatus() + "," + data.getHoraDaChegada();
	}

	public ArrayList<Ficha> getFichasByStatus(FichaStatus status) {
		ArrayList<Ficha> nArr = new ArrayList<>();
		for (Ficha item : items) {
			if (item.getStatus() == status) {
				nArr.add(item);
			}
		}
		return nArr;
	}

	public ArrayList<Ficha> getFichasByStatusAndEspecialidade(FichaStatus status, MedicoEspecialidade especialidade) {
		ArrayList<Ficha> nArr = new ArrayList<>();
		for (Ficha item : items) {
			if (item.getStatus() == status && item.getFichaAcolhimento().getEspecialidadeNecessaria() == especialidade) {
				nArr.add(item);
			}
		}
		return nArr;
	}
}
