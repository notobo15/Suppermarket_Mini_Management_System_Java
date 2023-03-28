package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_ImportDetail;
import UTILS.ConnectDB;

public class DAO_ImportDetail {
	private ConnectDB con = new ConnectDB();
	
	public ArrayList<DTO_ImportDetail> findAll() throws SQLException {
		ArrayList<DTO_ImportDetail> list = new ArrayList<>();
		 ResultSet rs = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM import_detail WHERE status = 1");
			rs = ptm.executeQuery();
			while( rs.next()) {
				int id = rs.getInt("id");
				int importId = rs.getInt("import_id");
				int productId = rs.getInt("product_id");
				float quantity = rs.getFloat("quantity");
				float price = rs.getFloat("price");
				Boolean status = rs.getBoolean("status");
				
				DTO_ImportDetail importDetail = new DTO_ImportDetail(id, productId, price, quantity, importId, status);
			
				list.add(importDetail);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public DTO_ImportDetail findById(int id) throws SQLException {
		 ResultSet rs = null;
		 DTO_ImportDetail importDetail = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM import_detail WHERE id = ? and status = 1;");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while( rs.next()) {
				int importId = rs.getInt("import_id");
				int productId = rs.getInt("product_id");
				float quantity = rs.getFloat("quantity");
				float price = rs.getFloat("price");
				Boolean status = rs.getBoolean("status");
				

				importDetail = new DTO_ImportDetail(id, productId, price, quantity, importId, status);
			
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return importDetail;
	}
	
	public boolean create(DTO_ImportDetail newObj) throws SQLException {
		try {
			String query = "INSERT INTO import_detail(import_id, product_id, quantity, price)"
							+ "VALUES (?, ?, ?, ?);";
			
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setInt(1, newObj.getImportId());
			ptm.setInt(2, newObj.getProductId());
			ptm.setFloat(3, newObj.getQuanity());
			ptm.setFloat(4, newObj.getPrice());
			
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateById(int id, DTO_ImportDetail newObj) throws SQLException {
		try {
			String query = "UPDATE account SET name = ?, address = ?, phone = ? where id = ? and status = 1";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
//			ptm.setString(1, newObj.getName());
//			ptm.setString(2, newObj.getAddress());
//			ptm.setString(3, newObj.getPhone());

			ptm.setInt(5, id);
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
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE import_detail SET status = 0 WHERE id = ?");
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
		PreparedStatement psm = con.getConnection().prepareStatement("SELECT * FROM import_detail WHERE id = ? AND status = 1;");
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
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE import_detail SET status = 1 WHERE id = ?");
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
