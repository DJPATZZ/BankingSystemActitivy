import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accountList;

    public Bank(){
        this.accountList = new ArrayList<>();
    }
    //setter method
    public void setAccountList(ArrayList<Account> accountList){
        this.accountList = accountList;
    }
    //getter method
    public ArrayList<Account> getAccountList(){
        return accountList;
    }
    //Bank methods

    //createAccount
    public void createAccount(Account account){
        this.accountList.add(account);
    }
    //findAccount
    public Account findAccountByNumber(String accountNumber){
        for (Account a : this.accountList){
            if (accountNumber.equals(a.getAccountNumber())){
                return a;
            }
        }
        throw new NullPointerException("Account does not exist.");
    }
    public Account findAccountByName(String accountName){
        for (Account a : this.accountList){
            if (accountName.equals(a.getAccountName())){
                return a;
            }

        }
        throw new NullPointerException("Account does not exist.");
    }
    //login
    public Account login(String accountPassword,
                         String accountNumber){
        Account a = findAccountByNumber(accountNumber);

        if (accountPassword.equals(a.getAccountPassword())){
            return a;
        }
        throw new NullPointerException("Account does not exist.");
    }
    //transfer money method
    public boolean transferMoney(String senderAccountNumber,
                                 String receiverAccountNumber,
                                 double amount){
        Account a = findAccountByNumber(senderAccountNumber);
        Account b = findAccountByNumber(receiverAccountNumber);
        if (a != null & b != null){
            throw new NullPointerException("Account does not exist.");
        }
        if (BankHelper.isEnoughBalance(a.getBalance(), amount)){
            double senderNewBalance = a.getBalance() - amount;
            double receiverNewBalance = b.getBalance() + amount;

            a.setBalance(senderNewBalance);
            b.setBalance(receiverNewBalance);

        }
        return true;
    }
}
