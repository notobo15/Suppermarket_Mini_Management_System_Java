package BUS;

import DTO.DTO_ImportProduct;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAO_ImportProduct;

public class BUS_ImportProduct {

    DAO_ImportProduct dao = new DAO_ImportProduct();

    public <dao> ArrayList<DTO_ImportProduct> getList() throws SQLException {
        return dao.findAll();
    }

    public DTO_ImportProduct getSingleById(int id) throws SQLException {
        boolean isSuccess = dao.checkExistById(id);
        System.out.println(isSuccess);
         AlertWarning alert = new AlertWarning("Không tìm thấy import Id = " + id);
        if (isSuccess) {
            return dao.findById(id);
        } else {
            alert.setVisible(true);
            return null;
        }

    }

    public String add(DTO_ImportProduct acc) throws SQLException {
    	boolean isExist = dao.checkExistById(acc.getId());
        if (!isExist) {
            boolean isSuccess = dao.create(acc);
            if (isSuccess) {
            	new AlertWarning("Tạo import thành công").setVisible(true);
                return "tao thanh cong";
            } else {
            	new AlertWarning("Tạo import không thành công").setVisible(true);
                return "tao khong thanh cong";
            }
        } else {
        	new AlertWarning("import đã có trong hệ thống!").setVisible(true);
            return "name da duoc tim thay trong db";
        }
    }

    public String update(DTO_ImportProduct acc) throws SQLException {
    	boolean isExist = dao.checkExistById(acc.getId());
        if (isExist) {
            boolean isSuccess = dao.updateById(acc);
            if (isSuccess) {
            	new AlertWarning("Cập nhật import id " + acc.getId() + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("Cập nhật import id " + acc.getId() + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }
        } else {
        	new AlertWarning("id = "+ acc.getId() + " đã không được tìm thấy").setVisible(true);
            return "khong tim thay";
        }
    }
    
    public String delete(int id) throws SQLException {
    	boolean isExist = dao.checkExistById(id);
        if (isExist) {
            boolean isDeleted = dao.deteleById(id);
            if (isDeleted) {
            	new AlertWarning("Đã xóa import id " + id + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("Xóa import id " + id + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }
        } else {
        	new AlertWarning("id = "+ id + " đã không được tìm thấy").setVisible(true);
            return "khong tim thay";
        }
    }

    public String unDelete(int id) throws SQLException {
            boolean isDeleted = dao.unDeteleById(id);
            if (isDeleted) {
            	new AlertWarning("Đã khôi phục import id " + id + " thành công!").setVisible(true);
                return "Delete thanh cong";
            } else {
            	new AlertWarning("khôi phục import id " + id + "không thành công!").setVisible(true);
                return "Delete khong thanh cong";
            }

    }
    
    
}
