/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package MAIN;

import BUS.BUS_Account;
import BUS.BUS_Customer;
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
public class Main {

    public static void main(String[] args) throws Exception {
        
         try {
             UIManager.setLookAndFeel(new FlatMacLightLaf() );
             new LoginGUI().setVisible(true);

             
        } catch (Exception e) {
        }
    }
}
