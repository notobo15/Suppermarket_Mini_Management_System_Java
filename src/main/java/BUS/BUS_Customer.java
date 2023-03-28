
package BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAO_Customer;
import GUI.AlertWarning;
import DTO.DTO_Customer;

public class BUS_Customer {
	DAO_Customer dao_customer = new DAO_Customer();

    public ArrayList<DTO_Customer> getList() throws SQLException {
        return dao_customer.findAll();
    }

    public DTO_Customer getCustomerById(int id) throws SQLException {
        boolean isSuccess = dao_customer.checkExistById(id);
        System.out.println(isSuccess);
         AlertWarning alert = new AlertWarning("Không tìm thấy Customer Id = " + id);
        if (isSuccess) {
            return dao_customer.findById(id);
        } else {
            alert.setVisible(true);
            return null;
        }

    }

    public String addCustomer(DTO_Customer acc) throws SQLException {
    	boolean isExist = dao_customer.checkExistById(acc.getCustomerId());
        if (!isExist) {
            boolean isSuccess = dao_customer.create(acc);
            if (isSuccess) {
            	new AlertWarning("Tạo Customer thành công").setVisible(true);
                return "tao thanh cong";
            } else {
            	new AlertWarning("Tạo Customer không thành công").setVisible(true);
                return "tao khong thanh cong";
            }
        } else {
        	new AlertWarning("Customer Name đã có trong hệ thống!").setVisible(true);
            return "name da duoc tim thay trong db";
        }
    }

    public String updateCustomer(DTO_Customer acc) throws SQLException {
    	boolean isExist = dao_customer.checkExistById(acc.getCustomerId());
        if (isExist) {
            boolean isSuccess = dao_customer.updateById(acc);
            if (isSuccess) {
            	new AlertWarning("Cập nhật Customer id " + acc.getCustomerId() + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("Cập nhật Customer id " + acc.getCustomerId() + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }
        } else {
        	new AlertWarning("id = "+ acc.getCustomerId() + " đã không được tìm thấy").setVisible(true);
            return "khong tim thay";
        }
    }
    
    public String deleteCustomer(int id) throws SQLException {
    	boolean isExist = dao_customer.checkExistById(id);
        if (isExist) {
            boolean isDeleted = dao_customer.deteleById(id);
            if (isDeleted) {
            	new AlertWarning("Đã xóa Customer id " + id + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("Xóa Customer id " + id + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }
        } else {
        	new AlertWarning("id = "+ id + " đã không được tìm thấy").setVisible(true);
            return "khong tim thay";
        }
    }

    
    
    public String unDeleteCustomer(int id) throws SQLException {
    	boolean isExist = dao_customer.checkExistById(id);
        if (isExist) {
            boolean isDeleted = dao_customer.unDeteleById(id);
            if (isDeleted) {
            	new AlertWarning("Đã khôi phục Customer id " + id + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("khôi phục Customer id " + id + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }
        } else {
        	new AlertWarning("id = "+ id + " đã không được tìm thấy").setVisible(true);
            return "khong tim thay";
        }
    }
}
