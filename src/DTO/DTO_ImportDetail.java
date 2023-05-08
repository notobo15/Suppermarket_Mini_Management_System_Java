    package DTO;

public class DTO_ImportDetail {
	private int id, productId;
	private float price, quanity;
	private int importId;
	private boolean status;
	
	public DTO_ImportDetail() {
		super();
	}
        public DTO_ImportDetail(int importId, int productId, float price, float quanity) {
		super();
		this.productId = productId;
		this.price = price;
		this.quanity = quanity;
		this.importId = importId;
	}
	public DTO_ImportDetail(int id, int productId, float price, float quanity, int importId, boolean status) {
		super();
		this.id = id;
		this.productId = productId;
		this.price = price;
		this.quanity = quanity;
		this.importId = importId;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getImportId() {
		return importId;
	}
	public void setImportId(int importId) {
		this.importId = importId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}