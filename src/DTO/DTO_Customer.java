package DTO;


public class DTO_Customer {
	private int customerId;
	private String name, phone, address, gender;
	private String birthDate;
	private boolean status;

	public DTO_Customer() {
		super();
	}
	public DTO_Customer(int customerId,  String name, String phone, String address, String gender,
			String birth_date, boolean status) {
		super();
		this.customerId = customerId;
		this.status = status;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.birthDate = birth_date;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "DTO_Customer [customer_id=" + customerId + ", status=" + status + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + ", gender=" + gender + ", birth_date=" + birthDate + "]";
	}
	
}
