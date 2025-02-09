package Usuarios;

import Atendimento.Ficha;

public class Enfermeiro extends Pessoa implements Atender {
	String coren;

	public Enfermeiro(int id, String nomeCompleto, String cpf, UserType tipoPessoa, String coren) {
		super(id, nomeCompleto, cpf, tipoPessoa);
		this.coren = coren;
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
}
