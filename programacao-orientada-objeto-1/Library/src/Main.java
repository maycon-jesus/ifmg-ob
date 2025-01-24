import DB.DBGlobal;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
//		DBBooks books = new DBBooks();
//		books.getBooks().get(4999).setTitulo("Book 1");
//		DBGlobal.books.onUpdateData(DBGlobal.books.getBooks().get(4999));
//		System.out.println(books.getBooks().size());


//		DBLoans db = new DBLoans();
//		db.insertData(new Loan(1, "RETURNED"));

		System.out.println(DBGlobal.users.getUsers().size());
	}
}
