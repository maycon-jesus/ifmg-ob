package DB;

import Library.Users.*;

import java.util.ArrayList;

public class DBUsers extends DBManagerv2<User> {
	public DBUsers() {
		super("db/users", "id,name,email,password,userType,cellphone,registration,course,department,totalReturns", 10);
	}

	@Override
	User createInstaceOfData(String[] dataArr) {
		int id = Integer.parseInt(dataArr[0]);
		String name = dataArr[1];
		String email = dataArr[2];
		String password = dataArr[3];
		UserType userType = UserType.valueOf(dataArr[4]);
		String cellphone = dataArr[5];
		String registration = dataArr[6];
		String course = dataArr[7];
		String department = dataArr[8];

		switch (userType) {
			case LIBRARIAN -> {
				int totalReturns = Integer.parseInt(dataArr[9]);
				return new Librarian(id, name, email, password, userType, cellphone, totalReturns);
			}
			case TEACHER -> {
				return new Teacher(id, name, email, password, userType, department);
			}
			case STUDENT -> {
				return new Student(id, name, email, password, userType, registration, course);
			}
			default -> throw new RuntimeException("UserType invalid!!!");
		}
	}

	public ArrayList<User> getUsers() {
		return super.items;
	}

	@Override
	String instanceToStringData(User data) {

		switch (data.getUserType()) {
			case STUDENT -> {
				Student student = (Student) data;
				return student.getId() + ","
						+ student.getName() + ","
						+ student.getEmail() + ","
						+ student.getPassword() + ","
						+ student.getUserType() + ",null,"
						+ student.getRegistration() + ","
						+ student.getCourse() + ",null,null";
			}
			case TEACHER -> {
				Teacher teacher = (Teacher) data;
				// cellphone vazio"" + "," +                // registration vazio
				return teacher.getId() + "," +
						teacher.getName() + "," +
						teacher.getEmail() + "," +
						teacher.getPassword() + "," +
						teacher.getUserType() + ",null,null," +
						teacher.getDepartment() + ",null";


			}
			case LIBRARIAN -> {
				Librarian librarian = (Librarian) data;
				// registration vazio
				// course vazio

				return librarian.getId() + "," +
						librarian.getName() + "," +
						librarian.getEmail() + "," +
						librarian.getPassword() + "," +
						librarian.getUserType() + "," +
						librarian.getCellphone() + ",null,null,null," +
						librarian.getTotalReturns();
			}
			default -> throw new RuntimeException("UserType inválido!!!");
		}

	}

	public User getUserByMail(String email) {
		for (User user : items) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}

		return null;
	}

	public Student newStudents(String name, String email, String password, UserType userType, String registration, String course) {
		int id = this.getNextItemId();
		Student student = new Student(id, name, email, password, userType, registration, course);
		this.insertData(student);
		return student;

	}

	public Teacher newTeacher(String name, String email, String password, UserType userType, String department) {
		int id = this.getNextItemId();
		Teacher teacher = new Teacher(id, name, email, password, userType, department);
		this.insertData(teacher);
		return teacher;
	}

	public Librarian newLibrarian(String name, String email, String password, UserType userType, String cellphone, int totalReturns) {
		int id = this.getNextItemId();
		Librarian librarian = new Librarian(id, name, email, password, userType, cellphone, totalReturns);
		this.insertData(librarian);
		return librarian;
	}

	public User getUserById(int id) {
		for (User user : items) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}