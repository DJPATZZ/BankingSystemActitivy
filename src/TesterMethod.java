import java.util.Scanner;


public class TesterMethod {
    public static void main(String[] args) {

        Bank bank = new Bank();


        for (Account a : bank.getAccountList()){
            if ("Patrick".equals(a.getAccountName())){
                System.out.println("Helloo");
            }
            if ("23A156".equals(a.getAccountNumber())){
                System.out.println("Hii");
            }
            if ("1234".equals(a.getPin())){
                System.out.println("Correct");
            }
        }

    }
}
