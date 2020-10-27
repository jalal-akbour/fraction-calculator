package fraction.exception;

public class InvalidFractionException extends RuntimeException {

    public InvalidFractionException() {
        super("InvalidFractionException : Denominator zero is not allowed");
    }

}
