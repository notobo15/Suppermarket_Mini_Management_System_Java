package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_Product;
import UTILS.ConnectDB;

public class DAO_Product {

	private ConnectDB con = new ConnectDB();

	public ArrayList<DTO_Product> findAll() throws SQLException {
		ArrayList<DTO_Product> list = new ArrayList<>();
		ResultSet rs = null;
		ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM product where status = 1");
			rs = ptm.executeQuery();
			while (rs.next()) {
				int ProductId = rs.getInt("product_id");
				String name = rs.getString("name");
				String desc = rs.getString("description");
				float price = rs.getFloat("price");
				float quantity = rs.getFloat("quantity");
				String img = rs.getString("img");
				String mass = rs.getString("mass");
				String expireDate = rs.getString("expire_date");
				String makeIn = rs.getString("trademark");
				Boolean status = rs.getBoolean("status");
				int categoryId = rs.getInt("cate_id");

				DTO_Product product = new DTO_Product(ProductId, categoryId, name, desc, img, mass, makeIn, expireDate,
						quantity, price, status);

				list.add(product);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public DTO_Product findById(int ProductId) throws SQLException {
		ResultSet rs = null;
		ConnectDB con = new ConnectDB();
		DTO_Product product = null;
		try {
			PreparedStatement ptm = con.getConnection()
					.prepareStatement("SELECT * FROM product WHERE product_id = ? and status = 1;");
			ptm.setInt(1, ProductId);
			rs = ptm.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String desc = rs.getString("description");
				float price = rs.getFloat("price");
				float quantity = rs.getFloat("quantity");
				String img = rs.getString("img");
				String mass = rs.getString("mass");
				String expireDate = rs.getString("expire_date");
				String trademark = rs.getString("trademark");
				Boolean status = rs.getBoolean("status");
				int categoryId = rs.getInt("cate_id");

				product = new DTO_Product(ProductId, categoryId, name, desc, img, mass, trademark, expireDate, quantity,
						price, status);

			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public boolean create(DTO_Product newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO product(name, description, img, mass, trademark, expireDate, quantity, price, cate_id)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setString(2, newObj.getDescription());
			ptm.setString(3, newObj.getImg());
			ptm.setString(4, newObj.getMass());
			ptm.setString(5, newObj.gettrademark());
			ptm.setString(6, newObj.getExpireDate());
			ptm.setFloat(7, newObj.getQuantity());
			ptm.setFloat(8, newObj.getPrice());
			ptm.setInt(9, newObj.getCategoryId());

			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateById(DTO_Product newObj) throws SQLException {
		ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET name = ?, description = ?, img = ?, mass = ?, trademark = ?, expire_date = ?, quantity = ?, price = ?, cate_id = ? where id = ? and status = 1;";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
			ptm.setString(2, newObj.getDescription());
			ptm.setString(3, newObj.getImg());
			ptm.setString(4, newObj.getMass());
			ptm.setString(5, newObj.gettrademark());
			ptm.setString(6, newObj.getExpireDate());
			ptm.setFloat(7, newObj.getQuantity());
			ptm.setFloat(8, newObj.getPrice());
			ptm.setInt(9, newObj.getCategoryId());

			ptm.setInt(10, newObj.getProductId());

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
					.prepareStatement("UPDATE product SET status = 0 WHERE product_id = ?");
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
				.prepareStatement("SELECT * FROM product WHERE product_id = ? AND status = 1;");
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
					.prepareStatement("UPDATE product SET status = 1 WHERE product_id = ?");
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
