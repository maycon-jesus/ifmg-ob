package db;

import Usuarios.Enfermeiro;
import Usuarios.Medico;
import Usuarios.Pessoa;
import Usuarios.UserType;
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
