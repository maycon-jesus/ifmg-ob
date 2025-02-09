package Usuarios;

import Atendimento.Ficha;

public class Medico extends Pessoa implements Atender {
	private MedicoEspecialidade especialidade;
	private String consultorio;
	private String crm;

	public Medico(int id, String nomeCompleto, String cpf, UserType tipoPessoa, MedicoEspecialidade especialidade, String consultorio, String crm) {
		super(id, nomeCompleto, cpf, tipoPessoa);
		this.especialidade = especialidade;
		this.consultorio = consultorio;
		this.crm = crm;
	}

	@Override
	public void atender(Ficha ficha) {

	}

	@Override
	public void finalizarAtendimento(Ficha ficha) {

	}
}
