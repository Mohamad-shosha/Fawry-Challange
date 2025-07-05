package model;

/**
 * Represents a general product with basic attributes such as name, price, and quantity.
 * This is an abstract class meant to be extended by specific types of products.
 */
public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    /**
     * Constructs a Product with the specified name, price, and quantity.
     *
     * @param name     the name of the product
     * @param price    the price of the product
     * @param quantity the available quantity of the product
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the name of the product.
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the product.
     *
     * @return product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the available quantity of the product.
     *
     * @return product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Reduces the available quantity of the product by the specified amount.
     *
     * @param amount the amount to reduce
     */
    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    /**
     * Checks if the requested quantity is available in stock.
     *
     * @param requestedQuantity the quantity requested
     * @return {@code true} if requested quantity is less than or equal to available quantity, {@code false} otherwise
     */
    public boolean isAvailable(int requestedQuantity) {
        return quantity >= requestedQuantity;
    }

    /**
     * Checks if the product is expired.
     * This base implementation always returns {@code false},
     * subclasses (like ExpirableProduct) can override this method.
     *
     * @return {@code false} by default
     */
    public boolean isExpired() {
        return false;
    }
}
