package ui;

import Usuarios.Enfermeiro;
import Usuarios.Medico;
import Usuarios.MedicoEspecialidade;
import Usuarios.Paciente;
import db.DBGlobal;

import java.time.LocalDate;

public class PessoaPrompts {
	public static Paciente criarPaciente() {
		System.out.println("Criando um paciente");
		System.out.println("Nome completo: ");
		String nomeCompleto = UI.sc.next();

		System.out.println("CPF (12345678901): ");
		String cpf = UI.sc.next();

		Paciente paciente = DBGlobal.pessoas.getPacienteByCpf(cpf);

		if (paciente != null) {
			paciente.printData();
			boolean changeuser = UI.promptBoolean("Deseja alterar os dados do paciente?");
			if (!changeuser) return paciente;
			return paciente;
		}

		LocalDate dataNascimento = UI.promptLocalDate("Data de nascimento:");
		String sexo = UI.promptSelectString("Sexo: ", new String[]{"Masculino", "Feminino"});
		String nomeMae = UI.promptString("Nome do Mae: ");
		String endereco = UI.promptString("Endereco: ");
		String email = UI.promptString("E-mail: ");
		String nacionalidade = UI.promptString("Nacionalidade: ");
		String telefone = UI.promptString("Telefone: ");
		String cartaoSus = UI.promptString("Cartão do SUS: ");

		paciente = new Paciente(DBGlobal.pessoas.getNextItemId(), nomeCompleto, cpf, dataNascimento, sexo, nomeMae, endereco, email, nacionalidade, telefone, cartaoSus);
		DBGlobal.pessoas.insertData(paciente);

		return paciente;
	}

	public static Enfermeiro criarEnfermeiro() {
		System.out.println("Criando um enfermeiro");
		String nomeCompleto = UI.promptString("Nome completo: ");
		String cpf = UI.promptString("CPF (12345678901): ");
		String coren = UI.promptString("Coren: ");
		Enfermeiro enf = new Enfermeiro(DBGlobal.pessoas.getNextItemId(), nomeCompleto, cpf, coren);
		DBGlobal.pessoas.insertData(enf);
		return enf;
	}

	public static Medico criarMedico() {
		System.out.println("Criando um medico");
		String nomeCompleto = UI.promptString("Nome completo: ");
		String cpf = UI.promptString("CPF (12345678901): ");
		String especialidade = UI.promptSelectString("Especialidade: ", new String[]{"Clinico Geral", "Pediatra", "Ginecolosgista"});
		String consultorio = UI.promptString("Consultorio: ");
		String crm = UI.promptString("CRM: ");
		Medico med = new Medico(DBGlobal.pessoas.getNextItemId(), nomeCompleto, cpf, MedicoEspecialidade.valueOf(especialidade), consultorio, crm);
		DBGlobal.pessoas.insertData(med);
		return med;
	}
}
