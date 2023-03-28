package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_CategoryProduct;
import UTILS.ConnectDB;

public class DAO_CategoryProduct {
	private ConnectDB con = new ConnectDB();
	
	public ArrayList<DTO_CategoryProduct> findAll() throws SQLException {
		ArrayList<DTO_CategoryProduct> list = new ArrayList<>();
		 ResultSet rs = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM category_product WHERE status = 1");
			rs = ptm.executeQuery();
			while( rs.next()) {
				int category_id = rs.getInt("category_id");
				String name = rs.getString("name");
				String desc = rs.getString("desc");
				Boolean status = rs.getBoolean("status");
				
				DTO_CategoryProduct category = new DTO_CategoryProduct(category_id, name, desc , status);
			
				list.add(category);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public DTO_CategoryProduct findById(int id) throws SQLException {
		 ResultSet rs = null;
		 DTO_CategoryProduct category = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM category_product WHERE category_id = ? AND status = 1");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while( rs.next()) {
				int category_id = rs.getInt("category_id");
				String name = rs.getString("name");
				String desc = rs.getString("desc");
				Boolean status = rs.getBoolean("status");
				
				category = new DTO_CategoryProduct(category_id, name, desc , status);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public boolean create(DTO_CategoryProduct newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO account(category_id, name, desc, status)"
							+ "VALUES (?, ?, ?, ?);";
			
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setInt(1, newObj.getId());
			ptm.setString(2, newObj.getName());
			ptm.setString(3, newObj.getDesc());
			ptm.setBoolean(4, newObj.getStatus());
			
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateById(int id, DTO_CategoryProduct newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET name = ?, desc = ?, status = ? where id = ? and status = 1";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setString(2, newObj.getDesc());
			ptm.setBoolean(3, newObj.getStatus());
			ptm.setInt(4, id);
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
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE category_product SET status = 0 WHERE category_id = ?");
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
		PreparedStatement psm = con.getConnection().prepareStatement("SELECT * FROM category_product WHERE category_id = ? AND status = 1;");
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
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE category_product SET status = 1 WHERE category_id = ?");
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
