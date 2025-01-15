import DB.DBBooks;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
		DBBooks books = new DBBooks();
		System.out.println(books.getBooks().size());
	}
}
