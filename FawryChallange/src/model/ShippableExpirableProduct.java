package model;

import java.time.LocalDate;

/**
 * Represents a product that is both expirable and shippable.
 * Extends {@link ExpirableProduct} and implements {@link Shippable}.
 */
public class ShippableExpirableProduct extends ExpirableProduct implements Shippable {
    private final double weight;

    /**
     * Constructs a ShippableExpirableProduct with the specified name, price, quantity,
     * expiry date, and weight.
     *
     * @param name       the name of the product
     * @param price      the price of the product
     * @param quantity   the available quantity
     * @param expiryDate the expiration date of the product
     * @param weight     the weight of the product in grams
     */
    public ShippableExpirableProduct(String name, double price, int quantity,
                                     LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    /**
     * Returns the weight of the product in grams.
     *
     * @return the weight of the product
     */
    @Override
    public double getWeight() {
        return weight;
    }
}
