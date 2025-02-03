package DB;

import Library.Collection.Loan;
import Library.Collection.LoanStatus;
import Library.Users.User;

import java.util.ArrayList;

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
		return data.getId() + "," + data.getStatus() + "," + data.getBookId() + "," + data.getUserId();
	}

	public void registerLoan(int bookId, int userId) {
		int id = this.getNextItemId();
		Loan loan = new Loan(id, LoanStatus.BORROWED, bookId, userId);
		this.insertData(loan);
	}

	public ArrayList<Loan> getLoansByUser(User user) {
		ArrayList<Loan> loans = new ArrayList<>();
		for (Loan loan : this.items) {
			if (loan.getUserId() == user.getId()) {
				loans.add(loan);
			}
		}
		return loans;
	}

	public ArrayList<Loan> getLoansByUserAndStatus(User user, LoanStatus status) {
		ArrayList<Loan> loans = new ArrayList<>();
		for (Loan loan : this.items) {
			if (loan.getUserId() == user.getId() && loan.getStatus() == status) {
				loans.add(loan);
			}
		}
		return loans;
	}
}
