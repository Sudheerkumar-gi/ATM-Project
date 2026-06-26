package ATM-Project;
    
import java.util.Scanner;


public class ATMApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ATMBackend atm = new ATMBackend();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (atm.login(accNo, pin)) {
            System.out.println("Login Successful!");
            while (true) {
                System.out.println("\n1. Balance\n2. Deposit\n3. Withdraw\n4. Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Balance: " + atm.getBalance(accNo));
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        atm.deposit(accNo, dep);
                        System.out.println("Deposit Successful!");
                        break;
                    case 3:
                        System.out.print("Enter withdraw amount: ");
                        double wd = sc.nextDouble();
                        if (atm.withdraw(accNo, wd))
                            System.out.println("Withdrawal Successful!");
                        else
                            System.out.println("Insufficient Balance!");
                        break;
                    case 4:
                        System.out.println("Thank you for using ATM!");
                        return;
                }
            }
        } else {
            System.out.println("Invalid Credentials!");
        }
    }
}
