package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_Customer;
import UTILS.ConnectDB;

public class DAO_Customer {
	
	public ArrayList<DTO_Customer> findAll() throws SQLException {
		ArrayList<DTO_Customer> list = new ArrayList<>();
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM customer");
			rs = ptm.executeQuery();
			while( rs.next()) {
				int id = rs.getInt("customer_id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String birth_date = rs.getString("birth_date");
				String address = rs.getString("address");
				Boolean status = rs.getBoolean("status");
				
				DTO_Customer newObj = new DTO_Customer(id, name, phone, address, gender, birth_date, status);
			
				list.add(newObj);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao customer");
		}
		return list;
	}
	
	
	public DTO_Customer findById(int id) throws SQLException {
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		 DTO_Customer newObj = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM account WHERE account_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while( rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String gender = rs.getString("gender");
				String birth_date = rs.getString("birth_date");
				String address = rs.getString("address");
				Boolean status = rs.getBoolean("status");
				
				newObj = new DTO_Customer(id, name, phone, address, gender, birth_date, status);
			
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao account where id = " + id);
		}
		return newObj;
	}
	
	public boolean create(DTO_Customer newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO account(name, phone, gender, birth_date, address)"
							+ "VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setString(2, newObj.getPhone());
			ptm.setString(3, newObj.getGender());
			ptm.setString(4, newObj.getBirthDate());
			ptm.setString(5, newObj.getAddress());
			
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;
			
		} catch (Exception e) {
			System.out.println("loi dao customer khong tao dc");
		}
		return false;
	}
	
	public boolean deteleById(int id) throws SQLException {
		 int rs;
		 ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("DELETE FROM account WHERE account_id = ?");
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
	
	public boolean updateById(int id, DTO_Customer newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET name = ?, phone = ?, gender = ?, birth_date = ?, address = ?, status = ?  where account_id = ?";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setString(2, newObj.getPhone());
			ptm.setString(3, newObj.getGender());
			ptm.setString(4, newObj.getBirthDate());
			ptm.setString(5, newObj.getAddress());
			ptm.setBoolean(6, newObj.getStatus());
			ptm.setInt(7, id);
			int result = ptm.executeUpdate();
			
			con.closeConnection();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi update customer where id = " + id);
		}
		return false;
	}
	
}
