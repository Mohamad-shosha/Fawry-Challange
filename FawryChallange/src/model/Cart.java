package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart containing multiple cart items.
 * Provides methods to add products, check contents, and clear the cart.
 */
public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    /**
     * Adds a product with the specified quantity to the cart.
     *
     * @param product  the product to add
     * @param quantity the number of units to add
     * @throws IllegalArgumentException if the requested quantity exceeds available stock
     */
    public void add(Product product, int quantity) {
        if (!product.isAvailable(quantity)) {
            throw new IllegalArgumentException("Requested quantity exceeds available stock for "
                    + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    /**
     * Returns the list of items currently in the cart.
     *
     * @return list of cart items
     */
    public List<CartItem> getItems() {
        return items;
    }

    /**
     * Checks whether the cart is empty.
     *
     * @return true if cart has no items, false otherwise
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Clears all items from the cart.
     */
    public void clear() {
        items.clear();
    }
}
