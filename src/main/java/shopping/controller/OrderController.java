package shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shopping.model.OrderVO;
import shopping.request.OrderItemRequest;
import shopping.service.OrderService;


/**
 * API 주문 상세 주문 취소 주문
 * 
 * @author 심현석
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping(produces = "application/json; charset=utf8")//주문할 상품을 파라미터로 받고 
	public ResponseEntity<String> orderAdd(@RequestBody OrderItemRequest orderItemRequest) 
	{
		orderService.addOrder(orderItemRequest);
		String responseMessage = "{\"message\": \"주문에 성공했습니다.\"}";
		return ResponseEntity.ok(responseMessage);
	}
	
	@GetMapping(path="{orderId}") 
	public ResponseEntity<String> orderFind(@RequestParam int orderId) 
	{
		OrderVO orderVO=orderService.findOrder(orderId);
		String responseMessage = "{\"message\": \"주문 단건 조회에 성공하였습니다.\"}";
		return ResponseEntity.ok(responseMessage);
	}
	
	@GetMapping(path="{userId}")
	public ResponseEntity<String> orderFindList(@RequestParam int userId) 
	{
		orderService.findOrderList(userId);
		String responseMessage = "{\"message\": \"주문 전체 조회에 성공하였습니다.\"}";
		return ResponseEntity.ok(responseMessage);
	}
}
