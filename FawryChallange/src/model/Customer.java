package model;

/**
 * Represents a customer with a name and an account balance.
 */
public class Customer {
    private final String name;
    private double balance;

    /**
     * Constructs a new Customer with the specified name and balance.
     *
     * @param name    the name of the customer
     * @param balance the initial account balance of the customer
     */
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    /**
     * Returns the name of the customer.
     *
     * @return customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current balance of the customer's account.
     *
     * @return customer's balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deducts the specified amount from the customer's balance.
     *
     * @param amount the amount to deduct
     */
    public void deductBalance(double amount) {
        this.balance -= amount;
    }
}
