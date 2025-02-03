package Library;

import DB.DBGlobal;
import Library.Collection.Book;
import Library.Users.User;
import Library.Users.UserType;

import java.util.Scanner;

public class Prompts {

	static public User Login() {

		String email;
		String password;

		Scanner sc = new Scanner(System.in);
		System.out.println("e-mail:");
		email = sc.nextLine();

		System.out.println("senha: ");
		password = sc.nextLine();

		User user = DBGlobal.users.getUserByMail(email);
		if (user == null) {
			System.out.println("Senha incorreta!");
			return Login();
		}
		if (!user.getPassword().equals(password)) {
			System.out.println("Senha incorreta!");
			return Login();
		}
		return user;
	}

	static public Book promptBook() {
		Scanner sc = new Scanner(System.in);
		for (Book book : DBGlobal.books.getBooks()) {
			System.out.println(book.getId() + " " + book.getTitulo());
		}
		System.out.println("Digite o nome ou id do Livro: ");
		String title = sc.nextLine();
		for (Book book : DBGlobal.books.getBooks()) {
			if (book.getTitulo().equalsIgnoreCase(title)) {
				return book;
			}
			if ((String.valueOf(book.getId())).equalsIgnoreCase(title)) {
				return book;
			}
		}
		return promptBook();
	}

	static public void getBookInfo() {
		System.out.println("Digite o nome do Livro: ");
		Book book = promptBook();
		System.out.println("====[ INFORMAÇÕES DA OBRA ]====");
		System.out.println("ID: " + book.getId());
		System.out.println("Titulo: " + book.getTitulo());
		System.out.println("Quantidade total: " + book.getQuantidade());
		System.out.println("Quantidade disponível: " + book.getAvailableQuantity());
	}

	public static void registerStudent() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome do Estudante: ");
		String name = sc.nextLine();

		System.out.println("Digite o e-mail: ");
		String email = sc.nextLine();

		System.out.println("Digite a senha:");
		String password = sc.nextLine();

		System.out.println("Digite a matrícula: ");
		String registration = sc.nextLine();

		System.out.println("Digite o curso: ");
		String course = sc.nextLine();

		DBGlobal.users.newStudents(name, email, password, UserType.STUDENT, registration, course);
	}

	public static void registerTeatcher() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome do professor: ");
		String name = sc.nextLine();

		System.out.println("Digite o e-mail: ");
		String email = sc.nextLine();

		System.out.println("Digite a senha:");
		String password = sc.nextLine();

		System.out.println("Digite o departamento: ");
		String department = sc.nextLine();

		DBGlobal.users.newTeatcher(name, email, password, UserType.STUDENT, department, course);
	}

	public static void registerLibrarian() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome do bibliotecario: ");
		String name = sc.nextLine();

		System.out.println("Digite o e-mail: ");
		String email = sc.nextLine();

		System.out.println("Digite a senha:");
		String password = sc.nextLine();

		System.out.println("Digite o número de celular: ");
		String cellphone = sc.nextLine();


		DBGlobal.users.newLibrarian(name, email, password, UserType.LIBRARIAN, cellphone, 0);
	}

	public static void loan(User user) {
		Book book = promptBook();
		if (book.getAvailableQuantity() <= 0) {
			System.out.println("Este livro não possui nenhuma cópia disponível!!!");
			return;
		}
		DBGlobal.loans.registerLoan();
	}
}
