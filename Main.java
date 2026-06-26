package ATM-Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account No: ");
        int accNo = sc.nextInt();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        LoginPage login = new LoginPage();
        if(login.login(accNo, pin)) {
            new MenuPage().showMenu(accNo);
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}

}
