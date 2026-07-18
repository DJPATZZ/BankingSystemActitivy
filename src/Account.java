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
    public Account(String accountNumber, String accountName, String accountPassword, String pin, double balance) {
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setAccountPassword(accountPassword);
        setPin(pin);
        setBalance(balance);
        transactionHistory = new ArrayList<>();
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

    public void setAccountPassword(String accountPassword){
        this.accountPassword = accountName;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    // Account methods
    public void deposit(double amount) {
        double newBalance = this.balance + amount;
        setBalance(newBalance);
    }

    public void withdraw(double amount) {
        double newBalance = this.balance - amount;
        setBalance(newBalance);
    }
    public void addTransactionHistory(String transactionHistory, String referenceNumber){
        this.transactionHistory.add(new Transaction(transactionHistory, referenceNumber));
    }
}