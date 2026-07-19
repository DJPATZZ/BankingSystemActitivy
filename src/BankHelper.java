public class BankHelper {
    //Negative deposits
    //Zero deposits
    public static boolean isValidAmount(double amount) {
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
    public static String generateReferenceNum(Account account) {
        while (true){
            int number = (int) Math.floor(Math.random() * 9000000) + 1000000;
            String referenceNum = Integer.toString(number);
            if (isNotDuplicatedNumber(account, referenceNum)){
                return referenceNum;
            }
        }
    }

    //isValidName
    public static boolean isValidAccountName(String accountName) {
        accountName = accountName.trim();
        char[] array = accountName.toCharArray();

        if (accountName.length() < 2) {
            throw new IllegalArgumentException("Name must be valid.");
        }
        return true;
    }
    public static boolean isValidPassword(String password) {
        password = password.trim();
        char[] array = password.toCharArray();

        return true;
    }
    //valid initial balance
    public static boolean isValidInitialBalance(double amount){
        if (amount >= 100){
            return true;
        }else {
            return false;
        }
    }
    public static void generateTransactionHistory(Account a, double amount, String type){
        String referenceNum = generateReferenceNum(a);
        String receipt = """
               reference number = """ + referenceNum + """
               Amount = """ + amount + """
               Type = """ + type;
        a.addTransactionHistory(receipt, referenceNum);
    }
    public static boolean isValidReferenceNum(String referenceNum){
        char[] refArray = referenceNum.toCharArray();
        if (isEmpty(referenceNum)){
            throw new IllegalArgumentException("Invalid reference number.");
        }
        if (isNotAllDigit(refArray)){
            throw new IllegalArgumentException("Invalid reference number. Must not contain letter.");
        }
        if (has7Digits(referenceNum)){
            return true;
        }else {
            throw new IllegalArgumentException("Invalid reference number.");
        }

    }


    //Helper method
    private static boolean isNotAllDigit(char[] StringArray) {

        for (char c : StringArray) {
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
    private static boolean has7Digits(String pin) {
        if (pin.length() == 7) {
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
    private static boolean isNotDuplicatedNumber(Account account, String referenceNum){
        for (Transaction a : account.getTransactionHistory()){
            if (referenceNum.equals(a.getReferenceNum())){
                return false;
            }
        }
        return true;
    }
}
