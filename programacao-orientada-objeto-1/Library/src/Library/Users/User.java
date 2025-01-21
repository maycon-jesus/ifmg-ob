package Library.Users;

public abstract class User {
	private String name;
	private String email;
	private String password;
	private UserType userType;

	User(String name, String email, String password, UserType userType) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
}
