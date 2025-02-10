import Usuarios.Enfermeiro;
import db.DBGlobal;

public class Main {
	public static void main(String[] args) {
		new Enfermeiro(DBGlobal.pessoas.getNextItemId(), "teste", "aaaa", "coren");
		System.out.println("Hello world");
	}
}
