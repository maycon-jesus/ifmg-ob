package Library.Users;

public class Librarian extends User {
	String cellphone;

	public Librarian(String name, String email, String password, UserType userType, String cellphone) {
		super(name, email, password, userType);
		this.cellphone = cellphone;
	}
}
