package shopping.response;

import shopping.model.AddressVO;
import shopping.model.OrderVO;

public class OrderResponse {
	private OrderVO orderVO;
	private AddressVO addressVO;
	public OrderVO getOrderVO() {
		return orderVO;
	}
	public void setOrderVO(OrderVO orderVO) {
		this.orderVO = orderVO;
	}

	
}
