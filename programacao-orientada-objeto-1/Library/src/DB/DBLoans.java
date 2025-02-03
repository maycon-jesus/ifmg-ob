package DB;

import Library.Collection.Loan;
import Library.Collection.LoanStatus;

public class DBLoans extends DBManagerv2<Loan> {
	public DBLoans() {
		super("db/loans", "id,status,bookId,userId", 10);
	}

	@Override
	Loan createInstaceOfData(String[] dataArr) {
		int id = Integer.parseInt(dataArr[0]);
		LoanStatus status = LoanStatus.valueOf(dataArr[1]);
		int bookId = Integer.parseInt(dataArr[2]);
		int userId = Integer.parseInt(dataArr[3]);
		return new Loan(id, status, bookId, userId);
	}

	@Override
	String instanceToStringData(Loan data) {
		return data.getId() + "," + data.getStatus();
	}

	public void registerLoan(int bookId, int userId) {
		int id = this.getNextItemId();
		Loan loan = new Loan(id, LoanStatus.BORROWED, bookId, userId);
		this.items.add(loan);
		this.onUpdateData(loan);
	}
}
