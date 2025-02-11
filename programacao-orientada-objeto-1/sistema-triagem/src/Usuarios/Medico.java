package Usuarios;

import Atendimento.Ficha;
import db.DBGlobal;

public class Medico extends Pessoa implements Atender {
	private MedicoEspecialidade especialidade;
	private String consultorio;
	private String crm;

	public Medico(int id, String nomeCompleto, String cpf, MedicoEspecialidade especialidade, String consultorio, String crm) {
		super(id, nomeCompleto, cpf, UserType.MEDICO);
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

	public MedicoEspecialidade getEspecialidade() {
		return especialidade;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public String getCrm() {
		return crm;
	}
}
