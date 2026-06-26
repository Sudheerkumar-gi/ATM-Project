package ATM-Project;

    import java.sql.*;

public class HistoryPage {
    public void showHistory(int accNo) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM transactions WHERE acc_no=?");
        ps.setInt(1, accNo);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString("type") + " - " +
                               rs.getDouble("amount") + " on " +
                               rs.getTimestamp("date"));
        }
    }
}
