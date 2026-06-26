package ATM-Project;

import java.sql.*;

public class DepositPage {
    public void deposit(int accNo) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE accounts SET balance = balance + ? WHERE acc_no=?");
        ps.setDouble(1, 1000); // example deposit
        ps.setInt(2, accNo);
        ps.executeUpdate();

        PreparedStatement ts = con.prepareStatement(
            "INSERT INTO transactions(acc_no,type,amount) VALUES(?,?,?)");
        ts.setInt(1, accNo);
        ts.setString(2, "Deposit");
        ts.setDouble(3, 1000);
        ts.executeUpdate();
    }
}
