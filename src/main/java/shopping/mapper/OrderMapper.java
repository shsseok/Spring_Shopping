package shopping.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import shopping.model.OrderVO;

@Mapper
public interface OrderMapper {
	void insertOrder(OrderVO orderVO);
	void deleteOrder(int orderId);
	List<OrderVO> selectOrderList(int userId);
	OrderVO selectOrder(int orderId);
	void updateOrderStatus(int orderId);
}
