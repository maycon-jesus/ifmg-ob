package DB;

import Library.Collection.Loan;
import Library.Collection.LoanStatus;

public class DBLoans extends DBManagerv2<Loan> {
	public DBLoans() {
		super("db/loans", "id,status", 10);
	}

	@Override
	Loan createInstaceOfData(String[] dataArr) {
		int id = Integer.parseInt(dataArr[0]);
		LoanStatus status = LoanStatus.valueOf(dataArr[1]);
		int bookId = Integer.parseInt(dataArr[2]);
		return new Loan(id, status, bookId);
	}

	@Override
	String instanceToStringData(Loan data) {
		return data.getId() + "," + data.getStatus();
	}
}
