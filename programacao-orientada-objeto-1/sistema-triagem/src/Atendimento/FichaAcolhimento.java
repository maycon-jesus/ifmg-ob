package Atendimento;

import Usuarios.MedicoEspecialidade;
import db.DBItem;

public class FichaAcolhimento extends DBItem {
	//int id;
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
	MedicoEspecialidade especialidadeNecessaria;
	PrioridadeManchester prioridade;

	public FichaAcolhimento(int id, int enfermeiroId, String sintomas, String tempoDosSintomas, String doencasPreExistentes, String usoDeMedicamento, String jaFezCirurgia, String alergiaMedicamentoSubstancia, String gravida, String traumaAcidenteRecente, String historicoFamiliar, Boolean fumante, Boolean consomeAlcool, String infoDor, double temperaturaCorporal, String pressaoSanguinea, int frequeciaCardiaca, double frequenciaRespiratoria, int saturacaoDeOxigenio, int taxaDeGlicose, boolean consegueAndar, String sinaisDeEmergencia, String sinaisDeInfeccaoGrave, MedicoEspecialidade especialidadeNecessaria, PrioridadeManchester prioridade) {
		super(id);
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
		this.especialidadeNecessaria = especialidadeNecessaria;
		this.prioridade = prioridade;
	}
}