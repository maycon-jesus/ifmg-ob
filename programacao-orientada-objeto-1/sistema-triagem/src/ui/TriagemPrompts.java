package ui;

import Usuarios.MedicoEspecialidade;

public class TriagemPrompts {

    public static void fazerTriagem() {

        System.out.println("Criando a Ficha de Acolhimento:\n");
        String nomeCompleto = UI.promptString("Nome completo: ");

        String sintomas = UI.promptString("Sintomas descritos pelo paciente:");
        String usoDeMedicamento = UI.promptString("Medicamentos que o paciente usa:");
        String jaFezCirurgia = UI.promptString("Cirurgias que o paciente realizou:");
        String alergiaMedicamentoSubstancia = ("Alegias que o paciente alega ter:");
        boolean gravida = UI.promptBoolean("A Paciente está grávida:");
        String traumaAcidenteRecente = UI.promptString("Acidentes sofridos pelo paciente:");
        String historicoFamiliar = UI.promptString("Histórico familiar de doenças do paciente:");
        Boolean fumante = UI.promptBoolean("O paciente é fumante:");
        Boolean consomeAlcool = UI.promptBoolean("O paciente faz uso de álcool:");
        String historiocoFamiliar = UI.promptString("O paciente alega ter as doenças abaixo citadas em sua família:");
        String ifoDor = UI.promptString("O paciente alegar dor nas referidas partes do corpo:");

        double temperaturaCorporal = UI.promptString("A temperatura corporal do paciente:");
        String pressaoSanguinea = UI.promptString("");
        int frequeciaCardiaca = UI.promptString("");
        double frequenciaRespiratoria = UI.promptString("");
        int saturacaoDeOxigenio = UI.promptString("");
        int taxaDeGlicose = UI.promptString("");
        boolean consegueAndar = UI.promptString("");
        String sinaisDeEmergencia = UI.promptString("");
        String sinaisDeInfeccaoGrave = UI.promptString("");
        MedicoEspecialidade especialidadeNecessaria = UI.promptString("O paciente necessita de uma especialidade específica:");
        PrioridadeManchester prioridade = UI.promptString("");


    }


}
