package exception;

/**
 * Exception thrown when an operation involves a product
 * that has passed its expiration date.
 */
public class ProductExpiredException extends RuntimeException {
    /**
     * Constructs a new ProductExpiredException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public ProductExpiredException(String message) {
        super(message);
    }
}
