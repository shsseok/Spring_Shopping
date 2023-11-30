package shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shopping.model.OrderVO;
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
	
	@PostMapping(produces = "application/json; charset=utf8")
	public ResponseEntity<String> addOrder(@RequestBody OrderVO orderVO) 
	{
		orderService.
		String responseMessage = "{\"message\": \"주문에 성공했습니다.\"}";
		return ResponseEntity.ok(responseMessage);
	}
}
