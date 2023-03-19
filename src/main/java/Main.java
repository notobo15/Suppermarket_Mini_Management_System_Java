
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
       public static void main(String[] args) throws SQLException {
        ConnectDB con = new ConnectDB();
        ResultSet rs = null;
        PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM user");
           rs = ptm.executeQuery();
           while ( rs.next()) {
               
               System.out.println(rs.getInt("user_id"));
           }
    }
}
