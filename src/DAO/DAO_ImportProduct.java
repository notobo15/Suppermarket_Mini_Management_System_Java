package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_ImportProduct;
import UTILS.ConnectDB;
import java.sql.Statement;

public class DAO_ImportProduct {

	public ArrayList<DTO_ImportProduct> findAll() throws SQLException {
		ArrayList<DTO_ImportProduct> list = new ArrayList<>();
		ResultSet rs = null;
		ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("SELECT * FROM import_product where status = 1");
			rs = ptm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("import_id");
				int accountId = rs.getInt("account_id");
				String orderDate = rs.getString("date");
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
		ConnectDB con = new ConnectDB();
		DTO_ImportProduct importProduct = null;
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("SELECT * FROM import_product WHERE import_id = ? and status = 1");
			ptm.setInt(1, id);
			rs = ptm.executeQuery();
			while (rs.next()) {
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

	public int create(DTO_ImportProduct newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		int id = 0;
                try {
			String query = "INSERT INTO import_product(suppilier_id,account_id)" + "VALUES (?, ?);";

			PreparedStatement ptm = con.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ptm.setInt(1, newObj.getSuppilierId());
			ptm.setInt(2, newObj.getAccountId());

			ptm.executeUpdate();
			ResultSet rs = ptm.getGeneratedKeys();
			 if (rs.next()){
                            id=rs.getInt(1);
                        }
			con.closeConnection();
			return id;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public boolean updateById(DTO_ImportProduct newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
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
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("UPDATE import_product SET status = 0 WHERE import_id = ?");
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
				.prepareStatement("SELECT * FROM import_product WHERE import_id = ? AND status = 1;");
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
					.prepareStatement("UPDATE import_product SET status = 1 WHERE import_id = ?");
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
