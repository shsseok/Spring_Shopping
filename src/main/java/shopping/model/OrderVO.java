package shopping.model;

public class OrderVO {
	private int orderId;
	private int userId;
	private int orderTotalPrice;
	private OrderStatus orderStatus;
	private int orderItemCount;
	private int itemId;
	private String zipcode;
	private String city;
	private String detailedAddress;

	public int getItemId() {
		return itemId;
	}

	public OrderVO(int userId, int orderTotalPrice, OrderStatus orderStatus, int orderItemCount, int itemId,
			String zipcode, String city, String detailedAddress) {
		super();
		this.userId = userId;
		this.orderTotalPrice = orderTotalPrice;
		this.orderStatus = orderStatus;
		this.orderItemCount = orderItemCount;
		this.itemId = itemId;
		this.zipcode = zipcode;
		this.city = city;
		this.detailedAddress = detailedAddress;
	}
	public int getOrderId() {
		return orderId;
	}

	public int getUserId() {
		return userId;
	}

	public int getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public int getOrderItemCount() {
		return orderItemCount;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void changeOrderStatus(OrderStatus orderStatus)
	{
		this.orderStatus=orderStatus;
	}

}
