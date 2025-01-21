package Library.Users;

public abstract class User {
	private String name;
	private String email;
	private String password;
	private UserType userType;
	private int id;

	User(int id, String name, String email, String password, UserType userType) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
}
