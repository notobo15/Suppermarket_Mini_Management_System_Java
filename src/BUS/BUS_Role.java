package BUS;

import DTO.DTO_Role;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAO_Role;

public class BUS_Role {

	DAO_Role dao = new DAO_Role();

	public ArrayList<DTO_Role> getList() throws SQLException {
		return dao.findAll();
	}

	public DTO_Role getSingleById(int id) throws SQLException {
		boolean isSuccess = dao.checkExistById(id);
		System.out.println(isSuccess);
		AlertWarning alert = new AlertWarning("Không tìm thấy role Id = " + id);
		if (isSuccess) {
			return dao.findById(id);
		} else {
			alert.setVisible(true);
			return null;
		}

	}

	public String add(DTO_Role acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getRoleId());
		if (!isExist) {
			boolean isSuccess = dao.create(acc);
			if (isSuccess) {
				new AlertWarning("Tạo role thành công").setVisible(true);
				return "tao thanh cong";
			} else {
				new AlertWarning("Tạo role không thành công").setVisible(true);
				return "tao khong thanh cong";
			}
		} else {
			new AlertWarning("role đã có trong hệ thống!").setVisible(true);
			return "name da duoc tim thay trong db";
		}
	}

	public String update(DTO_Role acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getRoleId());
		if (isExist) {
			boolean isSuccess = dao.updateById(acc);
			if (isSuccess) {
				new AlertWarning("Cập nhật role id " + acc.getRoleId() + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Cập nhật role id " + acc.getRoleId() + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + acc.getRoleId() + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String delete(int id) throws SQLException {
		boolean isExist = dao.checkExistById(id);
		if (isExist) {
			boolean isDeleted = dao.deteleById(id);
			if (isDeleted) {
				new AlertWarning("Đã xóa role id " + id + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Xóa role id " + id + "không thành công!").setVisible(true);
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
			new AlertWarning("Đã khôi phục role id " + id + " thành công!").setVisible(true);
			return "Delete thanh cong";
		} else {
			new AlertWarning("khôi phục role id " + id + "không thành công!").setVisible(true);
			return "Delete khong thanh cong";
		}

	}

}
