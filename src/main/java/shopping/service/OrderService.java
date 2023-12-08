package shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopping.mapper.ItemMapper;
import shopping.mapper.OrderMapper;
import shopping.model.ItemVO;
import shopping.model.OrderStatus;
import shopping.model.OrderVO;
import shopping.request.OrderItemRequest;

@Service

public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 상품을 바로 주문할 때 장바구니에 담지 않음 
	 * @param orderVO
	 * @return
	 */
	@Transactional 
	public void addOrder(OrderItemRequest orderItemRequest)
	{
		ItemVO item = itemMapper.getItemById(orderItemRequest.getOrderItemId()); 	
		validateOrder(item);
		item.removeStock(orderItemRequest.getOrderItemCount()); //상품의 주문 수만큼 재고를 내림
		itemMapper.updateItemStockQuantity(item); //상품 재고 수량 업데이트
		OrderVO orderVO=new OrderVO(1,
				orderItemRequest.getOrderItemCount()*item.getItemPrice(),
				OrderStatus.COMPLETE,
				orderItemRequest.getOrderItemCount(),
				orderItemRequest.getOrderItemId(),
				orderItemRequest.getZipcode(),
				orderItemRequest.getCity(),
				orderItemRequest.getDetailedAddress());
		orderMapper.insertOrder(orderVO);	
	}
	/**
	 * 주문 취소 비즈니스 로직
	 * @param orderId
	 */
	@Transactional
	public void cancelOrder(int orderId)
	{
		OrderVO orderVO=orderMapper.selectOrder(orderId);
		//일단 배송 상태를 다시 바꿔준다(취소로)
		orderVO.changeOrderStatus(OrderStatus.CANCEL);
		orderMapper.updateOrderStatus(orderId);
		//주문한 상품을 다시 가져오고
		ItemVO itemVO=itemMapper.getItemById(orderVO.getItemId());
		//그 상품에 대한 재고를 다시 늘려준다 왜? 주문을 최소했기 때문에
		itemVO.addStock(orderVO.getOrderItemCount());
		itemMapper.updateItemStockQuantity(itemVO);
	}
	/**
	 * 주문 단건 조회
	 * @param orderId
	 * @return
	 */
	public OrderVO findOrder(int orderId)
	{
		return orderMapper.selectOrder(orderId);
	}
	/**
	 * 주문 전체 조회(주문은 사용자id값을 받은 사용자가 주문한 모든 상품)
	 * @param userId
	 * @return
	 */
	public List<OrderVO> findOrderList(int userId)
	{
		return orderMapper.selectOrderList(userId);
	}
	
	/**
	 * 주문을 했을 때 주문 상품에 대한 검증 로직
	 * @param itemVO
	 */
	public void validateOrder(ItemVO itemVO)
	{
		if(itemVO.getStockQuantity()<1)
		{
			throw new IllegalStateException("상품 재고 수량이 부족합니다.");
		}
	}
}
