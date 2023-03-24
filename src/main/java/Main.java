
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAO_Account;
import DAO.DAO_Product;
import DTO.DTO_Account;
import DTO.DTO_Product;

public class Main {
	public static void main(String[] args) throws SQLException {

		DAO_Account dao_acc = new DAO_Account();
		DAO_Product dao_product = new DAO_Product();
		
		ArrayList<DTO_Account> list = dao_acc.findAll();
		ArrayList<DTO_Product> listPorduct = dao_product.findAll();
		
		for (DTO_Product item : listPorduct) {
			System.out.println(item.toString());
		}
		
		System.out.println("-------------------");
//		String str = dao_acc.findById(1).toString();
//		System.out.println(str);
		
		

//		DTO_Account acc1 = new DTO_Account(5, "11111", "Test1", "Chris", "012334234", "HCM", "nu", "1999-11-1");
//		System.out.println(acc1.toString());
//		System.out.println(dao_acc.updateById(8, acc1));
//		System.out.println(dao_acc.create(new DTO_Account(1, 1, "test", "123", "Test", "Nguyễn", "0123455678", "LA", "nam", "2000-1-1", true)));

//        ConnectDB con = new ConnectDB();
//        ResultSet rs = null;
//        PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM account");
//           rs = ptm.executeQuery();
//           while ( rs.next()) {
//               
//               System.out.println(rs.getString("account_name"));
//               System.out.println(rs.getString("password"));
//           }
	}

}
