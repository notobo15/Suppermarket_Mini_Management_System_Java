package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_Product;
import UTILS.ConnectDB;

public class DAO_Product {
	
	public ArrayList<DTO_Product> findAll() throws SQLException {
		ArrayList<DTO_Product> list = new ArrayList<>();
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM product");
			rs = ptm.executeQuery();
			while( rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("name");
				String desc = rs.getString("description");
				float price = rs.getFloat("price");
				float quantity = rs.getFloat("quantity");
				String ingredient = rs.getString("ingredient");
				String img = rs.getString("img");
				String mass = rs.getString("mass");
				String howToUse = rs.getString("how_to_use");
				String preserve = rs.getString("preserve");
				String expireDate = rs.getString("expire_date");
				String makeIn = rs.getString("make_in");
				String tradeMark = rs.getString("trademark");
				Boolean status = rs.getBoolean("status");
				int categoryId = rs.getInt("cate_id");
				
				DTO_Product product = new DTO_Product(id, categoryId, name, desc, img, mass, ingredient, howToUse, preserve, tradeMark, makeIn, expireDate, quantity, price, status);
			
				list.add(product);
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi findAll product");
		}
		return list;
	}
	
	
	public DTO_Product findById(int ProductId) throws SQLException {
		 ResultSet rs = null;
		 ConnectDB con = new ConnectDB();
		 DTO_Product product = null;
		try {
			PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM product WHERE product_id = ?");
			ptm.setInt(1, ProductId);
			rs = ptm.executeQuery();
			while( rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("name");
				String desc = rs.getString("desc");
				float price = rs.getFloat("price");
				float quantity = rs.getFloat("quantity");
				String ingredient = rs.getString("ingredient");
				String img = rs.getString("img");
				String mass = rs.getString("mass");
				String howToUse = rs.getString("howToUse");
				String preserve = rs.getString("preserve");
				String expireDate = rs.getString("expireDate");
				String makeIn = rs.getString("makeIn");
				String tradeMark = rs.getString("tradeMark");
				Boolean status = rs.getBoolean("status");
				int categoryId = rs.getInt("category_id");
				
				product = new DTO_Product(id, categoryId, name, desc, img, mass, ingredient, howToUse, preserve, tradeMark, makeIn, expireDate, quantity, price, status);
			
			}
			con.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao product where id = " + ProductId);
		}
		return product;
	}
	
	public boolean create(DTO_Product newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "INSERT INTO suppilier(name, address, phone)"
							+ "VALUES (?, ?, ?);";
			
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
//			ptm.setString(2, newObj.getAddress());
//			ptm.setString(3, newObj.getPhone());
			
			int result = ptm.executeUpdate();
			con.closeConnection();
			return result > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi dao suppilier khong tao dc");
		}
		return false;
	}
	
	public boolean updateById(int id, DTO_Product newObj) throws SQLException {
		 ConnectDB con = new ConnectDB();
		try {
			String query = "UPDATE account SET name = ?, address = ?, phone = ?, status = ? where id = ?";
			PreparedStatement ptm = con.getConnection().prepareStatement(query);
			ptm.setString(1, newObj.getName());
//			ptm.setString(2, newObj.getAddress());
//			ptm.setString(3, newObj.getPhone());
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
