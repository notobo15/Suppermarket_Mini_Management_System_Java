package DTO;

import java.sql.Date;

public class DTO_Product {
	private int productId, categoryId;
	private String name, description, img, mass, makeIn;
	private String expireDate;
	private float quantity, price;
	private boolean status;
	
	public DTO_Product() {
		super();
	}

	public DTO_Product(int productId, int categoryId, String name, String description, String img, String mass,
			String makeIn, String expireDate, float quantity, float price, boolean status) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.img = img;
		this.mass = mass;
		this.makeIn = makeIn;
		this.expireDate = expireDate;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getMakeIn() {
		return makeIn;
	}

	public void setMakeIn(String makeIn) {
		this.makeIn = makeIn;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DTO_Product [productId=" + productId + ", categoryId=" + categoryId + ", name=" + name
				+ ", description=" + description + ", img=" + img + ", mass=" + mass + ", makeIn=" + makeIn
				+ ", expireDate=" + expireDate + ", quantity=" + quantity + ", price=" + price + ", status=" + status
				+ "]";
	}
	
	
	
}
