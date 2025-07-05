package model;

import java.time.LocalDate;

/**
 * Represents a product that has an expiration date.
 * Inherits from {@link Product} and adds expiry functionality.
 */
public class ExpirableProduct extends Product {
    private final LocalDate expiryDate;

    /**
     * Constructs an ExpirableProduct with the specified name, price, quantity, and expiry date.
     *
     * @param name       the name of the product
     * @param price      the price of the product
     * @param quantity   the available quantity of the product
     * @param expiryDate the expiration date of the product
     */
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    /**
     * Checks if the product is expired based on the current date.
     *
     * @return {@code true} if the current date is after the expiry date, {@code false} otherwise
     */
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
