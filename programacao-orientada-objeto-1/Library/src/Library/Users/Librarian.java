package Library.Users;

public class Librarian extends User {
	String cellphone;

	public Librarian(int id, String name, String email, String password, UserType userType, String cellphone) {
		super(id, name, email, password, userType);
		this.cellphone = cellphone;
	}
}
