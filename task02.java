// Java Program to manage bank accounts, perform transactions, and display account details

class BankAccount {
    
    //INITIALIZE VARIABLES
    String username;
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String username, String accountNumber, double balance) {
        this.username = username;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit
    void deposit(double amount) {
        System.out.println("\n--- Deposit Transaction ---");
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Invalid Deposit Amount!");
        }
    }

    // Withdraw
    void withdraw(double amount) {
        System.out.println("\n--- Withdrawal Transaction ---");
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Transaction Failed! Insufficient Balance.");
        }
    }

    // Transfer
    void transfer(BankAccount receiverAccount, double amount) {
        System.out.println("\n--- Transfer Transaction ---");
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            receiverAccount.balance += amount;
            System.out.println("Transferred Amount: " + amount + " to " + receiverAccount.username);
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Transfer Failed! Insufficient Balance.");
        }
    }

    // Display Account Info
    void displayAccountDetails() {
        System.out.println("\n=================================");
        System.out.println("Account Holder : " + username);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: " + balance);
        System.out.println("=================================\n");
    }
}

public class task02 {

    public static void main(String[] args) {

        // Creating 3 Bank Accounts
        BankAccount account1 = new BankAccount("JON", "1001", 1000.0);
        BankAccount account2 = new BankAccount("AHMED", "1002", 2000.0);
        BankAccount account3 = new BankAccount("FATIMA", "1003", 3000.0);

        System.out.println("========= BANK ACCOUNT MANAGEMENT SYSTEM =========");

        // Transactions for Account 1
        account1.deposit(500);
        account1.withdraw(200);
        account1.transfer(account2, 300);
        account1.displayAccountDetails();

        // Transactions for Account 2
        account2.deposit(1000);
        account2.withdraw(500);
        account2.transfer(account3, 200);
        account2.displayAccountDetails();

        // Transactions for Account 3
        account3.deposit(1500);
        account3.withdraw(700);
        account3.transfer(account1, 400);
        account3.displayAccountDetails();

        System.out.println("========= ALL TRANSACTIONS COMPLETED =========");
    }
}