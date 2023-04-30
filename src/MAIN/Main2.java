/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package MAIN;

import BUS.BUS_Account;
import BUS.BUS_CategoryProduct;
import BUS.BUS_Customer;
import BUS.BUS_Discount;
import BUS.BUS_Product;
import BUS.BUS_Role;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAO_Account;
import DAO.DAO_Product;
import DTO.DTO_Account;
import DTO.DTO_Product;
import DTO.DTO_Role;
import GUI.AlertMessageYN;
import GUI.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author chris
 */
public class Main2 {

    public static void main(String[] args) throws Exception {
        
         try {
             BUS_Product bus_product = new BUS_Product();
             System.out.println(bus_product.getList());
               BUS_CategoryProduct bus_category = new BUS_CategoryProduct();
             System.out.println(bus_category.getList());
             BUS_Discount bus_discount = new BUS_Discount();
             System.out.println(bus_discount.getList());
             
        } catch (Exception e) {
        }
//         new CustomerGUI().setVisible(true);
//         new LoginGUI().setVisible(true);
//         new CustomerGUI().setVisible(true);
//         new LoginGUI().setVisible(true);
//        BUS_Account bus_account = new BUS_Account();
//        BUS_Product bus_product = new BUS_Product();
//        BUS_Role bus_role = new BUS_Role();
//        System.out.println(bus_role.getList());
//        DTO_Role role = new DTO_Role(0, "bản vệ", true);
//
//        DTO_Role role2 = new DTO_Role(0, "bản vệ", true);
//        bus_role.add(role);
//        bus_role.add(role2);
//        System.out.println(bus_product.getSingleById(1));
//        DTO_Product pro = new DTO_Product();
//        pro.setProductId(1);
//        System.out.println(bus_product.add(pro));
//        System.out.println(bus_account.getList());
//        for(DTO_Product i: bus_product.getList()) {
//        	System.out.println(i.toString());
//        }
        
//        DTO_Account acc = new DTO_Account();
//        BUS_Product bus_product = new BUS_Product();
//        System.out.println(bus_product.);
//        acc.setAccountName("admin1");
//        System.out.println(bus_account.add(acc));
//        System.out.println(bus_account.getList());
//        System.out.println(bus_account.deleteAccount(7));
        
//        System.out.println(bus_account.deleteAccount(8));
//        System.out.println(bus_account.addAccount(acc));
        
//        System.out.println(bus_account.getAccountById(1));
//        new AlertWarning("Không tìm thấy account Id = ").setVisible(true);
//        System.out.println("Hello World!");
//        new Table().setVisible(true);
//        new AlertMessageYN("ban co chan mon xoa").setVisible(true);
            
        

//		DAO_Account dao_acc = new DAO_Account();
//		DAO_Product dao_product = new DAO_Product();
//		BUS_Account bus_account = new BUS_Account();
//                bus_account.getAccountById(1);
//                System.out.println(bus_account.getAccountById(10));
//		ArrayList<DTO_Account> list = dao_acc.findAll();
//		ArrayList<DTO_Product> listPorduct = dao_product.findAll();
//		
//		for (DTO_Account item : list) {
//			System.out.println(item.toString());
//		}
//                new Table().setVisible(true);
        ////////comment text
//		System.out.println("-------------------");
//		String str = dao_acc.findById(1).toString();
//		System.out.println(str);

//		DTO_Account acc1 = new DTO_Account(5, "11111", "Test1", "Chris", "012334234", "HCM", "nu", "1999-11-1");
//		System.out.println(acc1.toString());
//		System.out.println(dao_acc.updateById(8, acc1));
//		System.out.println(dao_acc.create(new DTO_Account(1, 1, "test", "123", "Test", "Nguyễn", "0123455678", "LA", "nam", "2000-1-1", true)));
//        ConnectDB con = new ConnectDB();
//        ResultSet rs = null;
//        PreparedStatement ptm = con.getConnection().prepareStatement("SELECT * FROM account");
//           rs = ptm.executeQuery();
//           while ( rs.next()) {
//               
//               System.out.println(rs.getString("account_name"));
//               System.out.println(rs.getString("password"));
//           }
    }
}
