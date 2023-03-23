package DTO;

public class DTO_CategoryProduct {
	private int id;
	private boolean status;
	private String name, desc;
	public DTO_CategoryProduct(int id, String name, String desc, boolean status) {
		super();
		this.id = id;
		this.status = status;
		this.name = name;
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
