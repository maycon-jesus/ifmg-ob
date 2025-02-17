package Atendimento;

import Usuarios.MedicoEspecialidade;
import db.DBItem;

public class FichaAcolhimento extends DBItem {
	//int id;
	int pacienteId;
	int enfermeiroId;
	String sintomas;
	String tempoDosSintomas;
	String doencasPreExistentes;
	String usoDeMedicamento;
	String jaFezCirurgia;
	String alergiaMedicamentoSubstancia;
	String gravida;
	String traumaAcidenteRecente;
	String historicoFamiliar;
	Boolean fumante;
	Boolean consomeAlcool;
	String infoDor;
	double temperaturaCorporal;
	String pressaoSanguinea;
	int frequeciaCardiaca;
	double frequenciaRespiratoria;
	int saturacaoDeOxigenio;
	int taxaDeGlicose;
	boolean consegueAndar;
	String sinaisDeEmergencia;
	String sinaisDeInfeccaoGrave;
	int escalaGlasgow;
	MedicoEspecialidade especialidadeNecessaria;
	PrioridadeManchester prioridade;

	public FichaAcolhimento(int id, int pacienteId, int enfermeiroId, String sintomas, String tempoDosSintomas, String doencasPreExistentes, String usoDeMedicamento, String jaFezCirurgia, String alergiaMedicamentoSubstancia, String gravida, String traumaAcidenteRecente, String historicoFamiliar, Boolean fumante, Boolean consomeAlcool, String infoDor, double temperaturaCorporal, String pressaoSanguinea, int frequeciaCardiaca, double frequenciaRespiratoria, int saturacaoDeOxigenio, int taxaDeGlicose, boolean consegueAndar, String sinaisDeEmergencia, String sinaisDeInfeccaoGrave, int escalaGlasgow, MedicoEspecialidade especialidadeNecessaria, PrioridadeManchester prioridade) {
		super(id);
		this.pacienteId = pacienteId;
		this.enfermeiroId = enfermeiroId;
		this.sintomas = sintomas;
		this.tempoDosSintomas = tempoDosSintomas;
		this.doencasPreExistentes = doencasPreExistentes;
		this.usoDeMedicamento = usoDeMedicamento;
		this.jaFezCirurgia = jaFezCirurgia;
		this.alergiaMedicamentoSubstancia = alergiaMedicamentoSubstancia;
		this.gravida = gravida;
		this.traumaAcidenteRecente = traumaAcidenteRecente;
		this.historicoFamiliar = historicoFamiliar;
		this.fumante = fumante;
		this.consomeAlcool = consomeAlcool;
		this.infoDor = infoDor;
		this.temperaturaCorporal = temperaturaCorporal;
		this.pressaoSanguinea = pressaoSanguinea;
		this.frequeciaCardiaca = frequeciaCardiaca;
		this.frequenciaRespiratoria = frequenciaRespiratoria;
		this.saturacaoDeOxigenio = saturacaoDeOxigenio;
		this.taxaDeGlicose = taxaDeGlicose;
		this.consegueAndar = consegueAndar;
		this.sinaisDeEmergencia = sinaisDeEmergencia;
		this.sinaisDeInfeccaoGrave = sinaisDeInfeccaoGrave;
		this.escalaGlasgow = escalaGlasgow;
		this.especialidadeNecessaria = especialidadeNecessaria;
		this.prioridade = prioridade;
	}

	public PrioridadeManchester getPrioridade() {
		return prioridade;
	}

	public int getPacienteId() {
		return pacienteId;
	}

	public int getEnfermeiroId() {
		return enfermeiroId;
	}

	public String getSintomas() {
		return sintomas;
	}

	public String getTempoDosSintomas() {
		return tempoDosSintomas;
	}

	public String getDoencasPreExistentes() {
		return doencasPreExistentes;
	}

	public String getUsoDeMedicamento() {
		return usoDeMedicamento;
	}

	public String getJaFezCirurgia() {
		return jaFezCirurgia;
	}

	public String getAlergiaMedicamentoSubstancia() {
		return alergiaMedicamentoSubstancia;
	}

	public String getGravida() {
		return gravida;
	}

	public String getTraumaAcidenteRecente() {
		return traumaAcidenteRecente;
	}

	public String getHistoricoFamiliar() {
		return historicoFamiliar;
	}

	public Boolean getFumante() {
		return fumante;
	}

	public Boolean getConsomeAlcool() {
		return consomeAlcool;
	}

	public String getInfoDor() {
		return infoDor;
	}

	public double getTemperaturaCorporal() {
		return temperaturaCorporal;
	}

	public String getPressaoSanguinea() {
		return pressaoSanguinea;
	}

	public int getFrequeciaCardiaca() {
		return frequeciaCardiaca;
	}

	public double getFrequenciaRespiratoria() {
		return frequenciaRespiratoria;
	}

	public int getSaturacaoDeOxigenio() {
		return saturacaoDeOxigenio;
	}

	public int getTaxaDeGlicose() {
		return taxaDeGlicose;
	}

	public boolean isConsegueAndar() {
		return consegueAndar;
	}

	public String getSinaisDeEmergencia() {
		return sinaisDeEmergencia;
	}

	public String getSinaisDeInfeccaoGrave() {
		return sinaisDeInfeccaoGrave;
	}

	public MedicoEspecialidade getEspecialidadeNecessaria() {
		return especialidadeNecessaria;
	}

	public int getEscalaGlasgow() {
		return escalaGlasgow;
	}

	public int getPrioridadeInt() {
		switch (this.prioridade) {
			case EMERGENCIA -> {
				return 5;
			}
			case MUITO_URGENTE -> {
				return 4;
			}
			case URGENTE -> {
				return 3;
			}
			case POUCO_URGENTE -> {
				return 2;
			}
			case NAO_URGENTE -> {
				return 1;
			}
		}
		return 0;
	}

	public void exibirInformacoes() {
		System.out.println("ID: " + getId());
		System.out.println("Paciente ID: " + getPacienteId());
		System.out.println("Enfermeiro ID: " + getEnfermeiroId());
		System.out.println("Sintomas: " + getSintomas());
		System.out.println("Tempo dos Sintomas: " + getTempoDosSintomas());
		System.out.println("Doenças Pré-Existentes: " + getDoencasPreExistentes());
		System.out.println("Uso de Medicamento: " + getUsoDeMedicamento());
		System.out.println("Já Fez Cirurgia: " + getJaFezCirurgia());
		System.out.println("Alergia a Medicamento/Substância: " + getAlergiaMedicamentoSubstancia());
		System.out.println("Grávida: " + getGravida());
		System.out.println("Trauma/Acidente Recente: " + getTraumaAcidenteRecente());
		System.out.println("Histórico Familiar: " + getHistoricoFamiliar());
		System.out.println("Fumante: " + getFumante());
		System.out.println("Consome Álcool: " + getConsomeAlcool());
		System.out.println("Informações sobre Dor: " + getInfoDor());
		System.out.println("Temperatura Corporal: " + getTemperaturaCorporal());
		System.out.println("Pressão Sanguínea: " + getPressaoSanguinea());
		System.out.println("Frequência Cardíaca: " + getFrequeciaCardiaca());
		System.out.println("Frequência Respiratória: " + getFrequenciaRespiratoria());
		System.out.println("Saturação de Oxigênio: " + getSaturacaoDeOxigenio());
		System.out.println("Taxa de Glicose: " + getTaxaDeGlicose());
		System.out.println("Consegue Andar: " + isConsegueAndar());
		System.out.println("Sinais de Emergência: " + getSinaisDeEmergencia());
		System.out.println("Sinais de Infecção Grave: " + getSinaisDeInfeccaoGrave());
		System.out.println("Escala de Glasgow: " + getEscalaGlasgow());
		System.out.println("Especialidade Necessária: " + getEspecialidadeNecessaria());
		System.out.println("Prioridade: " + getPrioridade());
	}
}