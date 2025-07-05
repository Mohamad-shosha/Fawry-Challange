import model.*;
import service.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Mohamed", 500);

        Product cheese = new ShippableExpirableProduct("Cheese", 100, 10,
                LocalDate.of(2025, 7, 30), 200);
        Product biscuits = new ShippableExpirableProduct("Biscuits", 150, 5,
                LocalDate.of(2025, 8, 10), 700);
        Product tv = new ShippableProduct("TV", 300, 3, 10000);
        Product scratchCard = new NonExpirableProduct("ScratchCard", 50, 20);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);
    }
}