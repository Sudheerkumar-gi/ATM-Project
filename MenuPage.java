package ATM-Project;

import java.util.Scanner;

public class MenuPage {
    public void showMenu(int accNo) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. Balance\n2. Deposit\n3. Withdraw\n4. History\n5. Exit");
            int choice = sc.nextInt();
            switch(choice) {
                case 1: new BalancePage().showBalance(accNo); break;
                case 2: new DepositPage().deposit(accNo); break;
                case 3: new WithdrawPage().withdraw(accNo); break;
                case 4: new HistoryPage().showHistory(accNo); break;
                case 5: return;
            }
        }
    }
}
