package Library.Users;

import DB.DBItem;

public abstract class User extends DBItem {
    private String name;
    private String email;
    private String password;
    private UserType userType;

    User(int id, String name, String email, String password, UserType userType) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }
}

