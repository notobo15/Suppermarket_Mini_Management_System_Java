package BUS;

import DAO.DAO_OrderDetail;
import DTO.DTO_OrderDetail;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

public class BUS_OrderDetail {

	DAO_OrderDetail dao = new DAO_OrderDetail();

	public ArrayList<DTO.DTO_OrderDetail> getList() throws SQLException {
		return dao.findAll();
	}

	public DTO_OrderDetail getSingleById(int id) throws SQLException {
		boolean isSuccess = dao.checkExistById(id);
		System.out.println(isSuccess);
		AlertWarning alert = new AlertWarning("Không tìm thấy chi tiết order Id = " + id);
		if (isSuccess) {
			return dao.findById(id);
		} else {
			alert.setVisible(true);
			return null;
		}

	}

	public String add(DTO_OrderDetail acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getId());
		if (!isExist) {
			boolean isSuccess = dao.create(acc);
			if (isSuccess) {
				new AlertWarning("Tạo chi tiết order thành công").setVisible(true);
				return "tao thanh cong";
			} else {
				new AlertWarning("Tạo chi tiết order không thành công").setVisible(true);
				return "tao khong thanh cong";
			}
		} else {
			new AlertWarning("chi tiết order đã có trong hệ thống!").setVisible(true);
			return "name da duoc tim thay trong db";
		}
	}

	public String update(DTO_OrderDetail acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getId());
		if (isExist) {
			boolean isSuccess = dao.updateById(acc);
			if (isSuccess) {
				new AlertWarning("Cập nhật chi tiết order id " + acc.getId() + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Cập nhật chi tiết order id " + acc.getId() + "không thành công!").setVisible(true);
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
				new AlertWarning("Đã xóa chi tiết order id " + id + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Xóa chi tiết order id " + id + "không thành công!").setVisible(true);
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
			new AlertWarning("Đã khôi phục chi tiết order id " + id + " thành công!").setVisible(true);
			return "Delete thanh cong";
		} else {
			new AlertWarning("khôi phục chi tiết order id " + id + "không thành công!").setVisible(true);
			return "Delete khong thanh cong";
		}

	}

}
