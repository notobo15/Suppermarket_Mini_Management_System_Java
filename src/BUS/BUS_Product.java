package BUS;

import DAO.DAO_Product;
import DTO.DTO_Product;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

public class BUS_Product {

	DAO_Product dao = new DAO_Product();

	public ArrayList<DTO_Product> getList() throws SQLException {
		return dao.findAll();
	}

	public DTO_Product getSingleById(int id) throws SQLException {
		boolean isSuccess = dao.checkExistById(id);
		System.out.println(isSuccess);
		AlertWarning alert = new AlertWarning("Không tìm thấy product Id = " + id);
		if (isSuccess) {
			return dao.findById(id);
		} else {
			alert.setVisible(true);
			return null;
		}

	}
        
        

	public String add(DTO_Product acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getProductId());
		if (!isExist) {
			boolean isSuccess = dao.create(acc);
			if (isSuccess) {
				new AlertWarning("Tạo product thành công").setVisible(true);
				return "tao thanh cong";
			} else {
				new AlertWarning("Tạo product không thành công").setVisible(true);
				return "tao khong thanh cong";
			}
		} else {
			new AlertWarning("product đã có trong hệ thống!").setVisible(true);
			return "name da duoc tim thay trong db";
		}
	}

	public String update(DTO_Product acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getProductId());
		if (isExist) {
			boolean isSuccess = dao.updateById(acc);
			if (isSuccess) {
				new AlertWarning("Cập nhật product id " + acc.getProductId() + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Cập nhật product id " + acc.getProductId() + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + acc.getProductId() + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String delete(int id) throws SQLException {
		boolean isExist = dao.checkExistById(id);
		if (isExist) {
			boolean isDeleted = dao.deteleById(id);
			if (isDeleted) {
				new AlertWarning("Đã xóa product id " + id + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Xóa product id " + id + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + id + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String unDelete(int id) throws SQLException {
		boolean isDeleted = dao.unDeteleById(id);
		if (isDeleted) {
			new AlertWarning("Đã khôi phục product id " + id + " thành công!").setVisible(true);
			return "Delete thanh cong";
		} else {
			new AlertWarning("khôi phục product id " + id + "không thành công!").setVisible(true);
			return "Delete khong thanh cong";
		}

	}
        
        public boolean themQuantiy(int id, float quantity) throws SQLException {
		boolean isDeleted = dao.themSoLuong(id, quantity);
		if (isDeleted) {
//			new AlertWarning("Đã khôi phục product id " + id + " thành công!").setVisible(true);
			return true;
		} else {
//			new AlertWarning("khôi phục product id " + id + "không thành công!").setVisible(true);
			return false;
		}

	}
        
        public boolean truQuantiy(int id, float quantity) throws SQLException {
		boolean isDeleted = dao.truSoLuong(id, quantity);
		if (isDeleted) {
//			new AlertWarning("Đã khôi phục product id " + id + " thành công!").setVisible(true);
			return true;
		} else {
//			new AlertWarning("khôi phục product id " + id + "không thành công!").setVisible(true);
			return false;
		}

	}

}
