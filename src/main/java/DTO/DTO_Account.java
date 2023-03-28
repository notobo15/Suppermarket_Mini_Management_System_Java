package DTO;

import java.sql.Date;

/**
 *
 * @author notobo
 */
public class DTO_Account {

    private int accountId ;
    private String accountName, passsword, firstName, lastName, phone, address, gender;
    private String birthDate;
    private Boolean status;
    private int roleId;
    
	public DTO_Account() {
		super();
	}

	public DTO_Account(int accountId, int roleId, String accountName, String passsword, String firstName,
			String lastName, String phone, String address, String gender, String birthDate, Boolean status) {
		super();
		this.accountId = accountId;
		this.roleId = roleId;
		this.accountName = accountName;
		this.passsword = passsword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
		this.status = status;
	}
	
	public DTO_Account(int roleId, String passsword, String firstName, String lastName, String phone, String address,
			String gender, String birthDate) {
		super();
		this.roleId = roleId;
		this.passsword = passsword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "DTO_Account [accountId=" + accountId + ", roleId=" + roleId + ", accountName=" + accountName
				+ ", passsword=" + passsword + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", address=" + address + ", gender=" + gender + ", birthDate=" + birthDate + ", status="
				+ status + "]";
	}
    
   
    
    
	
    
    
}
