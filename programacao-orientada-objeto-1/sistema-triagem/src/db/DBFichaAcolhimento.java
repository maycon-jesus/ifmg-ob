package db;

import Atendimento.FichaAcolhimento;
import Atendimento.PrioridadeManchester;
import Usuarios.MedicoEspecialidade;

public class DBFichaAcolhimento extends DBManager<FichaAcolhimento> {

	public DBFichaAcolhimento() {
		super("db/fichaacolhimento", "id, pacienteId, enfermeiroId, Sintomas,tempoDosSintomas, doencasPreExistentes,usoDeMedicamento, jaFezCirurgia, AlergiaMedicamentoSubstancia, gravida, traumaAcidenteRecente, historicoFamiliar, fumante,consomeAlcool, infoDor, temperaturaCorporal, pressaoSanguinea, frequeciaCardiaca,frequenciaRespiratoria,saturacaoDeOxigenio, taxaDeGlicose, consegueAndar, sinaisDeEmergencia, sinaisDeInfeccaoGrave, escalaGlasgow, especialidadeNecessaria, prioridade", 10);
	}

	@Override
	FichaAcolhimento createInstaceOfData(String[] dataArr) {
		int id = Integer.parseInt(dataArr[0]);
		int pacienteId = Integer.parseInt(dataArr[1]);
		int enfermeiroId = Integer.parseInt(dataArr[2]);
		String sintomas = dataArr[3];
		String tempoDosSintomas = dataArr[4];
		String doencasPreExistentes = dataArr[5];
		String usoDeMedicamento = dataArr[6];
		String jaFezCirurgia = dataArr[7];
		String alergiaMedicamentoSubstancia = dataArr[8];
		String gravida = dataArr[9];
		String traumaAcidenteRecente = dataArr[10];
		String historicoFamiliar = dataArr[11];
		boolean fumante = dataArr[12].equals("1");
		boolean consomeAlcool = dataArr[13].equals("1");
		String infoDor = dataArr[14];
		Double temperaturaCorporal = Double.parseDouble(dataArr[15]);
		String pressaoSanguinea = dataArr[16];
		int frequeciaCardiaca = Integer.parseInt(dataArr[17]);
		Double frequeciaRespiratoria = Double.parseDouble(dataArr[18]);
		int saturacaoDeOxigenio = Integer.parseInt(dataArr[19]);
		int taxaDeGlicose = Integer.parseInt(dataArr[0]);
		boolean consegueAndar = dataArr[21].equals("1");
		String sinaisDeEmergencia = dataArr[22];
		String sinaisDeInfeccaoGrave = dataArr[23];
		int escalaGlasgow = Integer.parseInt(dataArr[24]);
		MedicoEspecialidade especialidadeNecessaria = MedicoEspecialidade.valueOf(dataArr[25]);
		PrioridadeManchester prioridade = PrioridadeManchester.valueOf(dataArr[26]);

		FichaAcolhimento fichaacolhimento = new FichaAcolhimento(
				id, pacienteId, enfermeiroId, sintomas, tempoDosSintomas, doencasPreExistentes,
				usoDeMedicamento, jaFezCirurgia, alergiaMedicamentoSubstancia,
				gravida, traumaAcidenteRecente, historicoFamiliar, fumante, consomeAlcool, infoDor, temperaturaCorporal, pressaoSanguinea, frequeciaCardiaca, frequeciaRespiratoria,
				saturacaoDeOxigenio, taxaDeGlicose, consegueAndar, sinaisDeEmergencia, sinaisDeInfeccaoGrave, escalaGlasgow, especialidadeNecessaria, prioridade
		);


		return fichaacolhimento;
	}

	@Override
	String instanceToStringData(FichaAcolhimento data) {
		return data.getId() + "," + data.getPacienteId() + "," + data.getEnfermeiroId() + "," + data.getSintomas() + "," +
				data.getTempoDosSintomas() + "," + data.getDoencasPreExistentes() + "," +
				data.getUsoDeMedicamento() + "," + data.getJaFezCirurgia() + "," +
				data.getAlergiaMedicamentoSubstancia() + "," + data.getGravida() + "," +
				data.getTraumaAcidenteRecente() + "," + data.getHistoricoFamiliar() + "," +
				(data.getFumante() ? "1" : "0") + "," + (data.getConsomeAlcool() ? "1" : "0") + "," +
				data.getInfoDor() + "," + data.getTemperaturaCorporal() + "," + data.getPressaoSanguinea() + "," +
				data.getFrequeciaCardiaca() + "," + data.getFrequenciaRespiratoria() + "," +
				data.getSaturacaoDeOxigenio() + "," + data.getTaxaDeGlicose() + "," +
				(data.isConsegueAndar() ? "1" : "0") + "," + data.getSinaisDeEmergencia() + "," +
				data.getSinaisDeInfeccaoGrave() + "," + data.getEscalaGlasgow() + "," + data.getEspecialidadeNecessaria().name() + "," +
				data.getPrioridade().name();
	}


	public FichaAcolhimento getFichaAcolhimentoById(int id) {
		for (FichaAcolhimento ficha : this.items) {
			if (ficha.getId() == id) {
				return ficha;
			}
		}
		return null;
	}
}
