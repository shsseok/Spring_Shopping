package shopping.model;

import java.time.LocalDateTime;

public class ItemVO {
	private int itemId;
	private int userId;
	private int categoryId;
	private int stockQuantity;
	private String itemDescription;
	private int itemPrice;
	private String itemName;
	private LocalDateTime uploadedDate;

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
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public LocalDateTime getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(LocalDateTime uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	
	/*
	 * 상품 재고에 대한 비즈니스 로직
	 */
	public void removeStock(int stockCount)
	{
		this.stockQuantity-=stockCount;
		if(stockQuantity<0) //재고가 한개 이하로 떨어지게 되면 예외 발생
		{
			throw new IllegalStateException("너무 많이 주문 했습니다");
		}
		
	}
	public void addStock(int stockCount)
	{
		int currentStock=this.stockQuantity;//현재 재고
		this.stockQuantity+=stockCount;
		//TODO  아이템 그 총 수량보다 그 이상 올라갈 수는 없도록
	}
	
}
