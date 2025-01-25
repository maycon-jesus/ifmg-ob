import Library.Users.Prompt;
import Library.Users.User;

public class Main {
    public static void main(String[] args) {

        User user = Prompt.Login();
        Prompt.promptBook();
        Prompt.registerStudent();
    }
}
