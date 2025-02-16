package Usuarios;


import utils.PrintData;

import java.time.LocalDate;

public class Paciente extends Pessoa implements PrintData {

	LocalDate dataNascimento;
	String sexo;
	String nomeMae;
	String endereco;
	String email;
	String nacinalidade;
	String telefone;
	String cartaoDoSus;

	public Paciente(int id, String nomeCompleto, String cpf, LocalDate dataNascimento, String sexo, String nomeMae, String endereco, String email, String nacinalidade, String telefone, String cartaoDoSus) {
		super(id, nomeCompleto, cpf, UserType.PACIENTE);
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.nomeMae = nomeMae;
		this.endereco = endereco;
		this.email = email;
		this.nacinalidade = nacinalidade;
		this.telefone = telefone;
		this.cartaoDoSus = cartaoDoSus;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

	public String getNacinalidade() {
		return nacinalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCartaoDoSus() {
		return cartaoDoSus;
	}

	@Override
	public void printData() {
		System.out.println("Nome: " + getNomeCompleto());
		System.out.println("CPF: " + getCpf());
		System.out.println("Data de Nascimento: " + getDataNascimento());
		System.out.println("Sexo: " + getSexo());
		System.out.println("NomeMae: " + getNomeMae());
		System.out.println("Endereco: " + getEndereco());
		System.out.println("Email: " + getEmail());
		System.out.println("Nacinalidade: " + getNacinalidade());
		System.out.println("Telefone: " + getTelefone());
		System.out.println("Cartao do Sus: " + getCartaoDoSus());
	}

	public int getIdade() {
		int anos = LocalDate.now().getYear() - this.dataNascimento.getYear();
		if (LocalDate.now().getDayOfYear() > this.dataNascimento.getDayOfYear()) {
			anos++;
		}
		return anos;
	}
}
