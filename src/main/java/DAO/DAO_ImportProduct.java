package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_ImportProduct;
import UTILS.ConnectDB;

public class DAO_ImportProduct {
	
	public ArrayList<DTO_ImportProduct> findAll() throws SQLException {
		ArrayList<DTO_ImportProduct> list = new ArrayList<>();
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM import_product");
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
			System.out.println("loi findAll suppilier");
		}
		return list;
	}
	
	
	public DTO_ImportProduct findById(int id) throws SQLException {
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		 DTO_ImportProduct importProduct = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM import WHERE import_id = ?");
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
			System.out.println("loi dao suppilier where id = " + id);
		}
		return importProduct;
	}
	
	public boolean create(DTO_ImportProduct newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
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
			System.out.println("loi dao suppilier khong tao dc");
		}
		return false;
	}
	
	public boolean updateById(int id, DTO_ImportProduct newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET name = ?, address = ?, phone = ?, status = ? where id = ?";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
//			ptm.setString(1, newObj.getName());
//			ptm.setString(2, newObj.getAddress());
//			ptm.setString(3, newObj.getPhone());
//			ptm.setBoolean(4, newObj.isStatus());

			ptm.setInt(5, id);
			int result = ptm.executeUpdate();
			
			con.closeConnection();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi update category where id = " + id);
		}
		return false;
	}
	
	public boolean deteleById(int id) throws SQLException {
		 int rs;
		 ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("DELETE FROM category_product WHERE product_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeUpdate();
			
			con.closeConnection();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao account where id = " + id);
		}
		return false;
	}
}
