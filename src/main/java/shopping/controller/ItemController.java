package shopping.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import shopping.model.ItemVO;
import shopping.service.ItemImageService;
import shopping.service.ItemService;


@Controller
@RequestMapping(path="/item")
public class ItemController {
	
	@Autowired 
	private ItemService itemService;
	@Autowired
	private ItemImageService itemImageService;
	
	@PostMapping(value="/addItem",produces="applicaion/json",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseEntity<String> addItem(@RequestPart("itemVO") ItemVO itemVO,
										  @RequestPart("itemImages") List<MultipartFile> ItemImageFileList) throws IllegalStateException, IOException
	{
			int itemId=itemService.itemAdd(itemVO);
			itemImageService.itemImageAdd(ItemImageFileList,itemId);
		 	String responseMessage = "{\"message\": \"상품 등록에 성공했습니다.\"}";
		    return ResponseEntity.ok(responseMessage);
	}
}
