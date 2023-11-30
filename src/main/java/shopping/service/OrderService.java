package shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.OrderMapper;
import shopping.model.OrderVO;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	public boolean saveOrder(OrderVO orderVO)
	{
		orderMapper.insertOrder(orderVO);
	}
}
