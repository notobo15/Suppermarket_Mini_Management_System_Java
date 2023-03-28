package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_Account;
import UTILS.ConnectDB;

public class DAO_Account {
	private ConnectDB con = new ConnectDB();
	public ArrayList<DTO_Account> findAll() {
		ArrayList<DTO_Account> list = new ArrayList<>();
		 ResultSet rs = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM account WHERE status = 1");
			rs = ptm.executeQuery();
			while( rs.next()) {
				int account_id = rs.getInt("account_id");
				String account_name = rs.getString("account_name");
				String password = rs.getString("password");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String phone = rs.getString("phone");	
				String birth_date = rs.getString("birth_date");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				Boolean status = rs.getBoolean("status");
				
				DTO_Account dto_acc = new DTO_Account(account_id, account_id, account_name, password, first_name, last_name, phone, address, gender, birth_date, status);
			
				list.add(dto_acc);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public DTO_Account findById(int id) {
		 ResultSet rs = null;
		 DTO_Account dto_acc = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM account WHERE account_id = ? and status = 1");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while( rs.next()) {
				int account_id = rs.getInt("account_id");
				String account_name = rs.getString("account_name");
				String password = rs.getString("password");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String phone = rs.getString("phone");	
				String birth_date = rs.getString("birth_date");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				Boolean status = rs.getBoolean("status");
				
				dto_acc = new DTO_Account(account_id, account_id, account_name, password, first_name, last_name, phone, address, gender, birth_date, status);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto_acc;
	}
	
	public boolean create(DTO_Account accNew) {
		try {
			String query = "INSERT INTO account(account_name, password, first_name, last_name, phone, birth_date, address, gender)"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			System.out.println(accNew.toString());
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, accNew.getAccountName());
			ptm.setString(2, accNew.getPasssword());
			ptm.setString(3, accNew.getFirstName());
			ptm.setString(4, accNew.getLastName());
			ptm.setString(5, accNew.getPhone());
			ptm.setString(6, accNew.getBirthDate());
			ptm.setString(7, accNew.getAddress());
			ptm.setString(8, accNew.getGender());
			
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean unDeteleById(int id) {
		 int rs;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE account SET status = 1 WHERE account_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeUpdate();
			
			con.closeConnection();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deteleById(int id) {
		 int rs;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE account SET status = 0 WHERE account_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeUpdate();
			
			con.closeConnection();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean updateById(DTO_Account accNew) {
		try {
			String query = "UPDATE account SET password = ?, first_name = ?, last_name = ?, phone = ?,birth_date = ?, address = ?, gender = ?  where account_id = ? AND status = 1;";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, accNew.getPasssword());
			ptm.setString(2, accNew.getFirstName());
			ptm.setString(3, accNew.getLastName());
			ptm.setString(4, accNew.getPhone());
			ptm.setString(5, accNew.getBirthDate());
			ptm.setString(6, accNew.getAddress());
			ptm.setString(7, accNew.getGender());
			ptm.setInt(8, accNew.getAccountId());
			int result = ptm.executeUpdate();
			
			con.closeConnection();
			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    public boolean checkExistById(int id) throws SQLException {
        boolean isExist = false;
        PreparedStatement psm = con.getConnection().prepareStatement("SELECT * FROM account WHERE account_id = ? AND status = 1;");
        psm.setInt(1, id);
        ResultSet rs = psm.executeQuery();
        if (rs.next()) {
            isExist = true;
        }
        return isExist;
    }
	public boolean checkExistByName(String name) throws SQLException {
        boolean isExist = false;
        PreparedStatement psm = con.getConnection().prepareStatement("SELECT * FROM account WHERE account_name = ? AND status = 1;");
        psm.setString(1, name);
        ResultSet rs = psm.executeQuery();
        if (rs.next()) {
            isExist = true;
        }
        return isExist;
    }
}
