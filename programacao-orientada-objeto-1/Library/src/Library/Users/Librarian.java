package Library.Users;

public class Librarian extends User {
	private String cellphone;
	private int totalReturns;

	public Librarian(int id, String name, String email, String password, UserType userType, String cellphone, int totalReturns) {
		super(id, name, email, password, userType);
		this.cellphone = cellphone;
		this.totalReturns = totalReturns;
	}

	public String getCellphone() {
		return cellphone;
	}

	public int getTotalReturns() {
		return totalReturns;
	}

	public void incrementTotalReturns() {
		totalReturns++;
	}
}
