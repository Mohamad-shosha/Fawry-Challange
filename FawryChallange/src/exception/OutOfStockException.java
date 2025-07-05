package exception;

/**
 * Exception thrown when a requested product quantity
 * exceeds the available stock.
 */
public class OutOfStockException extends RuntimeException {
    /**
     * Constructs a new OutOfStockException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public OutOfStockException(String message) {
        super(message);
    }
}
