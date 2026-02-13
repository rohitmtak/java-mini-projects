public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("213433", "Rohit", 1000);
        System.out.println("\n--- Account Info ---");
        account1.displayAccountInfo();

        System.out.println("\n--- Transactions ---");
        account1.deposit(50);
        System.out.println();
        account1.withdraw(300);
        // account1.balance = 5000; // This will give error because balance is private

        System.out.println("\n--- Summary ---");
        System.out.println("Current balance: " + account1.getBalance());

        // BankAccount account2 = new BankAccount("894389", "Manish", 500);
        // account2.displayAccountInfo();
        // account2.deposit(300);
        // account2.withdraw(200);
        // System.out.println("Current balance: " + account2.getBalance());
    }
}
