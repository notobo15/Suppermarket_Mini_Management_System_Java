package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_Order;
import UTILS.ConnectDB;

public class DAO_Order {

	public ArrayList<DTO_Order> findAll() throws SQLException {
		ArrayList<DTO_Order> list = new ArrayList<>();
		ResultSet rs = null;
		ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM order where status = 1");
			rs = ptm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("order_id");
				int accountId = rs.getInt("account_id");
				String orderDate = rs.getString("order_date");
				int customerId = rs.getInt("customer_id");
				Boolean status = rs.getBoolean("status");

				DTO_Order order = new DTO_Order(id, accountId, orderDate, customerId, status);

				list.add(order);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public DTO_Order findById(int id) throws SQLException {
		ResultSet rs = null;
		ConnectDB con = new ConnectDB();
		DTO_Order suppilier = null;
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("SELECT * FROM order WHERE order_id = ? where status = 1");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while (rs.next()) {
				int orderId = rs.getInt("order_id");
				int accountId = rs.getInt("account_id");
				String orderDate = rs.getString("order_date");
				int customerId = rs.getInt("customer_id");
				Boolean status = rs.getBoolean("status");

				suppilier = new DTO_Order(orderId, accountId, orderDate, customerId, status);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suppilier;
	}

	public boolean create(DTO_Order newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO order(account_id, order_date, customer_id)" + "VALUES (?, ?, ?);";

			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setInt(1, newObj.getAccountId());
			ptm.setString(2, newObj.getOrderDate());
			ptm.setInt(3, newObj.getCustomerId());

			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao suppilier khong tao dc");
		}
		return false;
	}

	public boolean updateById(DTO_Order newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET status = ? WHERE order_id = ?";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setBoolean(1, newObj.isStatus());
			ptm.setString(2, newObj.getOrderDate());

			ptm.setInt(5, newObj.getOrderId());
			int result = ptm.executeUpdate();

			con.closeConnection();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deteleById(int id) throws SQLException {
		int rs;
		ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("UPDATE order SET status = 0 WHERE order_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeUpdate();

			con.closeConnection();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkExistById(int id) throws SQLException {
		boolean isExist = false;
		ConnectDB con = new ConnectDB();
		PreparedStatement psm = con.getConnection()
				.prepareStatement("SELECT * FROM order WHERE order_id = ? AND status = 1;");
		psm.setInt(1, id);
		ResultSet rs = psm.executeQuery();
		if (rs.next()) {
			isExist = true;
		}
		return isExist;
	}

	public boolean unDeteleById(int id) {
		int rs;
		ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("UPDATE order SET status = 1 WHERE order_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeUpdate();

			con.closeConnection();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
