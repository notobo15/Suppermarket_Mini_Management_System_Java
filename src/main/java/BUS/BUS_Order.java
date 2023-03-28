package BUS;
import DAO.DAO_Order;
import DTO.DTO_Order;
import GUI.AlertMessageYN;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BUS_Order {

	DAO_Order dao = new DAO_Order();

    public ArrayList<DTO_Order> getList() throws SQLException {
        return dao.findAll();
    }

    public DTO_Order getSingleById(int id) throws SQLException {
        boolean isSuccess = dao.checkExistById(id);
        System.out.println(isSuccess);
         AlertWarning alert = new AlertWarning("Không tìm thấy order Id = " + id);
        if (isSuccess) {
            return dao.findById(id);
        } else {
            alert.setVisible(true);
            return null;
        }

    }

    public String add(DTO_Order acc) throws SQLException {
    	boolean isExist = dao.checkExistById(acc.getOrderId());
        if (!isExist) {
            boolean isSuccess = dao.create(acc);
            if (isSuccess) {
            	new AlertWarning("Tạo order thành công").setVisible(true);
                return "tao thanh cong";
            } else {
            	new AlertWarning("Tạo order không thành công").setVisible(true);
                return "tao khong thanh cong";
            }
        } else {
        	new AlertWarning("order Name đã có trong hệ thống!").setVisible(true);
            return "name da duoc tim thay trong db";
        }
    }

    public String update(DTO_Order acc) throws SQLException {
    	boolean isExist = dao.checkExistById(acc.getOrderId());
        if (isExist) {
            boolean isSuccess = dao.updateById(acc);
            if (isSuccess) {
            	new AlertWarning("Cập nhật order id " + acc.getOrderId() + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("Cập nhật order id " + acc.getOrderId() + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }
        } else {
        	new AlertWarning("id = "+ acc.getOrderId() + " đã không được tìm thấy").setVisible(true);
            return "khong tim thay";
        }
    }
    
    public String delete(int id) throws SQLException {
    	boolean isExist = dao.checkExistById(id);
        if (isExist) {
            boolean isDeleted = dao.deteleById(id);
            if (isDeleted) {
            	new AlertWarning("Đã xóa order id " + id + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("Xóa order id " + id + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }
        } else {
        	new AlertWarning("id = "+ id + " đã không được tìm thấy").setVisible(true);
            return "khong tim thay";
        }
    }

    public String undelete(int id) throws SQLException {
    	boolean isExist = dao.checkExistById(id);
        if (isExist) {
            boolean isDeleted = dao.unDeteleById(id);
            if (isDeleted) {
            	new AlertWarning("Đã khôi phục order id " + id + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("khôi phục order id " + id + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }
        } else {
        	new AlertWarning("id = "+ id + " đã không được tìm thấy").setVisible(true);
            return "khong tim thay";
        }
    }
    
    
}
