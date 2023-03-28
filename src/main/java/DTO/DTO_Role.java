package DTO;

public class DTO_Role {
	private int roleId;
	private String name;
	private boolean status;
	public DTO_Role() {
		super();
	}
	public DTO_Role(int roleId, String name, boolean status) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.status = status;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "DTO_Role [role_id=" + roleId + ", name=" + name + ", status=" + status + "]";
	}
	
}
