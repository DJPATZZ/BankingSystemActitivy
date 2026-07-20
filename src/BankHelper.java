public class BankHelper {

    // Check negative, zero, NaN, and infinite amounts
    public static boolean isValidAmount(double amount) {
        return Double.isFinite(amount) && amount > 0;
    }

    // Check whether the account has enough money
    public static boolean isEnoughBalance(double balance,
                                          double amount) {
        return isValidAmount(amount) && balance >= amount;
    }

    // Validate PIN
    public static boolean isValidPin(String pin) {
        if (isEmpty(pin)) {
            throw new IllegalArgumentException(
                    "PIN must not be empty."
            );
        }

        pin = pin.trim();

        if (isNotAllDigit(pin.toCharArray())) {
            throw new IllegalArgumentException(
                    "PIN must contain digits only."
            );
        }

        if (!has4Digits(pin)) {
            throw new IllegalArgumentException(
                    "PIN must have exactly 4 digits."
            );
        }

        return true;
    }

    // Validate account number
    public static boolean isValidAccountNumber(
            String accountNumber
    ) {
        if (isEmpty(accountNumber)) {
            throw new IllegalArgumentException(
                    "Account number must not be empty."
            );
        }

        accountNumber = accountNumber.trim();

        if (isNotAllDigit(accountNumber.toCharArray())) {
            throw new IllegalArgumentException(
                    "Account number must contain digits only."
            );
        }

        if (!has6Digits(accountNumber)) {
            throw new IllegalArgumentException(
                    "Account number must have exactly 6 digits."
            );
        }

        return true;
    }

    // Generate a unique six-digit account number
    public static String generateAccountNumber(Bank bank) {
        while (true) {
            int number =
                    (int) (Math.random() * 900000) + 100000;

            String accountNumber =
                    Integer.toString(number);

            if (isNotDuplicatedNumber(bank, accountNumber)) {
                return accountNumber;
            }
        }
    }

    // Generate a unique seven-digit reference number
    public static String generateReferenceNum(
            Account account
    ) {
        while (true) {
            int number =
                    (int) (Math.random() * 9000000) + 1000000;

            String referenceNum =
                    Integer.toString(number);

            if (isNotDuplicatedNumber(
                    account,
                    referenceNum
            )) {
                return referenceNum;
            }
        }
    }

    // Validate account name
    public static boolean isValidAccountName(
            String accountName
    ) {
        if (isEmpty(accountName)
                || accountName.trim().length() < 2) {
            throw new IllegalArgumentException(
                    "Name must contain at least 2 characters."
            );
        }

        char[] characters =
                accountName.trim().toCharArray();

        for (char character : characters) {
            if (!Character.isLetter(character)
                    && !Character.isWhitespace(character)) {
                throw new IllegalArgumentException(
                        "Name must contain letters and spaces only."
                );
            }
        }

        return true;
    }

    // Validate password
    public static boolean isValidPassword(String password) {
        if (isEmpty(password)) {
            throw new IllegalArgumentException(
                    "Password must not be empty."
            );
        }

        if (password.trim().length() < 4) {
            throw new IllegalArgumentException(
                    "Password must contain at least 4 characters."
            );
        }

        return true;
    }

    // Validate starting balance
    public static boolean isValidInitialBalance(
            double amount
    ) {
        return Double.isFinite(amount) && amount >= 100;
    }

    // Create and store transaction history
    public static void generateTransactionHistory(
            Account account,
            double amount,
            String type
    ) {
        String referenceNum =
                generateReferenceNum(account);

        String receipt = """
                Reference number = %s
                Amount = %.2f
                Type = %s
                """.formatted(
                referenceNum,
                amount,
                type
        );

        account.addTransactionHistory(
                receipt,
                referenceNum
        );
    }

    // Validate reference number
    public static boolean isValidReferenceNum(
            String referenceNum
    ) {
        if (isEmpty(referenceNum)) {
            throw new IllegalArgumentException(
                    "Reference number must not be empty."
            );
        }

        referenceNum = referenceNum.trim();

        if (isNotAllDigit(referenceNum.toCharArray())) {
            throw new IllegalArgumentException(
                    "Reference number must contain digits only."
            );
        }

        if (!has7Digits(referenceNum)) {
            throw new IllegalArgumentException(
                    "Reference number must have exactly 7 digits."
            );
        }

        return true;
    }

    // Helper methods

    private static boolean isNotAllDigit(
            char[] stringArray
    ) {
        for (char character : stringArray) {
            if (!Character.isDigit(character)) {
                return true;
            }
        }

        return false;
    }

    private static boolean has4Digits(String pin) {
        return pin.length() == 4;
    }

    private static boolean has6Digits(
            String accountNumber
    ) {
        return accountNumber.length() == 6;
    }

    private static boolean has7Digits(
            String referenceNum
    ) {
        return referenceNum.length() == 7;
    }

    private static boolean isEmpty(String input) {
        return input == null
                || input.trim().isEmpty();
    }

    private static boolean isNotDuplicatedNumber(
            Bank bank,
            String number
    ) {
        for (Account account : bank.getAccountList()) {
            if (number.equals(
                    account.getAccountNumber()
            )) {
                return false;
            }
        }

        return true;
    }

    private static boolean isNotDuplicatedNumber(
            Account account,
            String referenceNum
    ) {
        for (Transaction transaction
                : account.getTransactionHistory()) {
            if (referenceNum.equals(
                    transaction.getReferenceNum()
            )) {
                return false;
            }
        }

        return true;
    }
}