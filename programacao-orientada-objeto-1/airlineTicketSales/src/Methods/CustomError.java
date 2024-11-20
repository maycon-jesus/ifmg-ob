package Methods;

public class CustomError extends Exception {
    public String message;
    CustomError(String message) {
        super(message);
        this.message = message;
    }
}
