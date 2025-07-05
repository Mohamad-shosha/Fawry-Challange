package exception;

/**
 * Exception thrown when a customer attempts a transaction
 * but does not have sufficient balance to complete it.
 */
public class InsufficientBalanceException extends RuntimeException {
    /**
     * Constructs a new InsufficientBalanceException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
