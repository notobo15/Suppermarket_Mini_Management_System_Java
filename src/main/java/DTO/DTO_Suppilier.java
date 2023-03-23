package DTO;

public class DTO_Suppilier {
	private int suppilierId;
	
	private String name, phone, address;
	private boolean status;
	public DTO_Suppilier(int suppilierId, String name, String phone, String address, boolean status) {
		super();
		this.suppilierId = suppilierId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.status = status;
	}
	public int getSuppilierId() {
		return suppilierId;
	}
	public void setSuppilierId(int suppilierId) {
		this.suppilierId = suppilierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
