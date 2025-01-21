package Library.Collection;

import DB.DBGlobal;
import DB.DBItem;

public class Loan extends DBItem {
	LoanStatus status;
	Book book;

	public Loan(int id, LoanStatus status, int bookId) {
		super(id);
		this.status = status;
		this.book = DBGlobal.books.getBookById(bookId);
	}

	public LoanStatus getStatus() {
		return status;
	}
}
