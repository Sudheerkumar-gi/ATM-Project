package ATM-Project;

import java.sql.*;

public class BalancePage {
    public void showBalance(int accNo) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT balance FROM accounts WHERE acc_no=?");
        ps.setInt(1, accNo);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            System.out.println("Current Balance: " + rs.getDouble("balance"));
        }
    }
}
