package exception;

/**
 * Exception thrown when an operation is attempted on an empty shopping cart.
 */
public class EmptyCartException extends RuntimeException {
    /**
     * Constructs a new EmptyCartException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public EmptyCartException(String message) {
        super(message);
    }
}
