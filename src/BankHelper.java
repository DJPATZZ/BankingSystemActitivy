import java.util.ArrayList;

public class BankHelper {
    //Negative deposits
    //Zero deposits
    public static boolean isValidDeposit(double amount){
        if (amount <= 0){
            return false;
        }else {
            return true;
        }
    }
    //Negative withdrawals
    //Zero deposits
    public static boolean isValidWithdraw(double amount){
        if (amount <= 0){
            return false;
        }else {
            return true;
        }
    }
    //Withdrawal greater than the balance
    public static boolean isEnoughBalance(double balance, double amount){
        if (balance > amount){
            return true;
        }else {
            return false;
        }
    }
    //Wrong PIN
    public static boolean isValidPin(String pin){
        pin = pin.trim();
        char[] pinArray = pin.toCharArray();

        for (char c : pinArray){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    //Unknown account number
    public static boolean isValidAccountNumber(String accountNumber){
        accountNumber = accountNumber.trim();
        char[] array = accountNumber.toCharArray();
        for (char c : array){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
