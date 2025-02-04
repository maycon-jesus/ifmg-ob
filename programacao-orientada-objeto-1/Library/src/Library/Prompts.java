package Library;

import DB.DBGlobal;
import Library.Collection.Book;
import Library.Collection.Loan;
import Library.Collection.LoanStatus;
import Library.Users.*;
import Utils.Input;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

	static public User promptUserByEmail() {
		User user = null;
		while (user == null) {
			System.out.println("Digite o email do aluno/professor:");
			String email = Input.inputString();
			user = DBGlobal.users.getUserByMail(email);
			if (user == null) {
				continue;
			}
			if (user instanceof Librarian) user = null;
		}
		return user;
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
		System.out.println("Estudante cadastrado com sucesso!");
	}

	public static void registerTeacher() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome do professor: ");
		String name = sc.nextLine();

		System.out.println("Digite o e-mail: ");
		String email = sc.nextLine();

		System.out.println("Digite a senha:");
		String password = sc.nextLine();

		System.out.println("Digite o departamento: ");
		String department = sc.nextLine();

		DBGlobal.users.newTeacher(name, email, password, UserType.STUDENT, department);
		System.out.println("Professor cadastrado com sucesso!");
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
		System.out.println("Bibliotecario cadastrado com sucesso!");
	}

	public static Loan promptLoanByUser(User user, String msg) {
		ArrayList<Loan> loans = DBGlobal.loans.getLoansByUserAndStatus(user, LoanStatus.BORROWED);
		if (loans.size() == 0) return null;
		for (int i = 0; i < loans.size(); i++) {
			Loan loan = loans.get(i);
			Book book = DBGlobal.books.getBookById(loan.getBookId());
			System.out.println(i + " - " + book.getId() + " - " + book.getTitulo());
		}
		System.out.println(msg);
		int option = Input.inputMenu(0, loans.size());
		return loans.get(option);
	}

	public static void loanBook(User user) {
		Book book = promptBook();
		if (book.getAvailableQuantity() <= 0) {
			System.out.println("Este livro não possui nenhuma cópia disponível!!!");
			return;
		}
		ArrayList<Loan> loans = DBGlobal.loans.getLoansByUserAndStatus(user, LoanStatus.BORROWED);
		if (user instanceof Teacher && loans.size() >= 10) {
			System.out.println("Não foi possível concluir o emprestimo pois você atingiu o limite de 10 emprestimos!!!");
			return;
		}
		if (user instanceof Student && loans.size() >= 2) {
			System.out.println("Não foi possível concluir o emprestimo pois você atingiu o limite de 2 emprestimos!!!");
			return;
		}

		DBGlobal.loans.registerLoan(book.getId(), user.getId());
		System.out.println("Obra emprestada com sucesso!");
	}

	public static void returnLoan(Librarian librarian) {
		User user = promptUserByEmail();
		Loan loan = promptLoanByUser(user, "Qual livro você deseja devolver?");
		if (loan == null) {
			System.out.println("Este usuário não possui nenhuma obra emprestada!!!");
			return;
		}
		librarian.incrementTotalReturns();
		loan.setReturned();
		DBGlobal.users.onUpdateData(librarian);
		DBGlobal.loans.onUpdateData(loan);
		System.out.println("Obra devolvida com sucesso!");
	}

	public static void reportLoans() {
		ArrayList<Loan> loans = DBGlobal.loans.getLoansByStatus(LoanStatus.BORROWED);
		File file = new File("loans-report.txt");
		try {
			FileWriter writter = new FileWriter(file);
			file.createNewFile();
			BufferedWriter bufferedWriter = new BufferedWriter(writter);

			for (Loan loan : loans) {
				Book book = DBGlobal.books.getBookById(loan.getBookId());
				User user = DBGlobal.users.getUserById(loan.getUserId());

				bufferedWriter.write("Obra: " + book.getTitulo());
				bufferedWriter.newLine();
				bufferedWriter.write("Emprestado para: " + user.getName());
				bufferedWriter.newLine();
				bufferedWriter.write(" Email: " + user.getEmail());
				bufferedWriter.newLine();
				bufferedWriter.write("=================");
				bufferedWriter.newLine();
			}

			bufferedWriter.flush();
			bufferedWriter.close();
			writter.close();
			System.out.println("Relatorio gerado em " + file.getAbsolutePath());
		} catch (IOException err) {
			System.out.println("Erro ao gerar relatorio!!!");
		}
	}

	public static void reportAllLoans() {
		ArrayList<Loan> loans = DBGlobal.loans.getLoans();
		File file = new File("allloans-report.txt");
		try {
			FileWriter writter = new FileWriter(file);
			file.createNewFile();
			BufferedWriter bufferedWriter = new BufferedWriter(writter);

			for (Loan loan : loans) {
				Book book = DBGlobal.books.getBookById(loan.getBookId());
				User user = DBGlobal.users.getUserById(loan.getUserId());

				bufferedWriter.write("Obra: " + book.getTitulo());
				bufferedWriter.newLine();
				bufferedWriter.write("Emprestado para: " + user.getName());
				bufferedWriter.newLine();
				bufferedWriter.write(" Email: " + user.getEmail());
				bufferedWriter.newLine();
				bufferedWriter.write("Status: " + loan.getStatus().toString());
				bufferedWriter.newLine();
				bufferedWriter.write("=================");
				bufferedWriter.newLine();
			}

			bufferedWriter.flush();
			bufferedWriter.close();
			writter.close();
			System.out.println("Relatorio gerado em " + file.getAbsolutePath());
		} catch (IOException err) {
			System.out.println("Erro ao gerar relatorio!!!");
		}
	}
}
