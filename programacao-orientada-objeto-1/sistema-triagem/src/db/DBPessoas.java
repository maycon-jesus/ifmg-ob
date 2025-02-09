package db;

import Usuarios.Enfermeiro;
import Usuarios.Pessoa;
import utils.StringReplacer;

public class DBPessoas extends DBManager<Pessoa> {


	public DBPessoas() {
		super("db/pessoas", "id, nome-completo, cpf, tipo-pessoa, coren", 10);
	}

	@Override
	Pessoa createInstaceOfData(String[] dataArr) {
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
			return StringReplacer.dbLineMaker("{0},{1},{2},{3},{4}", new String[]{String.valueOf(id), nomeCompleto, cpf, tipoPessoa, coren});
		}
		return "null,null,null,null,null";
	}
}
