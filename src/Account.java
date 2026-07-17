import java.util.ArrayList;

public class Account {

    // Fields
    private String accountNumber;
    private String accountName;
    private String accountPassword;
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountNumber, String accountName, String accountPassword, String pin, double balance) {
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setAccountPassword(accountPassword);
        setPin(pin);
        setBalance(balance);
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountPassword(){
        return this.accountPassword;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    // Setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountPassword(String accountPassword){
        this.accountPassword = accountName;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactionHistory(ArrayList<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    // Account methods
    public void deposit(double amount) {
        double newBalance = this.balance + amount;
    }

    public void withdraw(double amount) {
        double newBalance = this.balance - amount;
    }
}