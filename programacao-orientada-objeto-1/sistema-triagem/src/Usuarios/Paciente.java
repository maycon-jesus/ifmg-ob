package Usuarios;


import java.util.Date;

public class Paciente extends Pessoa {

   Date dataNascimento;
   String sexo;
   String nomeMae;
    String endereco;
    String email;
    String nacinalidade
    String telefone;
    String cartaoDoSus;

    public Paciente(int id, String nomeCompleto, String cpf, Date dataNascimento, String sexo, String nomeMae, String endereco, String email, String nacinalidade, String telefone, String cartaoDoSus) {
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

    public Date getDataNascimento() {
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
}
