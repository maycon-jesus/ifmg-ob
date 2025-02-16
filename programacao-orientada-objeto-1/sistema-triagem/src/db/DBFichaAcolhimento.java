package db;

import Atendimento.FichaAcolhimento;
import Atendimento.PrioridadeManchester;
import Usuarios.MedicoEspecialidade;

public class DBFichaAcolhimento extends DBManager<FichaAcolhimento> {

	public DBFichaAcolhimento() {
		super("db/fichaacolhimento", "id, enfermeiroId, Sintomas,tempoDosSintomas, doencasPreExistentes,usoDeMedicamento, jaFezCirurgia, AlergiaMedicamentoSubstancia, gravida, traumaAcidenteRecente, historicoFamiliar, fumante,consomeAlcool, infoDor, temperaturaCorporal, pressaoSanguinea, frequeciaCardiaca,frequenciaRespiratoria,saturacaoDeOxigenio, taxaDeGlicose, consegueAndar, sinaisDeEmergencia, sinaisDeInfeccaoGrave, especialidadeNecessaria, prioridade", 10);
	}

	@Override
	FichaAcolhimento createInstaceOfData(String[] dataArr) {
		int id = Integer.parseInt(dataArr[0]);
		int enfermeiroId = Integer.parseInt(dataArr[1]);
		String sintomas = dataArr[2];
		String tempoDosSintomas = dataArr[3];
		String doencasPreExistentes = dataArr[4];
		String usoDeMedicamento = dataArr[5];
		String jaFezCirurgia = dataArr[6];
		String alergiaMedicamentoSubstancia = dataArr[7];
		String gravida = dataArr[8];
		String traumaAcidenteRecente = dataArr[9];
		String historicoFamiliar = dataArr[10];
		boolean fumante = dataArr[11].equals("1");
		boolean consomeAlcool = dataArr[12].equals("1");
		String infoDor = dataArr[13];
		Double temperaturaCorporal = Double.parseDouble(dataArr[14]);
		String pressaoSanguinea = dataArr[15];
		int frequeciaCardiaca = Integer.parseInt(dataArr[16]);
		int frequeciaRespiratoria = Integer.parseInt(dataArr[17]);
		int saturacaoDeOxigenio = Integer.parseInt(dataArr[18]);
		int taxaDeGlicose = Integer.parseInt(dataArr[19]);
		boolean consegueAndar = dataArr[20].equals("1");
		String sinaisDeEmergencia = dataArr[21];
		String sinaisDeInfeccaoGrave = dataArr[22];
		MedicoEspecialidade especialidadeNecessaria = MedicoEspecialidade.valueOf(dataArr[23]);
		PrioridadeManchester prioridade = PrioridadeManchester.valueOf(dataArr[24]);

		FichaAcolhimento fichaacolhimento = new FichaAcolhimento(
				id, enfermeiroId, sintomas, tempoDosSintomas, doencasPreExistentes,
				usoDeMedicamento, jaFezCirurgia, alergiaMedicamentoSubstancia,
				gravida, traumaAcidenteRecente, historicoFamiliar, fumante, consomeAlcool, infoDor, temperaturaCorporal, pressaoSanguinea, frequeciaCardiaca, frequeciaRespiratoria,
				saturacaoDeOxigenio, taxaDeGlicose, consegueAndar, sinaisDeEmergencia, sinaisDeInfeccaoGrave, especialidadeNecessaria, prioridade
		);


		return fichaacolhimento;
	}

	@Override
	String instanceToStringData(FichaAcolhimento data) {
		return "";
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
