public class BankAccount {
    // Private fields
    private String accountNumber;
    private String accountHolderName;
    private double balance;    

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        if (balance < 0) {
            System.out.println("Initial balance cannot be negative");
        } else {
            this.balance = balance;
        }    
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    // Methods (behaviour)
    // Add money
    public void deposit(double amount) {
        if (amount >= 0) {
            balance += amount; // balance = balance + amount;
            System.out.println(amount + " deposited. \nNew balance is " + balance);
        } else {
            System.out.println("You cannot deposit negative amount");
        }
    }

    // Remove money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("You cannot withdraw the -ve amount");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. \nNew balance is " + balance);
        } else {
            System.out.println("Insufficient balance in account");
        }
    }

    // Return current balance
    public double getBalance() {
        return balance;
    }

    // Print Account info
    public void displayAccountInfo() {
        System.out.println("Customer Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

}