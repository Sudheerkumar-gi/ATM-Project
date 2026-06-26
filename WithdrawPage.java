package ATM-Project;

import java.sql.*;

public class WithdrawPage {
    public void withdraw(int accNo) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT balance FROM accounts WHERE acc_no=?");
        ps.setInt(1, accNo);
        ResultSet rs = ps.executeQuery();
        if(rs.next() && rs.getDouble("balance") >= 500) {
            PreparedStatement upd = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE acc_no=?");
            upd.setDouble(1, 500); // example withdrawal
            upd.setInt(2, accNo);
            upd.executeUpdate();

            PreparedStatement ts = con.prepareStatement(
                "INSERT INTO transactions(acc_no,type,amount) VALUES(?,?,?)");
            ts.setInt(1, accNo);
            ts.setString(2, "Withdraw");
            ts.setDouble(3, 500);
            ts.executeUpdate();
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}

