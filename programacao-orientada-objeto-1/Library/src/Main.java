import Library.Prompts;
import Library.Users.Librarian;
import Library.Users.Student;
import Library.Users.User;
import Utils.Input;

public class Main {
	private static User userLogged = null;

	public static void loginMenu() {
		System.out.println("Selecione uma opção:");
		System.out.println("1 - Entrar no sistema");
		System.out.println("0  - Sair");
		int optionSelected = Input.inputMenu(0, 1);
		if (optionSelected == 1) {
			Main.userLogged = Prompts.Login();
			appMenu();
			userLogged = null;
		} else {
			System.exit(0);
		}

	}

	public static void appMenu() {
		System.out.println("Selecione uma opção:");
		System.out.println("1 - Consultar informações de uma obra");
		if (userLogged instanceof Student) System.out.println("2 - Pegar obra emprestada");
		if (userLogged instanceof Librarian) {
			System.out.println("3 - Registrar devolução");
			System.out.println("5 - Relatório de obras emprestadas");
			System.out.println("6 - Relatório de usuários com atrasos");
			System.out.println("7 - Registrar um aluno");
			System.out.println("8 - Registrar um professor");
			System.out.println("9 - Registrar um bibliotecário");
		}

		System.out.println("0 - Logout");
		int optionSelected = Input.inputMenu(0, 9);
		switch (optionSelected) {
			case 1:
				Prompts.getBookInfo();
				break;
			case 7: {
				if (!(userLogged instanceof Librarian)) {
					System.out.println("Opção inválida!");
					break;
				}
				Prompts.registerStudent();
				break;
			}
			case 8: {
				if (!(userLogged instanceof Librarian)) {
					System.out.println("Opção inválida!");
					break;
				}
				Prompts.registerTeatcher();
				break;
			}
			case 9: {
				if (!(userLogged instanceof Librarian)) {
					System.out.println("Opção inválida!");
					break;
				}
				Prompts.registerLibrarian();
				break;
			}
		}

		if (optionSelected != 0) {
			appMenu();
		}
	}

	public static void main(String[] args) {

		Prompts.registerStudent();
		// while (true) {
		//	loginMenu();
		// }

	}
}
