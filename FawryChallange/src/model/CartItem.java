package model;

/**
 * Represents an item in the shopping cart,
 * holding a product and its quantity.
 *
 * @param product  the product in the cart
 * @param quantity the quantity of the product
 */
public record CartItem(Product product, int quantity) {

    /**
     * Calculates the total price for this cart item
     * by multiplying the product's price by the quantity.
     *
     * @return total price for the cart item
     */
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
