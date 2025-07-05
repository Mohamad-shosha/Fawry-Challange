package service;

import model.Shippable;

import java.util.List;

/**
 * Service responsible for handling the shipping of shippable items.
 */
public class ShippingService {

    /**
     * Ships the given list of shippable items by printing their details
     * and the total package weight.
     *
     * @param items list of items to be shipped
     */
    public void shipItems(List<Shippable> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Shippable item : items) {
            System.out.println(item.getName() + "        " + item.getWeight() + "g");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight " + totalWeight / 1000 + "kg");
        System.out.println();
    }
}
