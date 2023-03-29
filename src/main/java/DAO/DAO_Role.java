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
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM role where status = 1");
			rs = ptm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("role_id");
				String name = rs.getString("name");
				boolean status = rs.getBoolean("status");
				DTO_Role role = new DTO_Role(id, name, status);

				list.add(role);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public DTO_Role findById(int id) throws SQLException {
		ResultSet rs = null;
		ConnectDB con = new ConnectDB();
		DTO_Role suppilier = null;
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("SELECT * FROM role WHERE role_id = ? and status = 1");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while (rs.next()) {
				int role_id = rs.getInt("role_id");
				String name = rs.getString("name");
				boolean status = rs.getBoolean("status");
				suppilier = new DTO_Role(role_id, name, status);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suppilier;
	}

	public boolean create(DTO_Role newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO role(name)" + "VALUES (?);";

			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());

			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public boolean updateById(DTO_Role newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE role SET name = ? where role_id = ? and status = 1";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setInt(2, newObj.getRoleId());

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
					.prepareStatement("UPDATE role SET status = 0 WHERE role_id = ?");
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
				.prepareStatement("SELECT * FROM role WHERE role_id = ? AND status = 1;");
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
					.prepareStatement("UPDATE role SET status = 1 WHERE role_id = ?");
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
