package model;

/**
 * Represents a product that can be shipped.
 * Extends {@link Product} and implements {@link Shippable}.
 */
public class ShippableProduct extends Product implements Shippable {
    private final double weight;

    /**
     * Constructs a ShippableProduct with the specified name, price, quantity, and weight.
     *
     * @param name     the name of the product
     * @param price    the price of the product
     * @param quantity the available quantity of the product
     * @param weight   the weight of the product in grams
     */
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
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
