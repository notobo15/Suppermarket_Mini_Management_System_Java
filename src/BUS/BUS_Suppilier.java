package BUS;

import DAO.DAO_Suppilier;
import DTO.DTO_Suppilier;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

public class BUS_Suppilier {

	private DAO_Suppilier dao = new DAO_Suppilier();

	public ArrayList<DTO.DTO_Suppilier> getList() throws SQLException {
		return dao.findAll();
	}

	public DTO_Suppilier getSingleById(int id) throws SQLException {
		boolean isSuccess = dao.checkExistById(id);
		System.out.println(isSuccess);
		AlertWarning alert = new AlertWarning("Không tìm thấy suppilier Id = " + id);
		if (isSuccess) {
			return dao.findById(id);
		} else {
			alert.setVisible(true);
			return null;
		}

	}

	public String add(DTO_Suppilier acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getSuppilierId());
		if (!isExist) {
			boolean isSuccess = dao.create(acc);
			if (isSuccess) {
				new AlertWarning("Tạo suppilier thành công").setVisible(true);
				return "tao thanh cong";
			} else {
				new AlertWarning("Tạo suppilier không thành công").setVisible(true);
				return "tao khong thanh cong";
			}
		} else {
			new AlertWarning("suppilier đã có trong hệ thống!").setVisible(true);
			return "name da duoc tim thay trong db";
		}
	}

	public String update(DTO_Suppilier acc) throws SQLException {
		boolean isExist = dao.checkExistById(acc.getSuppilierId());
		if (isExist) {
			boolean isSuccess = dao.updateById(acc);
			if (isSuccess) {
				new AlertWarning("Cập nhật suppilier id " + acc.getSuppilierId() + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Cập nhật suppilier id " + acc.getSuppilierId() + "không thành công!")
						.setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + acc.getSuppilierId() + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String delete(int id) throws SQLException {
		boolean isExist = dao.checkExistById(id);
		if (isExist) {
			boolean isDeleted = dao.deteleById(id);
			if (isDeleted) {
				new AlertWarning("Đã xóa suppilier id " + id + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Xóa suppilier id " + id + "không thành công!").setVisible(true);
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
			new AlertWarning("Đã khôi phục suppilier id " + id + " thành công!").setVisible(true);
			return "Delete thanh cong";
		} else {
			new AlertWarning("khôi phục suppilier id " + id + "không thành công!").setVisible(true);
			return "Delete khong thanh cong";
		}

	}

}
