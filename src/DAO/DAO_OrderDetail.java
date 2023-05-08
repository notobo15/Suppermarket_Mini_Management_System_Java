package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_ImportDetail;
import DTO.DTO_OrderDetail;
import UTILS.ConnectDB;

public class DAO_OrderDetail {

	public ArrayList<DTO_OrderDetail> findAll() throws SQLException {
		ArrayList<DTO_OrderDetail> list = new ArrayList<>();
		ResultSet rs = null;
		ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM order_detail WHERE status = 1");
			rs = ptm.executeQuery();
			while (rs.next()) {
				int orderDetId = rs.getInt("order_det_id");
				int orderId = rs.getInt("order_id");
				int productId = rs.getInt("product_id");
				float price = rs.getFloat("price");
				float quantity = rs.getFloat("quantity");
				Boolean status = rs.getBoolean("status");

				DTO_OrderDetail detail = new DTO_OrderDetail(orderDetId, productId, price, quantity, orderId, status);

				list.add(detail);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public DTO_OrderDetail findById(int id) throws SQLException {
		ResultSet rs = null;
		ConnectDB con = new ConnectDB();
		DTO_OrderDetail detail = null;
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("SELECT * FROM order_detail WHERE order_det_id = ? and status = 1");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while (rs.next()) {
				int orderDetId = rs.getInt("order_det_id");
				int orderId = rs.getInt("order_det_id");
				int productId = rs.getInt("product_id");
				float price = rs.getFloat("price");
				float quantity = rs.getFloat("quantity");
				Boolean status = rs.getBoolean("status");

				detail = new DTO_OrderDetail(orderDetId, productId, price, quantity, orderId, status);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detail;
	}

	public boolean create(DTO_OrderDetail newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO order_detail(order_id, product_id, price, quantity)" + "VALUES (?, ?, ?, ?);";

			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setInt(1, newObj.getOrder_id());
			ptm.setInt(2, newObj.getProduct_id());
			ptm.setFloat(3, newObj.getPrice());
			ptm.setFloat(4, newObj.getQuanity());
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateById(DTO_OrderDetail newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET order_id = ?, product_id = ?, price = ?, quantity = ? where id = ? and status = 1";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setInt(1, newObj.getOrder_id());
			ptm.setInt(2, newObj.getProduct_id());
			ptm.setFloat(3, newObj.getPrice());
			ptm.setFloat(4, newObj.getQuanity());

			ptm.setInt(5, newObj.getId());
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
					.prepareStatement("UPDATE order_detail SET status = 0 WHERE order_det_id = ?");
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
				.prepareStatement("SELECT * FROM order_detail WHERE order_det_id = ? AND status = 1;");
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
					.prepareStatement("UPDATE order_detail SET status = 1 WHERE order_det_id = ?");
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
