package Library.Users;

public class Teacher extends User {
	private String department;

	public Teacher(int id, String name, String email, String password, UserType userType, String department) {
		super(id, name, email, password, userType);
		this.department = department;
	}
}
