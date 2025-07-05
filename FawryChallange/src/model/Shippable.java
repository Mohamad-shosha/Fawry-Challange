package model;

/**
 * Represents an item that can be shipped.
 * Provides methods to get the item's name and weight.
 */
public interface Shippable {
    /**
     * Returns the name of the shippable item.
     *
     * @return the name of the item
     */
    String getName();

    /**
     * Returns the weight of the shippable item in grams.
     *
     * @return the weight of the item in grams
     */
    double getWeight();
}
