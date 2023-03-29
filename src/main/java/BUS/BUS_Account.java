package BUS;

import DAO.DAO_Account;
import DTO.DTO_Account;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

public class BUS_Account {

	DAO_Account dao_account = new DAO_Account();

	public ArrayList<DTO_Account> getList() throws SQLException {
		return dao_account.findAll();
	}

	public DTO_Account getSingleById(int id) throws SQLException {
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

	public String add(DTO_Account acc) throws SQLException {
		boolean isExist = dao_account.checkExistByName(acc.getAccountName());
		if (!isExist) {
			boolean isSuccess = dao_account.create(acc);
			if (isSuccess) {
				new AlertWarning("Tạo account thành công").setVisible(true);
				return "tao thanh cong";
			} else {
				new AlertWarning("Tạo account không thành công").setVisible(true);
				return "tao khong thanh cong";
			}
		} else {
			new AlertWarning("Account đã có trong hệ thống!").setVisible(true);
			return "name da duoc tim thay trong db";
		}
	}

	public String update(DTO_Account acc) throws SQLException {
		boolean isExist = dao_account.checkExistById(acc.getAccountId());
		if (isExist) {
			boolean isSuccess = dao_account.updateById(acc);
			if (isSuccess) {
				new AlertWarning("Cập nhật account id " + acc.getAccountId() + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Cập nhật account id " + acc.getAccountId() + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + acc.getAccountId() + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String delete(int id) throws SQLException {
		boolean isExist = dao_account.checkExistById(id);
		if (isExist) {
			boolean isDeleted = dao_account.deteleById(id);
			if (isDeleted) {
				new AlertWarning("Đã xóa account id " + id + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Xóa account id " + id + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + id + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String unDelete(int id) throws SQLException {

		boolean isDeleted = dao_account.unDeteleById(id);
		if (isDeleted) {
			new AlertWarning("Đã khôi phục account id " + id + " thành công!").setVisible(true);
			return "Delete thanh cong";
		} else {
			new AlertWarning("khôi phục account id " + id + "không thành công!").setVisible(true);
			return "Delete khong thanh cong";
		}

	}

}
