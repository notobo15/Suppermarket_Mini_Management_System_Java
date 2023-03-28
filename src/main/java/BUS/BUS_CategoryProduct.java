package BUS;

import DTO.DTO_CategoryProduct;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAO_CategoryProduct;

public class BUS_CategoryProduct {

	DAO_CategoryProduct dao = new DAO_CategoryProduct();

	public ArrayList<DTO_CategoryProduct> getList() throws SQLException {
		return dao.findAll();
	}

	public DTO_CategoryProduct getSingleById(int id) throws SQLException {
		boolean isSuccess = dao.checkExistById(id);
		System.out.println(isSuccess);
		AlertWarning alert = new AlertWarning("Không tìm thấy category Id = " + id);
		if (isSuccess) {
			return dao.findById(id);
		} else {
			alert.setVisible(true);
			return null;
		}

	}

	public String add(DTO_CategoryProduct acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getId());
		if (!isExist) {
			boolean isSuccess = dao.create(acc);
			if (isSuccess) {
				new AlertWarning("Tạo category thành công").setVisible(true);
				return "tao thanh cong";
			} else {
				new AlertWarning("Tạo category không thành công").setVisible(true);
				return "tao khong thanh cong";
			}
		} else {
			new AlertWarning("category Name đã có trong hệ thống!").setVisible(true);
			return "name da duoc tim thay trong db";
		}
	}

	public String update(DTO_CategoryProduct acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getId());
		if (isExist) {
			boolean isSuccess = dao.updateById(acc);
			if (isSuccess) {
				new AlertWarning("Cập nhật category id " + acc.getId() + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Cập nhật category id " + acc.getId() + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + acc.getId() + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String delete(int id) throws SQLException {
		boolean isExist = dao.checkExistById(id);
		if (isExist) {
			boolean isDeleted = dao.deteleById(id);
			if (isDeleted) {
				new AlertWarning("Đã xóa category id " + id + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Xóa category id " + id + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + id + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String undelete(int id) throws SQLException {
		boolean isExist = dao.checkExistById(id);
		if (isExist) {
			boolean isDeleted = dao.unDeteleById(id);
			if (isDeleted) {
				new AlertWarning("Đã khôi phục category id " + id + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("khôi phục category id " + id + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + id + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

}
