package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_Role;
import UTILS.ConnectDB;

public class DAO_Role {
	
	public ArrayList<DTO_Role> findAll() throws SQLException {
		ArrayList<DTO_Role> list = new ArrayList<>();
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM role");
			rs = ptm.executeQuery();
			while( rs.next()) {
				int id = rs.getInt("role_id");
				String name = rs.getString("name");
				
				DTO_Role role = new DTO_Role(id, name);
			
				list.add(role);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi findAll role");
		}
		return list;
	}
	
	
	public DTO_Role findById(int id) throws SQLException {
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		 DTO_Role suppilier = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM role WHERE role_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while( rs.next()) {
				int role_id = rs.getInt("role_id");
				String name = rs.getString("name");
				
				suppilier = new DTO_Role(role_id, name);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao role where id = " + id);
		}
		return suppilier;
	}
	
	public boolean create(DTO_Role newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO role(name)"
							+ "VALUES (?);";
			
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao role khong tao dc");
		}
		return false;
	}
	
	public boolean updateById(int id, DTO_Role newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE role SET name = ? where id = ?";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());

			ptm.setInt(5, id);
			int result = ptm.executeUpdate();
			
			con.closeConnection();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi update role where id = " + id);
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
