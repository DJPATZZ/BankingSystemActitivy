public class BankHelper {
    //Negative deposits
    //Zero deposits
    public static boolean isValidDeposit(double amount) {
        if (amount <= 0) {
            return false;
        } else {
            return true;
        }
    }

    //Negative withdrawals
    //Zero deposits
    public static boolean isValidWithdraw(double amount) {
        if (amount <= 0) {
            return false;
        } else {
            return true;
        }
    }

    //Withdrawal greater than the balance
    public static boolean isEnoughBalance(double balance, double amount) {
        if (balance >= amount) {
            return true;
        } else {
            return false;
        }
    }

    //Wrong PIN
    public static boolean isValidPin(String pin) {
        char[] pinArray = pin.toCharArray();

        if (isEmpty(pin)) {
            throw new IllegalArgumentException("Pin must not be Empty");
        }
        if (isNotAllDigit(pinArray)) {
            throw new IllegalArgumentException("Pin must not contain letters.");
        }
        if (has4Digits(pin)) {
            return true;
        } else {
            throw new IllegalArgumentException("Must be a 4 digit pin.");
        }

    }

    //Unknown account number
    public static boolean isValidAccountNumber(String accountNumber) {
        accountNumber = accountNumber.trim();
        char[] array = accountNumber.toCharArray();

        if (isEmpty(accountNumber)) {
            throw new IllegalArgumentException("AccountNumber must not be Empty");
        }
        if (isNotAllDigit(array)) {
            throw new IllegalArgumentException("AccountNumber must not contain letters.");
        }
        if (has6Digits(accountNumber)) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid Account number.");
        }
    }

    public static String generateAccountNumber(Bank bank) {
        while (true){
            int number = (int) Math.floor(Math.random() * 900000) + 100000;
            String accountNumber = Integer.toString(number);
            if (isNotDuplicatedNumber(bank, accountNumber)){
                return accountNumber;
            }
        }
    }

    //isValidName
    public static boolean isValidAccountName(String accountName) {
        accountName = accountName.trim();
        char[] array = accountName.toCharArray();

        if (accountName.length() < 2) {
            throw new IllegalArgumentException("accountName must not be Empty");
        }
        if (isNotAllDigit(array)) {
            throw new IllegalArgumentException("accountName must not contain letters.");
        }
        if (has6Digits(accountName)) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid accountName.");
        }
    }
    public static boolean isValidPassword(String password) {
        password = password.trim();
        char[] array = password.toCharArray();

        if (password.length() < 2) {
            throw new IllegalArgumentException("password must not be Empty");
        }
        if (isNotAllDigit(array)) {
            throw new IllegalArgumentException("password must not contain letters.");
        }
        if (has6Digits(password)) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid password.");
        }
    }
    //valid initial balance
    public static boolean isValidInitialBalance(double amount){
        if (amount > 100){
            return true;
        }else {
            return false;
        }
    }


    //Helper method
    private static boolean isNotAllDigit(char[] pinArray) {

        for (char c : pinArray) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean has4Digits(String pin) {
        if (pin.length() == 4) {
            return true;
        }
        return false;
    }

    private static boolean has6Digits(String pin) {
        if (pin.length() == 6) {
            return true;
        }
        return false;
    }

    private static boolean isEmpty(String input) {
        if (input.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    private static boolean isNotDuplicatedNumber(Bank bank, String number){
        for (Account a : bank.getAccountList()){
            if (number.equals(a.getAccountNumber())){
                return false;
            }
        }
        return true;
    }
}
