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
import DTO.DTO_CategoryProduct;
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
        
         BUS_Product bus_product = new BUS_Product();
//         DTO_Product pro = new DTO_Product(87, 1, "binh11111", "mo ta", "", "1kg", "viet nam", "2022-1-1 00:00:00", 100, 999, true);
//         System.out.println(bus_product.add(pro));
//         System.out.println(bus_product.update(pro));
BUS_CategoryProduct bus_cate = new BUS_CategoryProduct();
        DTO_CategoryProduct cate = new DTO_CategoryProduct(25, "test112221", true);
//        System.out.println(bus_cate.update(cate
System.out.println(bus_cate.unDelete(25));
    }
}
