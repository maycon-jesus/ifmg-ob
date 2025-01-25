package Library.Users;

import DB.DBGlobal;
import Library.Collection.Book;

import java.util.Scanner;

public class Prompt {

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
        System.out.println("Digite o nome do Livro: ");
        String title = sc.nextLine();
        for (Book book : DBGlobal.books.getBooks()) {
            if (book.getTitulo().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return promptBook();
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

}
