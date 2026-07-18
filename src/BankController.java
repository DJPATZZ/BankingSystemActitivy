import java.util.Scanner;
import java.util.InputMismatchException;

public class BankController {
    public static void main(String[] args){
        //initialize objects
        Scanner sc = new Scanner(System.in);
        //initialize bank object
        Bank bank = new Bank();

        //authenticate user
        Account a;
        while (true) {
            try {
                a = authenticate(bank, sc);
                if (a == null){
                    throw new IllegalArgumentException("Invalid choice.");
                }
                break;
            }catch (IllegalArgumentException |
                    InputMismatchException |
                    NullPointerException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        boolean running = true;
        while (running){
            try {
                printMenu();
                int c = sc.nextInt();
                processInput(bank, a, sc, c);
            }catch (IllegalArgumentException |
                    InputMismatchException |
                    NullPointerException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
    public static void printMenu(){
        System.out.println("""
                1. Check balance
                2. Deposit money
                3. Withdraw money
                4. Transfer money
                5. View transaction history
                6. Log out
                Enter Choices:""");
    }
    public static void processInput(Bank bank, Account a, Scanner sc, int c){
        if (c == 1){
            System.out.println("Available balance: " + a.getBalance());
        }
        if (c == 2){
            System.out.println("Enter amount to deposit: ");
            double amount = 0;
            String type = "Deposit";
            while (true){
                amount = sc.nextDouble();
                if (BankHelper.isValidAmount(amount)){
                    a.deposit(amount);
                    System.out.println("Successfully deposited: " + amount);
                    BankHelper.generateTransactionHistory(a, amount, type);
                    break;
                }
            }

        }
        if (c == 3){
            System.out.println("Enter amount to withdraw: ");
            double amount = 0;
            String type = "Withdraw";
            while (true){
                amount = sc.nextDouble();
                if (BankHelper.isValidAmount(amount)){
                    a.withdraw(amount);
                    System.out.println("Successfully withdraw: " + amount);
                    BankHelper.generateTransactionHistory(a, amount, type);
                    break;
                }
            }
        }
        if (c == 4){
            String sender = a.getAccountNumber();
            String receiver;
            double amount = 0;
            String type = "Transfer";

            System.out.println("Enter account number to transfer: ");
            while (true){
                receiver = sc.nextLine();
                if (BankHelper.isValidAccountNumber(receiver)){
                    break;
                }
            }
            for (Account found : bank.getAccountList()){
                if (found.getAccountNumber().equals(receiver)) {
                    break;
                }else{
                    throw new NullPointerException("No account exist.");
                }
            }
            System.out.println("Enter amount: ");
            while (true){
                amount = sc.nextDouble();
                if (BankHelper.isValidAmount(amount)){
                    break;
                }
            }
            if (bank.transferMoney(sender, receiver, amount)){
                System.out.println("Successfully transferred " + amount + " to " + receiver);
                BankHelper.generateTransactionHistory(a, amount, type);
            }
        }
        if (c == 5){
            for (Transaction t : a.getTransactionHistory()){
                System.out.println("Reference "+t.getReferenceNum());
            }
            System.out.println("Select an reference number: ");
            String referenceNum = sc.nextLine();
            if (BankHelper.isValidReferenceNum(referenceNum)){

            }
        }
        if (c == 6){

        }
    }
    public static Account authenticate(Bank bank, Scanner sc){
        System.out.println("""
                1. Log in
                2. Create Account
                Enter Choices:""");
        int c = sc.nextInt();
        sc.nextLine();

        if (c == 1){
            System.out.println("Enter account number: ");
            String number = sc.nextLine();
            System.out.println("Enter account password: ");
            String password = sc.nextLine();
            return bank.login(password, number);
        }
        if (c == 2){
            String number, name, password, pin;
            double balance;
            number = BankHelper.generateAccountNumber(bank);
            while(true){
                System.out.println("Enter name: ");
                name = sc.nextLine();
                if (BankHelper.isValidAccountName(name)){
                    break;
                }
            }
            while(true){
                System.out.println("Enter password: ");
                password = sc.nextLine();
                if (BankHelper.isValidPassword(password)){
                    break;
                }
            }
            while(true){
                System.out.println("Enter 4 digit pin: ");
                pin = sc.nextLine();
                pin = pin.trim();
                sc.nextLine();

                if (BankHelper.isValidPin(pin)){
                    break;
                }
            }
            while (true){
                System.out.println("Enter initial balance (must equal or great than 100): ");
                balance = sc.nextDouble();
                if(BankHelper.isValidInitialBalance(balance)){
                    break;
                }
            }

            return new Account(number, name, password, pin, balance);

        }
        return null;
    }

}

