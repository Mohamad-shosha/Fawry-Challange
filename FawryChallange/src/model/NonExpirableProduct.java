package model;

/**
 * Represents a product that does not have an expiration date.
 * Inherits from {@link Product} without adding extra fields.
 */
public class NonExpirableProduct extends Product {
    /**
     * Constructs a NonExpirableProduct with the specified name, price, and quantity.
     *
     * @param name     the name of the product
     * @param price    the price of the product
     * @param quantity the available quantity of the product
     */
    public NonExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
