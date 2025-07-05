package service;

import exception.EmptyCartException;
import exception.InsufficientBalanceException;
import exception.OutOfStockException;
import exception.ProductExpiredException;
import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for handling the checkout process,
 * including validation, payment, shipping, and receipt generation.
 */
public class CheckoutService {
    private static final double SHIPPING_COST = 30;

    /**
     * Performs the checkout process for the given customer and cart.
     * Validates the cart, checks product availability and expiry,
     * calculates total cost including shipping, deducts customer balance,
     * ships items if needed, and prints a receipt.
     *
     * @param customer the customer performing the checkout
     * @param cart     the shopping cart containing items to purchase
     * @throws EmptyCartException           if the cart is empty
     * @throws ProductExpiredException      if any product in the cart is expired
     * @throws OutOfStockException          if requested quantity exceeds product stock
     * @throws InsufficientBalanceException if the customer has insufficient balance
     */
    public void checkout(Customer customer, Cart cart) {
        validateCartNotEmpty(cart);

        List<Shippable> shippables = new ArrayList<>();
        double subtotal = processCartItems(cart, shippables);

        double totalAmount = calculateTotalAmount(subtotal, shippables);

        validateCustomerBalance(customer, totalAmount);

        customer.deductBalance(totalAmount);

        shipItemsIfNeeded(shippables);

        printReceipt(cart, subtotal, shippables, totalAmount, customer.getBalance());
    }

    /**
     * Validates that the cart is not empty.
     *
     * @param cart the shopping cart
     * @throws EmptyCartException if the cart has no items
     */
    private void validateCartNotEmpty(Cart cart) {
        if (cart.isEmpty()) {
            throw new EmptyCartException("Cart is empty.");
        }
    }

    /**
     * Processes each item in the cart: validates product expiry and stock,
     * calculates subtotal, reduces product quantity,
     * and collects shippable items.
     *
     * @param cart       the shopping cart
     * @param shippables list to collect shippable items
     * @return subtotal price of all items in the cart
     */
    private double processCartItems(Cart cart, List<Shippable> shippables) {
        double subtotal = 0;

        for (CartItem item : cart.getItems()) {
            Product product = item.product();

            validateProduct(product, item.quantity());

            subtotal += item.getTotalPrice();

            product.reduceQuantity(item.quantity());

            addShippables(shippables, product, item.quantity());
        }

        return subtotal;
    }

    /**
     * Validates if the product is expired or has sufficient quantity available.
     *
     * @param product  the product to validate
     * @param quantity the requested quantity
     * @throws ProductExpiredException if the product is expired
     * @throws OutOfStockException     if insufficient quantity is available
     */
    private void validateProduct(Product product, int quantity) {
        if (product.isExpired()) {
            throw new ProductExpiredException(product.getName() + " is expired.");
        }
        if (!product.isAvailable(quantity)) {
            throw new OutOfStockException(product.getName() + " is out of stock.");
        }
    }

    /**
     * Adds the product to the list of shippable items according to the quantity.
     *
     * @param shippables the list to add items to
     * @param product    the product to add if it implements Shippable
     * @param quantity   the quantity of the product
     */
    private void addShippables(List<Shippable> shippables, Product product, int quantity) {
        if (product instanceof Shippable) {
            for (int i = 0; i < quantity; i++) {
                shippables.add((Shippable) product);
            }
        }
    }

    /**
     * Calculates the total amount including shipping cost if there are shippable items.
     *
     * @param subtotal   the subtotal of products
     * @param shippables list of shippable items
     * @return total amount to be paid
     */
    private double calculateTotalAmount(double subtotal, List<Shippable> shippables) {
        if (!shippables.isEmpty()) {
            return subtotal + SHIPPING_COST;
        }
        return subtotal;
    }

    /**
     * Validates if the customer has enough balance to pay the total amount.
     *
     * @param customer    the customer
     * @param totalAmount the total amount to be paid
     * @throws InsufficientBalanceException if customer's balance is insufficient
     */
    private void validateCustomerBalance(Customer customer, double totalAmount) {
        if (customer.getBalance() < totalAmount) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
    }

    /**
     * Initiates shipping of items if there are any shippable products.
     *
     * @param shippables list of shippable items
     */
    private void shipItemsIfNeeded(List<Shippable> shippables) {
        if (!shippables.isEmpty()) {
            new ShippingService().shipItems(shippables);
        }
    }

    /**
     * Prints the checkout receipt showing items, subtotal, shipping, total amount, and customer balance.
     *
     * @param cart             the shopping cart
     * @param subtotal         subtotal of the cart items
     * @param shippables       list of shippable items
     * @param totalAmount      total amount including shipping
     * @param remainingBalance customer's balance after deduction
     */
    private void printReceipt(Cart cart, double subtotal, List<Shippable> shippables,
                              double totalAmount, double remainingBalance) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            double totalPrice = item.getTotalPrice();
            System.out.printf("%dx %s        %.2f\n", item.quantity(), item.product().getName(), totalPrice);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.2f\n", subtotal);
        if (!shippables.isEmpty()) {
            System.out.printf("Shipping         %.2f\n", SHIPPING_COST);
        }
        System.out.printf("Amount           %.2f\n", totalAmount);
        System.out.printf("Customer Balance %.2f\n", remainingBalance);
        System.out.println();
    }
}
