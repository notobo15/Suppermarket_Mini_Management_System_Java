/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_Discount;
import DTO.DTO_Discount;
import GUI.AlertWarning;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author notobo
 */
public class BUS_Discount {
    DAO_Discount dao_customer = new DAO_Discount();

	public ArrayList<DTO_Discount> getList() throws SQLException {
		return dao_customer.findAll();
	}

	public DTO_Discount getSingleById(int id) throws SQLException {
		boolean isSuccess = dao_customer.checkExistById(id);
		System.out.println(isSuccess);
		AlertWarning alert = new AlertWarning("Không tìm thấy Discount Id = " + id);
		if (isSuccess) {
			return dao_customer.findById(id);
		} else {
			alert.setVisible(true);
			return null;
		}

	}

//	public String addCustomer(DTO_Discount acc) throws SQLException {
//		boolean isExist = dao_customer.checkExistById(acc.getId());
//		if (!isExist) {
//			boolean isSuccess = dao_customer.create(acc);
//			if (isSuccess) {
//				new AlertWarning("Tạo Customer thành công").setVisible(true);
//				return "tao thanh cong";
//			} else {
//				new AlertWarning("Tạo Customer không thành công").setVisible(true);
//				return "tao khong thanh cong";
//			}
//		} else {
//			new AlertWarning("Customer đã có trong hệ thống!").setVisible(true);
//			return "name da duoc tim thay trong db";
//		}
//	}

//	public String update(DTO_Discount acc) throws SQLException {
//		boolean isExist = dao_customer.checkExistById(acc.getCustomerId());
//		if (isExist) {
//			boolean isSuccess = dao_customer.updateById(acc);
//			if (isSuccess) {
//				new AlertWarning("Cập nhật Customer id " + acc.getCustomerId() + " thành công!").setVisible(true);
//				return "Delete thanh cong";
//			} else {
//				new AlertWarning("Cập nhật Customer id " + acc.getCustomerId() + "không thành công!").setVisible(true);
//				return "Delete khong thanh cong";
//			}
//		} else {
//			new AlertWarning("id = " + acc.getCustomerId() + " đã không được tìm thấy").setVisible(true);
//			return "khong tim thay";
//		}
//	}   

	public String delete(int id) throws SQLException {
		boolean isExist = dao_customer.checkExistById(id);
		if (isExist) {
			boolean isDeleted = dao_customer.deteleById(id);
			if (isDeleted) {
				new AlertWarning("Đã xóa Discount id " + id + " thành công!").setVisible(true);
				return "Delete thanh cong";
			} else {
				new AlertWarning("Xóa Discount id " + id + "không thành công!").setVisible(true);
				return "Delete khong thanh cong";
			}
		} else {
			new AlertWarning("id = " + id + " đã không được tìm thấy").setVisible(true);
			return "khong tim thay";
		}
	}

	public String unDelete(int id) throws SQLException {

		boolean isDeleted = dao_customer.unDeteleById(id);
		if (isDeleted) {
			new AlertWarning("Đã khôi phục Discount id " + id + " thành công!").setVisible(true);
			return "Delete thanh cong";
		} else {
			new AlertWarning("khôi phục Discount id " + id + "không thành công!").setVisible(true);
			return "Delete khong thanh cong";
		}

	}
}
