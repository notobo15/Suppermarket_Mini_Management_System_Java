package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_Customer;
import UTILS.ConnectDB;

public class DAO_Customer {
	private ConnectDB con = new ConnectDB();

	public ArrayList<DTO_Customer> findAll() throws SQLException {
		ArrayList<DTO_Customer> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM customer WHERE status = 1");
			rs = ptm.executeQuery();
			while (rs.next()) {
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
		}
		return list;
	}

	public DTO_Customer findById(int id) throws SQLException {
		ResultSet rs = null;
		DTO_Customer newObj = null;
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("SELECT * FROM customer WHERE customer_id = ? AND status = 1");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while (rs.next()) {
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
		}
		return newObj;
	}

	public boolean create(DTO_Customer newObj) throws SQLException {
		try {
			String query = "INSERT INTO account(name, phone, gender, birth_date, address)" + "VALUES (?, ?, ?, ?, ?);";

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
			e.printStackTrace();
		}
		return false;
	}

	public boolean deteleById(int id) throws SQLException {
		int rs;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE customer SET status = 0 WHERE account_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeUpdate();

			con.closeConnection();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean unDeteleById(int id) {
		 int rs;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("UPDATE customer SET status = 1 WHERE account_id = ?");
			ptm.setInt(1, id);
			rs = ptm.executeUpdate();
			
			con.closeConnection();
			return rs > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateById(DTO_Customer newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET name = ?, phone = ?, gender = ?, birth_date = ?, address = ? where account_id = ? and status = 1";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setString(2, newObj.getPhone());
			ptm.setString(3, newObj.getGender());
			ptm.setString(4, newObj.getBirthDate());
			ptm.setString(5, newObj.getAddress());
			ptm.setInt(6, newObj.getCustomerId());
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
		PreparedStatement psm = con.getConnection().prepareStatement("SELECT * FROM customer WHERE customer_id = ? AND status = 1;");
		psm.setInt(1, id);
		ResultSet rs = psm.executeQuery();
		if (rs.next()) {
			isExist = true;
		}
		return isExist;
	}
}
