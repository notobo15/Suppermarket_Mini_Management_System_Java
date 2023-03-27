package BUS;

import DAO.DAO_Account;
import DTO.DTO_Account;
import GUI.AlertMessageYN;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BUS_Account {

    DAO_Account dao_account = new DAO_Account();

    public ArrayList<DTO.DTO_Account> getList() throws SQLException {
        return dao_account.findAll();
    }

    public DTO_Account getAccountById(int id) throws SQLException {
        boolean isSuccess = dao_account.checkExistById(id);
        System.out.println(isSuccess);
         AlertWarning alert = new AlertWarning("Không tìm thấy account Id = " + id);
        if (isSuccess) {
            return dao_account.findById(id);
        } else {
            alert.setVisible(true);
            return null;
        }

    }

    public String addAccount(DTO_Account acc) throws SQLException {
        if (dao_account.checkExistByName(acc.getAccountName())) {
            boolean isSuccess = dao_account.create(acc);
            if (isSuccess) {

                return "tao thanh cong";
            } else {
                return "tao khong thanh cong";
            }
        } else {
            return "khong tim thay";
        }
    }

    public String deleteAccount(int id) throws SQLException {
        if (dao_account.checkExistById(id)) {
            boolean isDeleted = dao_account.deteleById(id);
            if (isDeleted) {
                return "Delete thanh cong";
            } else {
                return "Delete khong thanh cong";
            }
        } else {
            return "khong tim thay";
        }
    }

}
