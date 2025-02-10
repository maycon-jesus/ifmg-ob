package db;

import Usuarios.*;
import utils.StringReplacer;

public class DBPessoas extends DBManager<Pessoa> {

	public DBPessoas() {
		super("db/pessoas", "id, nome-completo, cpf, tipo-pessoa, coren, especialidade, consultorio, crm", 10);
	}

	@Override
	Pessoa createInstaceOfData(String[] dataArr) {
		int id = Integer.parseInt(dataArr[0]);
		String nome = dataArr[1];
		String cpf = dataArr[2];
		UserType userType = UserType.valueOf(dataArr[3]);
		if (userType.equals(UserType.ENFERMEIRO)) {
			String coren = dataArr[4];
			return new Enfermeiro(id, nome, cpf, coren);
		}else if(userType.equals(UserType.MEDICO)){
			MedicoEspecialidade especialidade = MedicoEspecialidade.valueOf(dataArr[4]);
			String consultorio = dataArr[5];
			String crm = dataArr[6];
			return new Medico(id, nome, cpf, especialidade, consultorio, crm);
		}
		return null;
	}

	@Override
	String instanceToStringData(Pessoa data) {
		int id = data.getId();
		String nomeCompleto = data.getNomeCompleto();
		String cpf = data.getCpf();
		String tipoPessoa = data.getTipoPessoa().toString();
		if (data instanceof Enfermeiro enfermeiro) {
			String coren = enfermeiro.getCoren();
			return StringReplacer.dbLineMaker("{0},{1},{2},{3},{4},null,null,null", new String[]{String.valueOf(id), nomeCompleto, cpf, tipoPessoa, coren});
		} else if (data instanceof Medico medico) {
			String especialidade = medico.getEspecialidade().toString();
			String consultorio = medico.getConsultorio();
			String crm = medico.getCrm();
			return StringReplacer.dbLineMaker("{0},{1},{2},{3},null,{4},{5},{6}", new String[]{String.valueOf(id), nomeCompleto, cpf, tipoPessoa, especialidade, consultorio, crm});
		}
		return "null,null,null,null,null";
	}
}
