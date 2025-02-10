import Usuarios.Enfermeiro;
import Usuarios.Medico;
import Usuarios.MedicoEspecialidade;
import db.DBGlobal;

public class Main {
	public static void main(String[] args) {
		Enfermeiro a = new Enfermeiro(DBGlobal.pessoas.getNextItemId(), "teste", "aaaa", "coren");
		DBGlobal.pessoas.insertData(a);
		Medico b = new Medico(DBGlobal.pessoas.getNextItemId(), "medico", "cpf", MedicoEspecialidade.CLINICO_GERAL, "sala 1", "123-4");
		DBGlobal.pessoas.insertData(b);
		System.out.println("Hello world");
	}
}
