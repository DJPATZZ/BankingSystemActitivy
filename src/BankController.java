import java.util.Scanner;

public class BankController {

    static boolean running = true;
    static Account a = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (running) {

            // Authentication menu
            while (running && a == null) {
                try {
                    authenticate(bank, sc);
                } catch (IllegalArgumentException exception) {
                    System.out.println(
                            exception.getMessage()
                    );
                }
            }

            // Account menu
            while (running && a != null) {
                try {
                    printMenu();

                    int choice = readInt(sc);

                    processInput(
                            bank,
                            a,
                            sc,
                            choice
                    );
                } catch (IllegalArgumentException exception) {
                    System.out.println(
                            exception.getMessage()
                    );
                }
            }
        }

        sc.close();

        System.out.println("Program ended.");
    }

    public static void printMenu() {
        System.out.println("""
                1. Check balance
                2. Deposit money
                3. Withdraw money
                4. Transfer money
                5. View transaction history
                6. Log out
                Enter choice:
                """);
    }

    public static void processInput(
            Bank bank,
            Account a,
            Scanner sc,
            int c
    ) {
        if (c == 1) {
            System.out.printf(
                    "Available balance: %.2f%n",
                    a.getBalance()
            );

            return;
        }

        if (c == 2) {
            System.out.println(
                    "Enter amount to deposit:"
            );

            double amount = readDouble(sc);

            a.deposit(amount);

            BankHelper.generateTransactionHistory(
                    a,
                    amount,
                    "Deposit"
            );

            System.out.printf(
                    "Successfully deposited: %.2f%n",
                    amount
            );

            return;
        }

        if (c == 3) {
            System.out.println(
                    "Enter amount to withdraw:"
            );

            double amount = readDouble(sc);

            a.withdraw(amount);

            BankHelper.generateTransactionHistory(
                    a,
                    amount,
                    "Withdraw"
            );

            System.out.printf(
                    "Successfully withdrew: %.2f%n",
                    amount
            );

            return;
        }

        if (c == 4) {
            String sender =
                    a.getAccountNumber();

            System.out.println(
                    "Enter account number to transfer to:"
            );

            String receiver =
                    sc.nextLine().trim();

            BankHelper.isValidAccountNumber(receiver);

            System.out.println("Enter amount:");

            double amount = readDouble(sc);

            if (bank.transferMoney(
                    sender,
                    receiver,
                    amount
            )) {
                Account receiverAccount =
                        bank.findAccountByNumber(receiver);

                BankHelper.generateTransactionHistory(
                        a,
                        amount,
                        "Transfer sent to " + receiver
                );

                BankHelper.generateTransactionHistory(
                        receiverAccount,
                        amount,
                        "Transfer received from " + sender
                );

                System.out.printf(
                        "Successfully transferred %.2f to %s%n",
                        amount,
                        receiver
                );
            }

            return;
        }

        if (c == 5) {
            viewTransactionHistory(a, sc);
            return;
        }

        if (c == 6) {
            BankController.a = null;

            System.out.println(
                    "Logged out successfully."
            );

            return;
        }

        throw new IllegalArgumentException(
                "Invalid menu choice."
        );
    }

    public static boolean authenticate(
            Bank bank,
            Scanner sc
    ) {
        System.out.println("""
                1. Log in
                2. Create Account
                0. Exit
                Enter choice:
                """);

        int c = readInt(sc);

        if (c == 1) {
            System.out.println(
                    "Enter account number:"
            );

            String number =
                    sc.nextLine().trim();

            BankHelper.isValidAccountNumber(number);

            System.out.println(
                    "Enter account password:"
            );

            String password =
                    sc.nextLine();

            BankHelper.isValidPassword(password);

            BankController.a =
                    bank.login(password, number);

            System.out.println(
                    "Login successful."
            );

            return true;
        }

        if (c == 2) {
            String number =
                    BankHelper.generateAccountNumber(bank);

            System.out.println("Enter name:");

            String name =
                    sc.nextLine().trim();

            BankHelper.isValidAccountName(name);

            System.out.println("Enter password:");

            String password =
                    sc.nextLine();

            BankHelper.isValidPassword(password);

            System.out.println(
                    "Enter 4-digit PIN:"
            );

            String pin =
                    sc.nextLine().trim();

            BankHelper.isValidPin(pin);

            System.out.println(
                    "Enter initial balance "
                            + "(must be at least 100):"
            );

            double balance =
                    readDouble(sc);

            if (!BankHelper.isValidInitialBalance(
                    balance
            )) {
                throw new IllegalArgumentException(
                        "Initial balance must be at least 100."
                );
            }

            Account account = new Account(
                    number,
                    name,
                    password,
                    pin,
                    balance
            );

            bank.createAccount(account);

            BankController.a = account;

            System.out.println(
                    "Account created successfully."
            );

            System.out.println(
                    "Your account number is: " + number
            );

            return true;
        }

        if (c == 0) {
            running = false;
            return false;
        }

        throw new IllegalArgumentException(
                "Invalid authentication choice."
        );
    }

    private static void viewTransactionHistory(
            Account account,
            Scanner sc
    ) {
        if (account.getTransactionHistory().isEmpty()) {
            System.out.println(
                    "No transaction history."
            );

            return;
        }

        System.out.println(
                "Transaction references:"
        );

        for (Transaction transaction
                : account.getTransactionHistory()) {
            System.out.println(
                    transaction.getReferenceNum()
            );
        }

        System.out.println(
                "Select a reference number:"
        );

        String referenceNum =
                sc.nextLine().trim();

        BankHelper.isValidReferenceNum(referenceNum);

        for (Transaction transaction
                : account.getTransactionHistory()) {
            if (referenceNum.equals(
                    transaction.getReferenceNum()
            )) {
                System.out.println(
                        transaction.getHistory()
                );

                return;
            }
        }

        throw new IllegalArgumentException(
                "Transaction does not exist."
        );
    }

    private static int readInt(Scanner sc) {
        String input =
                sc.nextLine().trim();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Enter a valid whole number."
            );
        }
    }

    private static double readDouble(Scanner sc) {
        String input =
                sc.nextLine().trim();

        try {
            double number =
                    Double.parseDouble(input);

            if (!Double.isFinite(number)) {
                throw new IllegalArgumentException(
                        "Enter a valid amount."
                );
            }

            return number;

        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Enter a valid number."
            );
        }
    }
}