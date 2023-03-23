package UTILS;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class ConnectDB {

//    Statement stm = null;
    ResultSet rs = null;
    Connection conn = null;
    String server = "localhost:3306";
    String dbName = "db_sieuthi_mini";
    String userName = "root";
    String pass = "";

    public ConnectDB() {
        checkDriver();
        setupConnection();
    }
//    public ConnectDB(String dbName) {
//        checkDriver();
//        server = "localhost:3306";
//        this.dbName = dbName;
//        userName = "FuelAdmin";
//        this.pass = "";
//        setupConnection();
//    }
//
//    public ConnectDB(String dbName, String userName, String pass, String server) {
//        checkDriver();
//        this.dbName = dbName;
//        this.userName = userName;
//        this.pass = pass;
//        this.server = server;
//        setupConnection();
//    }
//
//    public ConnectDB(String dbName, String userName, String pass) {
//        checkDriver();
//        this.dbName = dbName;
//        this.userName = userName;
//        this.pass = pass;
//        setupConnection();
//    }

//    public void logIn(String userName, String pass) {
//        this.userName = userName;
//        this.pass = pass;
//        setupConnection();
//    }

    public Connection setupConnection() {
        try {
            String url = "jdbc:mysql://" + server + "/" + dbName;
            conn = DriverManager.getConnection(url, userName, pass);
            return conn;
//            JOptionPane.showMessageDialog(null, "Ket noi database " + dbName + " thanh cong");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Khong the ket noi toi " + dbName);
            return null;
        }
    }
  

    public ResultSet sqlQry(PreparedStatement stm) {
        if (checkConnection()) {
            try {
                rs = stm.executeQuery();
//                JOptionPane.showMessageDialog(null, "Thuc thi Query thanh cong !!");
                return rs;
            } catch (SQLException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Loi thuc thi query !!");
            }
        }
        return null;
    }

    public Boolean sqlUpdate(PreparedStatement stm) {
        if (checkConnection()) {
            try {
                stm.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Thuc thi Update thanh cong !!");
                return true;
            } catch (SQLException e) {
//                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gia tri cua khoa vua nhap khong ton tai !!");
            }
        }
        return false;
    }

    public Boolean checkConnection() {
        try {
            return !conn.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void checkDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Khong tim thay Driver mysql !!!");
        }
    }
    
    public Connection getConnection(){
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
//            System.out.println("Success! Đóng kết nối tới '" + dbName + "' thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "-- ERROR! Không thể đóng kết nối tới " + dbName);
        }
    }
}