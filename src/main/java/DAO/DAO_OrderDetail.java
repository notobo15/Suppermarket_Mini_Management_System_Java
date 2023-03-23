package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_Suppilier;
import UTILS.ConnectDB;

public class DAO_OrderDetail {
	
	public ArrayList<DTO_Suppilier> findAll() throws SQLException {
		ArrayList<DTO_Suppilier> list = new ArrayList<>();
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM suppilier");
			rs = ptm.executeQuery();
			while( rs.next()) {
				int suppilierId = rs.getInt("suppilier_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				Boolean status = rs.getBoolean("status");
				
				DTO_Suppilier suppilier = new DTO_Suppilier(suppilierId, name, phone, address, status);
			
				list.add(suppilier);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi findAll suppilier");
		}
		return list;
	}
	
	
	public DTO_Suppilier findById(int id) throws SQLException {
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		 DTO_Suppilier suppilier = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM suppilier WHERE suppilier_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while( rs.next()) {
				int suppilierId = rs.getInt("suppilier_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				Boolean status = rs.getBoolean("status");
				
				suppilier = new DTO_Suppilier(suppilierId, name, phone, address, status);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao suppilier where id = " + id);
		}
		return suppilier;
	}
	
	public boolean create(DTO_Suppilier newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO suppilier(name, address, phone)"
							+ "VALUES (?, ?, ?);";
			
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setString(2, newObj.getAddress());
			ptm.setString(3, newObj.getPhone());
			
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao suppilier khong tao dc");
		}
		return false;
	}
	
	public boolean updateById(int id, DTO_Suppilier newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET name = ?, address = ?, phone = ?, status = ? where id = ?";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setString(2, newObj.getAddress());
			ptm.setString(3, newObj.getPhone());
			ptm.setBoolean(4, newObj.isStatus());

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
