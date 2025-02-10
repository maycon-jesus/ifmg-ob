package Usuarios;

import Atendimento.Ficha;
import db.DBGlobal;

public class Enfermeiro extends Pessoa implements Atender {
	String coren;

	public Enfermeiro(int id, String nomeCompleto, String cpf, String coren) {
		super(id, nomeCompleto, cpf, UserType.ENFERMEIRO);
		this.coren = coren;
		DBGlobal.pessoas.insertData(this);
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
