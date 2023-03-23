package DTO;

public class DTO_Role {
	private int role_id;
	private String name;
	public DTO_Role(int role_id, String name) {
		super();
		this.role_id = role_id;
		this.name = name;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DTO_Role [role_id=" + role_id + ", name=" + name + "]";
	}
	
}
