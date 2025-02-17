package db;

import Usuarios.*;
import utils.StringReplacer;

import java.time.LocalDate;
import java.util.ArrayList;

public class DBPessoas extends DBManager<Pessoa> {

	public DBPessoas() {
		super("db/pessoas", "id, nome-completo, cpf, tipo-pessoa, coren, especialidade, consultorio, crm, dataNascimento, sexo, nomeMae, endereco, email, nacionalidade, telefone, cartaoDoSus", 10);
	}

	@Override
	Pessoa createInstaceOfData(String[] dataArr) {
		int id = Integer.parseInt(dataArr[0]);
		String nome = dataArr[1];
		String cpf = dataArr[2];
		UserType userType = UserType.valueOf(dataArr[3]);
		if (userType.equals(UserType.ENFERMEIRO)) {
			String coren = dataArr[4];
			String consultorio = dataArr[6];
			return new Enfermeiro(id, nome, cpf, coren, consultorio);
		} else if (userType.equals(UserType.MEDICO)) {
			MedicoEspecialidade especialidade = MedicoEspecialidade.valueOf(dataArr[5]);
			String consultorio = dataArr[6];
			String crm = dataArr[7];
			return new Medico(id, nome, cpf, especialidade, consultorio, crm);
		} else {
			LocalDate dataNascimento = LocalDate.parse(dataArr[8]);
			String sexo = dataArr[9];
			String nomeMae = dataArr[10];
			String endereco = dataArr[11];
			String email = dataArr[12];
			String nacionalidade = dataArr[13];
			String telefone = dataArr[14];
			String cartaoDoSus = dataArr[15];
			return new Paciente(id, nome, cpf, dataNascimento, sexo, nomeMae, endereco, email, nacionalidade, telefone, cartaoDoSus);
		}
	}

	@Override
	String instanceToStringData(Pessoa data) {
		int id = data.getId();
		String nomeCompleto = data.getNomeCompleto();
		String cpf = data.getCpf();
		String tipoPessoa = data.getTipoPessoa().toString();
		if (data instanceof Enfermeiro enfermeiro) {
			String coren = enfermeiro.getCoren();
			String consultorio = enfermeiro.getConsultorio();
			return StringReplacer.dbLineMaker("{0},{1},{2},{3},{4},null,{5},null,null,null,null,null,null,null,null,null", new String[]{String.valueOf(id), nomeCompleto, cpf, tipoPessoa, coren, consultorio});
		} else if (data instanceof Medico medico) {
			String especialidade = medico.getEspecialidade().toString();
			String consultorio = medico.getConsultorio();
			String crm = medico.getCrm();
			return StringReplacer.dbLineMaker("{0},{1},{2},{3},null,{4},{5},{6},null,null,null,null,null,null,null,null", new String[]{String.valueOf(id), nomeCompleto, cpf, tipoPessoa, especialidade, consultorio, crm});
		} else {
			Paciente paciente = (Paciente) data;
			String dataNascimento = paciente.getDataNascimento().toString();
			String sexo = paciente.getSexo();
			String nomeMae = paciente.getNomeMae();
			String endereco = paciente.getEndereco();
			String email = paciente.getEmail();
			String nacionalidade = paciente.getNacinalidade();
			String telefone = paciente.getTelefone();
			String cartaoDoSus = paciente.getCartaoDoSus();
			return StringReplacer.dbLineMaker("{0},{1},{2},{3},null,null,null,null,{4},{5},{6},{7},{8},{9},{10},{11}", new String[]{String.valueOf(id), nomeCompleto, cpf, tipoPessoa, dataNascimento, sexo, nomeMae, endereco, email, nacionalidade, telefone, cartaoDoSus});
		}
	}

	public ArrayList<Enfermeiro> getEnfermeiros() {
		ArrayList<Enfermeiro> enfermeiros = new ArrayList<>();
		for (Pessoa pessoa : items) {
			if (pessoa instanceof Enfermeiro) {
				enfermeiros.add((Enfermeiro) pessoa);
			}
		}
		return enfermeiros;
	}

	public ArrayList<Medico> getMedicos() {
		ArrayList<Medico> medicos = new ArrayList<>();
		for (Pessoa pessoa : items) {
			if (pessoa instanceof Medico) {
				medicos.add((Medico) pessoa);
			}
		}
		return medicos;
	}

	public Paciente getPacienteById(int id) {
		for (Pessoa pessoa : items) {
			if (!pessoa.getTipoPessoa().equals(UserType.PACIENTE)) continue;
			if (pessoa.getId() == id) {
				return (Paciente) pessoa;
			}
		}
		return null;
	}

	public Paciente getPacienteByCpf(String cpf) {
		for (Pessoa pessoa : items) {
			if (!pessoa.getTipoPessoa().equals(UserType.PACIENTE)) continue;
			if (pessoa.getCpf().equals(cpf)) {
				return (Paciente) pessoa;
			}
		}
		return null;
	}
}
