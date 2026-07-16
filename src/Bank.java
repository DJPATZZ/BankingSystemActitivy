import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accountList;

    public Bank(ArrayList<Account> accountList){
        setAccount(accountList);
    }
    //setter method
    public void setAccount(ArrayList<Account> accountList){
        this.accountList = accountList;
    }
    //Bank methods

    //createAccount
    public void createAccount(Account account){
        this.accountList.add(account);
    }
    //findAccount
    public Account findAccountByNumber(String accountName){
        for (Account a : this.accountList){
            if (accountName.equals(a.accountName)){
                return a;
            }
        }
        return null;
    }
    public Account findAccountByName(String accountNumber){
        for (Account a : this.accountList){
            if (accountNumber.equals(a.accountNumber)){
                return a;
            }
        }
        return null;
    }
    //login
    public Account login(){

    }


}
