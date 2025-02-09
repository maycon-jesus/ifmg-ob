package Usuarios;

import db.DBItem;

public abstract class Pessoa extends DBItem {
	private String nomeCompleto;
	private String cpf;
	private UserType tipoPessoa;

	protected Pessoa(int id, String nomeCompleto, String cpf, UserType tipoPessoa) {
		super(id);
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.tipoPessoa = tipoPessoa;
	}

	public UserType getTipoPessoa() {
		return tipoPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
}
