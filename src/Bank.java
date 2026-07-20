import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accountList;

    public Bank() {
        this.accountList = new ArrayList<>();
    }

    // Setter
    public void setAccountList(ArrayList<Account> accountList) {
        if (accountList == null) {
            throw new IllegalArgumentException(
                    "Account list cannot be null."
            );
        }

        this.accountList = accountList;
    }

    // Getter
    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    // Create account
    public void createAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException(
                    "Account cannot be null."
            );
        }

        for (Account existingAccount : accountList) {
            if (existingAccount.getAccountNumber()
                    .equals(account.getAccountNumber())) {
                throw new IllegalArgumentException(
                        "Account number already exists."
                );
            }
        }

        accountList.add(account);
    }

    // Find account using account number
    public Account findAccountByNumber(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        throw new IllegalArgumentException(
                "Account does not exist."
        );
    }

    // Find account using account name
    public Account findAccountByName(String accountName) {
        for (Account account : accountList) {
            if (account.getAccountName()
                    .equalsIgnoreCase(accountName)) {
                return account;
            }
        }

        throw new IllegalArgumentException(
                "Account does not exist."
        );
    }

    // Login
    public Account login(String accountPassword,
                         String accountNumber) {
        Account account = findAccountByNumber(accountNumber);

        if (account.getAccountPassword().equals(accountPassword)) {
            return account;
        }

        throw new IllegalArgumentException(
                "Incorrect password."
        );
    }

    // Transfer money
    public boolean transferMoney(String senderAccountNumber,
                                 String receiverAccountNumber,
                                 double amount) {
        if (!BankHelper.isValidAmount(amount)) {
            throw new IllegalArgumentException(
                    "Transfer amount must be greater than zero."
            );
        }

        if (senderAccountNumber.equals(receiverAccountNumber)) {
            throw new IllegalArgumentException(
                    "You cannot transfer to the same account."
            );
        }

        Account sender =
                findAccountByNumber(senderAccountNumber);

        Account receiver =
                findAccountByNumber(receiverAccountNumber);

        sender.withdraw(amount);
        receiver.deposit(amount);

        return true;
    }
}