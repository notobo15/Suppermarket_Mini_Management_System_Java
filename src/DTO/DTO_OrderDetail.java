package DTO;

/**
 * @author notobo
 *
 */
/**
 * @author notobo
 *
 */
public class DTO_OrderDetail {	
	private int id, product_id;
	private float price, quanity;
	private int order_id;
	private boolean status;
	public DTO_OrderDetail(int id, int product_id, float price, float quanity, int order_id,  boolean status) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.price = price;
		this.quanity = quanity;
		this.order_id = order_id;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getQuanity() {
		return quanity;
	}
	public void setQuanity(float quanity) {
		this.quanity = quanity;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "DTO_OrderDetail [id=" + id + ", product_id=" + product_id + ", price=" + price + ", quanity=" + quanity
				+ ", order_id=" + order_id + ", status=" + status + "]";
	}
	
}
