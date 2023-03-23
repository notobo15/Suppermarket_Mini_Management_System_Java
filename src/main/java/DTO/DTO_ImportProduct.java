package DTO;

public class DTO_ImportProduct {
	private int id, suppilierId, accountId;
	private String importDate;
	private boolean status;
	
	public DTO_ImportProduct(int id, int suppilierId, int accountId, String importDate, boolean status) {
		super();
		this.id = id;
		this.suppilierId = suppilierId;
		this.accountId = accountId;
		this.importDate = importDate;
		this.setStatus(status);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSuppilierId() {
		return suppilierId;
	}
	public void setSuppilierId(int suppilierId) {
		this.suppilierId = suppilierId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getImportDate() {
		return importDate;
	}
	public void setImportDate(String importDate) {
		this.importDate = importDate;
	}
	@Override
	public String toString() {
		return "DTO_Import_Product [id=" + id + ", suppilierId=" + suppilierId + ", accountId=" + accountId
				+ ", importDate=" + importDate + "]";
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
