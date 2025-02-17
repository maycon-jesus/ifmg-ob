package ui;

import Atendimento.Ficha;
import Atendimento.FichaAcolhimento;
import Atendimento.PrioridadeManchester;
import Usuarios.Enfermeiro;
import Usuarios.MedicoEspecialidade;
import Usuarios.Paciente;
import db.DBGlobal;

public class TriagemPrompts {

	public static FichaAcolhimento fazerTriagem(Ficha ficha, Paciente paciente, Enfermeiro enfermeiro) {
		ficha.setEmTriagem();

		System.out.println("Criando a Ficha de Acolhimento:\n");

		String sintomas = UI.promptString("Sintomas descritos pelo paciente:");
		String tempoDosSintomas = UI.promptString("Tempo da Sintomas pelo paciente:");
		String doencasPreexistentes = UI.promptString("Doencas preexistentes:");
		String usoDeMedicamento = UI.promptString("Medicamentos que o paciente usa:");
		String jaFezCirurgia = UI.promptString("Cirurgias que o paciente realizou:");
		String alergiaMedicamentoSubstancia = UI.promptString("Alergias que o paciente alega ter:");
		String gravida = UI.promptString("A paciente está grávida:");
		String traumaAcidenteRecente = UI.promptString("Acidentes sofridos pelo paciente:");
		String historicoFamiliar = UI.promptString("Histórico familiar de doenças do paciente:");
		Boolean fumante = UI.promptBoolean("O paciente é fumante:");
		Boolean consomeAlcool = UI.promptBoolean("O paciente faz uso de álcool:");
		String ifoDor = UI.promptString("O paciente alega dor nas referidas partes do corpo:");
		double temperaturaCorporal = UI.promptDouble("A temperatura corporal do paciente:");
		String pressaoSanguinea = UI.promptString("A pressão sanguínea do paciente:");
		int frequenciaCardiaca = UI.promptInt("A frequência cardíaca do paciente:");
		double frequenciaRespiratoria = UI.promptDouble("Frequência respiratória do paciente:");

		int saturacaoDeOxigenio = UI.promptInt("Saturação de oxigênio do paciente:");
		int taxaDeGlicose = UI.promptInt("Taxa de glicose do paciente:");
		boolean consegueAndar = UI.promptBoolean("O paciente consegue andar?");
		String sinaisDeEmergencia = UI.promptString("Sinais de emergência do paciente:");
		String sinaisDeInfeccaoGrave = UI.promptString("O paciente apresenta os seguintes sinais de infecção:");

		// Possivelmente, precisa de conversão para o tipo MedicoEspecialidade
		String especialidadeNecessaria = UI.promptSelectString("Especialidade: ", new String[]{"CLINICO_GERAL", "PEDIATRA", "GINECOLOGISTA"});
		MedicoEspecialidade especialidade = MedicoEspecialidade.valueOf(especialidadeNecessaria);
		int escalaGlasgow = UI.promptIntFromRange("Escala glasgow do paciente:", 3, 15);

		// Precisaria ajustar o tipo de PrioridadeManchester, caso seja necessário
		String prioridadeManchester = UI.promptSelectString("A prioridade do paciente é:", new String[]{"EMERGENCIA", "MUITO_URGENTE", "URGENTE", "POUCO_URGENTE", "NAO_URGENTE"});
		PrioridadeManchester prioridade = PrioridadeManchester.valueOf(prioridadeManchester);

		FichaAcolhimento fichaAcolhimento = new FichaAcolhimento(DBGlobal.fichasAcolhimento.getNextItemId(), paciente.getId(), enfermeiro.getId(), sintomas, tempoDosSintomas, doencasPreexistentes,
				usoDeMedicamento, jaFezCirurgia, alergiaMedicamentoSubstancia, gravida, traumaAcidenteRecente,
				historicoFamiliar, fumante, consomeAlcool, ifoDor, temperaturaCorporal, pressaoSanguinea, frequenciaCardiaca,
				frequenciaRespiratoria, saturacaoDeOxigenio, taxaDeGlicose, consegueAndar, sinaisDeEmergencia, sinaisDeInfeccaoGrave, escalaGlasgow,
				especialidade, prioridade);
		DBGlobal.fichasAcolhimento.insertData(fichaAcolhimento);
		ficha.setTriagemFinalizada(fichaAcolhimento.getId());
		return fichaAcolhimento;
	}
}

