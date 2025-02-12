package Usuarios;

import Atendimento.Ficha;

public class Enfermeiro extends Pessoa implements Atender {
	private String coren;
	private String consultorio;

	public Enfermeiro(int id, String nomeCompleto, String cpf, String coren, String consultorio) {
		super(id, nomeCompleto, cpf, UserType.ENFERMEIRO);
		this.coren = coren;
		this.consultorio = consultorio;
	}

	@Override
	public void atender(Ficha ficha) {

	}

	@Override
	public void finalizarAtendimento(Ficha ficha) {

	}

	public String getCoren() {
		return coren;
	}

	public String getConsultorio() {
		return consultorio;
	}
}
