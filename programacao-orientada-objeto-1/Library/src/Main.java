import Library.Prompts;
import Library.Users.Librarian;
import Library.Users.Student;
import Library.Users.Teacher;
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
		if (userLogged instanceof Student || userLogged instanceof Teacher)
			System.out.println("2 - Pegar obra emprestada");
		if (userLogged instanceof Librarian) {
			System.out.println("3 - Registrar devolução");
			System.out.println("4 - Relatório de obras emprestadas");
			System.out.println("5 - Relatório de usuários com atrasos");
			System.out.println("6 - Registrar um aluno");
			System.out.println("7 - Registrar um professor");
			System.out.println("8 - Registrar um bibliotecário");
		}

		System.out.println("0 - Logout");
		int optionSelected = Input.inputMenu(0, 9);
		switch (optionSelected) {
			case 1:
				Prompts.getBookInfo();
				break;
			case 2: {
				if (userLogged instanceof Librarian) {
					System.out.println("Opção inválida!");
					break;
				}
				Prompts.loanBook(userLogged);
				break;
			}
			case 3: {
				if (userLogged instanceof Librarian) {
					Prompts.returnLoan((Librarian) userLogged);
				} else {
					System.out.println("Opção inválida!");
				}
				break;
			}
			case 4, 5: {
				if (userLogged instanceof Librarian) {
					Prompts.reportLoans();
				} else {
					System.out.println("Opção inválida!");
				}
				break;
			}
			case 6: {
				if (!(userLogged instanceof Librarian)) {
					System.out.println("Opção inválida!");
					break;
				}
				Prompts.registerStudent();
				break;
			}
			case 7: {
				if (!(userLogged instanceof Librarian)) {
					System.out.println("Opção inválida!");
					break;
				}
				Prompts.registerTeacher();
				break;
			}
			case 8: {
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

		while (true) {
			loginMenu();
		}

	}
}
