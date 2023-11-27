package shopping.model;

import java.time.LocalDateTime;

public class ItemVO {
	private int itemId;
	private int userId;
	private int categoryId;
	private int stock_quantity;
	private int item_description;
	private int item_price;
	private String item_name;
	private LocalDateTime item_date;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public int getItem_description() {
		return item_description;
	}
	public void setItem_description(int item_description) {
		this.item_description = item_description;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public LocalDateTime getItem_date() {
		return item_date;
	}
	public void setItem_date(LocalDateTime item_date) {
		this.item_date = item_date;
	}
	
	
}
