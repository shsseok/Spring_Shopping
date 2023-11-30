package shopping.service;

import java.io.IOException;
import java.util.List;

import org.antlr.grammar.v3.ANTLRParser.action_return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import shopping.mapper.ItemMapper;
import shopping.model.ItemVO;
import shopping.response.ItemResponse;

@Service
public class ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemImageService itemImageService;

	/**
	 * 상품 하나를 저장하기 위한 로직
	 * 
	 * @param itemVO
	 * @return 아이템 저장 후 해당 아이템에 대한 키 값을 바로 반환
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@Transactional
	public void itemAndImagesAdd(ItemVO itemVO, List<MultipartFile> imageList)
			throws IllegalStateException, IOException {

		itemMapper.itemSave(itemVO);
		int generatedItemKey = itemVO.getItemId();
		itemImageService.itemImageAdd(imageList, generatedItemKey);
	}

	/**
	 * 상품 하나를 조회하는 로직
	 * 
	 * @param itemId
	 * @return 아이템 저장 후 해당 아이템에 대한 키 값을 바로 반환
	 */

	public ItemResponse findItem(int itemId) {
		ItemResponse itemResponse = itemMapper.getItem(itemId);
		itemResponse.getImages().stream().forEach(action -> System.out.println(action.getImagePath()));
		return itemMapper.getItem(itemId);

	}

	/**
	 * 상품 전체를 조회하는 로직
	 * 
	 * @return 전체 상품과 하나의 상품에 대한 상품 이미지 리스트
	 */
	public List<ItemResponse> findItemList() {
		return itemMapper.getItemList();
	}
	/**
	 * 카테고리 별 상풍 조회 로직
	 * @return 카테고리별 상품에 대한 리스트
	 */
	public List<ItemResponse> findCategoryItem(int categoryId) {
		return itemMapper.getItemCategoryList(categoryId);
	}

	/**
	 * 상품을 삭제 하는 로직
	 * 
	 * @param itemId
	 * @return 삭제 성공 true 삭제 실패 false
	 */
	public boolean deleteItem(int itemId) {
		return itemMapper.removeItem(itemId) == 1 ? true : false;

	}

	public boolean updateItem(ItemVO itemVO) {
		return itemMapper.updateItem(itemVO) >= 1 ? true : false;
	}

}
