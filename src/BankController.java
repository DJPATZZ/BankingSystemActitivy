import java.util.Scanner;
import java.util.InputMismatchException;

public class BankController {
    static boolean running = true;
    static Account a = null;

    public static void main(String[] args) {
        //initialize objects
        Scanner sc = new Scanner(System.in);
        //initialize bank object
        Bank bank = new Bank();

        //authenticate user
        while (running) {
            while (true) {
                try {
                    if (authenticate(bank, sc)){
                        System.out.println("Login successfully.");
                        break;
                    }else{
                        System.out.println("Login unsuccessfully.");

                    }
                    if (!running) {
                        continue;
                    }
                } catch (IllegalArgumentException | NullPointerException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }
            while (true) {
                try {
                    printMenu();
                    int c = sc.nextInt();
                    processInput(bank, a, sc, c);
                } catch (IllegalArgumentException | NullPointerException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input");
                    sc.nextLine();
                }
            }
        }


    }

    //Controller Methods
    public static void printMenu() {
        System.out.println("""
                1. Check balance
                2. Deposit money
                3. Withdraw money
                4. Transfer money
                5. View transaction history
                6. Log out
                Enter Choices:""");
    }

    public static void processInput(Bank bank, Account a, Scanner sc, int c) {
        if (c == 1) {
            System.out.println("Available balance: " + a.getBalance());
        }
        if (c == 2) {
            System.out.println("Enter amount to deposit: ");
            double amount = 0;
            String type = "Deposit";
            while (true) {
                amount = sc.nextDouble();
                if (BankHelper.isValidAmount(amount)) {
                    a.deposit(amount);
                    System.out.println("Successfully deposited: " + amount);
                    BankHelper.generateTransactionHistory(a, amount, type);
                    break;
                }
            }

        }
        if (c == 3) {
            System.out.println("Enter amount to withdraw: ");
            double amount = 0;
            String type = "Withdraw";
            while (true) {
                amount = sc.nextDouble();
                if (BankHelper.isValidAmount(amount)) {
                    a.withdraw(amount);
                    System.out.println("Successfully withdraw: " + amount);
                    BankHelper.generateTransactionHistory(a, amount, type);
                    break;
                }
            }
        }
        if (c == 4) {
            String sender = a.getAccountNumber();
            String receiver;
            double amount = 0;
            String type = "Transfer";

            System.out.println("Enter account number to transfer: ");
            while (true) {
                receiver = sc.nextLine();
                if (BankHelper.isValidAccountNumber(receiver)) {
                    break;
                }
            }
            for (Account found : bank.getAccountList()) {
                if (found.getAccountNumber().equals(receiver)) {
                    break;
                } else {
                    throw new NullPointerException("No account exist.");
                }
            }
            System.out.println("Enter amount: ");
            while (true) {
                amount = sc.nextDouble();
                if (BankHelper.isValidAmount(amount)) {
                    break;
                }
            }
            if (bank.transferMoney(sender, receiver, amount)) {
                System.out.println("Successfully transferred " + amount + " to " + receiver);
                BankHelper.generateTransactionHistory(a, amount, type);
            }
        }
        if (c == 5) {
            for (Transaction t : a.getTransactionHistory()) {
                System.out.println("Reference " + t.getReferenceNum());
            }
            System.out.println("Select an reference number: ");
            String referenceNum = sc.nextLine();
            if (BankHelper.isValidReferenceNum(referenceNum)) {

            }
        }
        if (c == 6) {

        }
    }

    public static boolean authenticate(Bank bank, Scanner sc)throws InputMismatchException{
        System.out.println("""
                1. Log in
                2. Create Account
                0. Exit
                Enter Choices:""");
        int c = sc.nextInt();

        if (c == 1) {
            System.out.println("Enter account number: ");
            String number = sc.nextLine();
            System.out.println("Enter account password: ");
            String password = sc.nextLine();
            a = bank.login(password, number);
            return true;
        }
        if (c == 2) {
            String number, name, password, pin;
            double balance;
            number = BankHelper.generateAccountNumber(bank);
            while (true) {
                System.out.println("Enter name: ");
                name = sc.nextLine();
                if (BankHelper.isValidAccountName(name)) {
                    break;
                }
            }
            while (true) {
                System.out.println("Enter password: ");
                password = sc.nextLine();
                if (BankHelper.isValidPassword(password)) {
                    break;
                }
            }
            while (true) {
                System.out.println("Enter 4 digit pin: ");
                pin = sc.nextLine();
                pin = pin.trim();
                sc.nextLine();

                if (BankHelper.isValidPin(pin)) {
                    break;
                }
            }
            while (true) {
                System.out.println("Enter initial balance (must equal or great than 100): ");
                balance = sc.nextDouble();
                if (BankHelper.isValidInitialBalance(balance)) {
                    break;
                }
            }
            Account a = new Account(number, name, password, pin, balance);
            bank.createAccount(a);
            return true;

        }
        if (c == 0) {
            running = false;

        }
        return false;
    }

}

