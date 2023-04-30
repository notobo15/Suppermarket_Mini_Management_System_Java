/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Discount;
import UTILS.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author notobo
 */
public class DAO_Discount {

    private String table_name = "discount";

    public ArrayList<DTO_Discount> findAll() throws SQLException {
        ArrayList<DTO_Discount> list = new ArrayList<>();
        ResultSet rs = null;
        ConnectDB con = new ConnectDB();
        try {
            PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM " + this.table_name + " where isDeleted = 0");
            rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Float percent = rs.getFloat("percent");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                String createAt = rs.getString("createAt");
                boolean isDeleted = rs.getBoolean("isDeleted");
                DTO_Discount discount = new DTO_Discount(id, name, startDate, endDate, percent, createAt, isDeleted);

                list.add(discount);
            }
            con.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public DTO_Discount findById(int id) throws SQLException {
        ResultSet rs = null;
        ConnectDB con = new ConnectDB();
        DTO_Discount discount = null;
        try {
            PreparedStatement ptm = con.getConnection()
                    .prepareStatement("SELECT * FROM " + this.table_name + " WHERE id = ? and isDeleted = 0");
            ptm.setInt(1, id);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Float percent = rs.getFloat("percent");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                String createAt = rs.getString("createAt");
                boolean isDeleted = rs.getBoolean("isDeleted");
                discount = new DTO_Discount(id, name, startDate, endDate, percent, createAt, isDeleted);

            }
            con.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discount;
    }

//    public boolean create(DTO_Discount newObj) throws SQLException {
//        ConnectDB con = new ConnectDB();
//        try {
//            String query = "INSERT INTO " + this.table_name + "(name)" + "VALUES (?);";
//
//            PreparedStatement ptm = con.getConnection().prepareStatement(query);
//            ptm.setString(1, newObj.getName());
//
//            int result = ptm.executeUpdate();
//            con.closeConnection();
//            return result > 0;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return false;
//    }

//    public boolean updateById(DTO_Discount newObj) throws SQLException {
//        ConnectDB con = new ConnectDB();
//        try {
//            String query = "UPDATE " + this.table_name + " SET name = ? where role_id = ? and status = 1";
//            PreparedStatement ptm = con.getConnection().prepareStatement(query);
//            ptm.setString(1, newObj.getName());
//            ptm.setInt(2, newObj.getRoleId());
//
//            int result = ptm.executeUpdate();
//
//            con.closeConnection();
//            return result > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public boolean deteleById(int id) throws SQLException {
        int rs;
        ConnectDB con = new ConnectDB();
        try {
            PreparedStatement ptm = con.getConnection()
                    .prepareStatement("UPDATE " + this.table_name + " SET isDeleted = 1 WHERE id = ?");
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
                .prepareStatement("SELECT * FROM " + this.table_name + " WHERE id = ? AND isDeleted = 0;");
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
                    .prepareStatement("UPDATE " + this.table_name + " SET isDeleted = 0 WHERE id = ?");
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
