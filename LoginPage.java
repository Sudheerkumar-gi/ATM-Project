package ATM-Project;

import java.sql.*;

public class LoginPage {
    public boolean login(int accNo, int pin) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM accounts WHERE acc_no=? AND pin=?");
        ps.setInt(1, accNo);
        ps.setInt(2, pin);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}

