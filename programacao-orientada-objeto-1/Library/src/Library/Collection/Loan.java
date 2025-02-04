package Library.Collection;

import DB.DBItem;

public class Loan extends DBItem {
	private LoanStatus status;
	private int bookId;
	private int userId;

	public Loan(int id, LoanStatus status, int bookId, int userId) {
		super(id);
		this.status = status;
		this.bookId = bookId;
		this.userId = userId;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public int getBookId() {
		return bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setReturned() {
		this.status = LoanStatus.RETURNED;
	}
}
