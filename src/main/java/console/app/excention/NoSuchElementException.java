package console.app.excention;

public class NoSuchElementException extends RuntimeException {
    public NoSuchElementException(String message, Exception e) {
        super(message, e);
    }
}
