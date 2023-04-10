package DTO;

public class DTO_Order {
	private int orderId, accountId;
	private String orderDate;
	private int customerId;
	private boolean status;
	
	public DTO_Order() {
		super();
	}
	public DTO_Order(int orderId, int accountId, String orderDate, int customerId, boolean status) {
		super();
		this.orderId = orderId;
		this.accountId = accountId;
		this.orderDate = orderDate;
		this.status = status;
		this.customerId = customerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "DTO_Order [orderId=" + orderId + ", accountId=" + accountId + ", orderDate=" + orderDate + ", status="
				+ status + ", customerId=" + customerId + "]";
	}

    public Object getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
	
}
