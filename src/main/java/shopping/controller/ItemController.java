package shopping.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import shopping.model.ItemVO;
import shopping.response.ItemResponse;
import shopping.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping(path = "/additem", produces = "application/json; charset=utf8")
	public ResponseEntity<String> addItem(@RequestParam int userId, @RequestParam int categoryId,
			@RequestParam String itemDescription, @RequestParam int stockQuantity, @RequestParam int itemPrice,
			@RequestParam String itemName, @RequestParam(required = false) List<MultipartFile> itemImages)
			throws IllegalStateException, IOException {
		ItemVO itemVO = new ItemVO();
		itemVO.setUserId(userId);
		itemVO.setCategoryId(categoryId);
		itemVO.setItemDescription(itemDescription);
		itemVO.setStockQuantity(stockQuantity);
		itemVO.setItemPrice(itemPrice);
		itemVO.setItemName(itemName);
		itemService.itemAndImagesAdd(itemVO, itemImages);
		String responseMessage = "{\"message\": \"상품 등록에 성공했습니다.\"}";
		return ResponseEntity.ok(responseMessage);
	}

	// 상품 상제 정보 단건 조회
	@GetMapping(path = "/{itemId}", produces = "application/json; charset=utf8")
	public ResponseEntity<?> findItem(@PathVariable("itemId") int itemId) {
		ItemResponse itemResponse = itemService.findItem(itemId);
		Map<String, Object> response = new HashMap<>();
		if (itemResponse != null) {
			response.put("message", "해당 상품 조회.");
			response.put("item", itemResponse);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		response.put("message", "해당 상품을 찾을 수 없습니다.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@GetMapping(path = "items/{categoryid}", produces = "application/json; charset=utf8")
	public ResponseEntity<?> itemCategoryList(@PathVariable("categoryid") int categoryId) {
		List<ItemResponse> itemsResponse = itemService.findCategoryItem(categoryId);
		Map<String, Object> response = new HashMap<>();
		if (itemsResponse != null) {
			response.put("message", "해당 카테고리 상품 조회.");
			response.put("items", itemsResponse);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		response.put("message", "해당 카테고리 상품을 찾을 수 없습니다.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@GetMapping(path = "/itemlist", produces = "application/json; charset=utf8")
	public ResponseEntity<?> findItemlist() {
		List<ItemResponse> itemResponse = itemService.findItemList();
		Map<String, Object> response = new HashMap<>();
		if (itemResponse != null) {
			response.put("message", "해당 상품 전체 조회.");
			response.put("items", itemResponse);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		response.put("message", "전체 조회에 실패하였습니다.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@DeleteMapping(path = "/delete/{itemid}")
	public ResponseEntity<?> deleteItem(@PathVariable("itemid") int itemId) {
		Map<String, Object> response = new HashMap<>();
		boolean isDeleted = itemService.deleteItem(itemId);
		if (isDeleted) {
			response.put("message", "상품 삭제 완료");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		response.put("message", "상품 삭제에 실패하였습니다.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

	}

	@PatchMapping(path = "/update")
	public ResponseEntity<?> updateItem(@RequestBody ItemVO itemVO) {
		System.out.println(itemVO.getItemId());
		Map<String, Object> response = new HashMap<>();
		boolean isUpdated = itemService.updateItem(itemVO);
		if (isUpdated) {
			response.put("message", "상품 수정 완료");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		response.put("message", "상품 수정에 실패하였습니다.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

}
