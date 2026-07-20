import java.util.ArrayList;

public class Account {

    // Fields
    private String accountNumber;
    private String accountName;
    private String accountPassword;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    // Constructor
    public Account(String accountNumber, String accountName,
                   String accountPassword, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.pin = pin;
        setBalance(balance);
        this.transactionHistory = new ArrayList<>();
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    // Setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException(
                    "Balance cannot be negative or invalid."
            );
        }

        this.balance = balance;
    }

    // Account methods
    public void deposit(double amount) {
        if (!BankHelper.isValidAmount(amount)) {
            throw new IllegalArgumentException(
                    "Deposit must be greater than zero."
            );
        }

        setBalance(balance + amount);
    }

    public void withdraw(double amount) {
        if (!BankHelper.isValidAmount(amount)) {
            throw new IllegalArgumentException(
                    "Withdrawal must be greater than zero."
            );
        }

        if (!BankHelper.isEnoughBalance(balance, amount)) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        setBalance(balance - amount);
    }

    public void addTransactionHistory(String transactionHistory,
                                      String referenceNumber) {
        this.transactionHistory.add(
                new Transaction(transactionHistory, referenceNumber)
        );
    }
}