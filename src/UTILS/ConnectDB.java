package UTILS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectDB {
    Connection conn = null;
//    String server = "localhost:3306";
//    String dbName = "db_sieuthi_mini";
//    String userName = "root";
//    String pass = "";
    String server = "103.101.163.106"; 
    String dbName = "notobo_sieuthiminijava"; 
    String userName = "notobo_root"; 
    String pass = "1234";

    public ConnectDB() {
        checkDriver();
        setupConnection();			
    }
    public Connection setupConnection() {
        try {
            String url = "jdbc:mysql://" + server + "/" + dbName+ "?useUnicode=yes&characterEncoding=UTF-8";
//            System.out.println(url  );
            conn = DriverManager.getConnection(url, userName, pass);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Khong the ket noi toi " + dbName);
            return null;
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