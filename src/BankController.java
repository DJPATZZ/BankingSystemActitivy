import java.util.Scanner;
import java.util.ArrayList;
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
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch(InputMismatchException | NullPointerException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        boolean running = true;
        while (running){
            try {
                printMenu();
                int c = sc.nextInt();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch(NullPointerException e){

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
    public static Account authenticate(Bank bank, Scanner sc){
        System.out.println("""
                1. Log in
                2. Create Account
                Enter Choices:""");
        int c = sc.nextInt();
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

