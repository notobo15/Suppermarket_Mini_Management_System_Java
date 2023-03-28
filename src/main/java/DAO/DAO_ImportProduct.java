package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_ImportProduct;
import UTILS.ConnectDB;

public class DAO_ImportProduct {
	private ConnectDB con = new ConnectDB();
	
	public ArrayList<DTO_ImportProduct> findAll() throws SQLException {
		ArrayList<DTO_ImportProduct> list = new ArrayList<>();
		 ResultSet rs = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM import_product where status = 1");
			rs = ptm.executeQuery();
			while( rs.next()) {
				int id = rs.getInt("order_id");
				int accountId = rs.getInt("account_id");
				String orderDate = rs.getString("order_date");
				int suppilierId = rs.getInt("suppilier_id");
				Boolean status = rs.getBoolean("status");
				
				DTO_ImportProduct importProduct = new DTO_ImportProduct(id, suppilierId, accountId, orderDate, status);
			
				list.add(importProduct);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public DTO_ImportProduct findById(int id) throws SQLException {
		 ResultSet rs = null;
		 DTO_ImportProduct importProduct = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM import_product WHERE import_id = ? and status = 1");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while( rs.next()) {
				int accountId = rs.getInt("account_id");
				String orderDate = rs.getString("order_date");
				int suppilierId = rs.getInt("suppilier_id");
				Boolean status = rs.getBoolean("status");
				
				importProduct = new DTO_ImportProduct(id, suppilierId, accountId, orderDate, status);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return importProduct;
	}
	
	public boolean create(DTO_ImportProduct newObj) throws SQLException {
		try {
			String query = "INSERT INTO import_product(suppilier_id, import_date, account_id)"
							+ "VALUES (?, ?, ?);";
			
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setInt(1, newObj.getSuppilierId());
			ptm.setString(2, newObj.getImportDate());
			ptm.setInt(3, newObj.getAccountId());
			
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateById(DTO_ImportProduct newObj) throws SQLException {
		try {
			String query = "UPDATE import_product SET suppilier_id = ?, import_date = ?, account_id = ? where import_id = ? and status = 1";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setInt(1, newObj.getSuppilierId());
			ptm.setString(2, newObj.getImportDate());
			ptm.setInt(3, newObj.getAccountId());

			ptm.setInt(4, newObj.getId());
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
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE import_product SET status = 0 WHERE import_id = ?");
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
		PreparedStatement psm = con.getConnection().prepareStatement("SELECT * FROM import_product WHERE import_id = ? AND status = 1;");
		psm.setInt(1, id);
		ResultSet rs = psm.executeQuery();
		if (rs.next()) {
			isExist = true;
		}
		return isExist;
	}
	public boolean unDeteleById(int id) {
		 int rs;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE import_product SET status = 1 WHERE import_id = ?");
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
