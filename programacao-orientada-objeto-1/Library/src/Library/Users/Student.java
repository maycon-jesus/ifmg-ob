package Library.Users;

public class Student extends User {
    private String registration, course;

    public Student(int id, String name, String email, String password, UserType userType, String registration, String course) {
        super(id, name, email, password, userType);
        this.registration = registration;
        this.course = course;
    }

    public String getRegistration() {
        return registration;
    }

    public String getCourse() {
        return course;
    }
}
