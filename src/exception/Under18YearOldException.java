package exception;

public class Under18YearOldException extends RuntimeException{

    public Under18YearOldException(String message) {
        super(message);
    }
}
