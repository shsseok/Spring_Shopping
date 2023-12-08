package shopping.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import shopping.model.ItemVO;
import shopping.response.ItemResponse;

@Mapper
public interface ItemMapper {
	void itemSave(ItemVO itemVO);

	ItemResponse getItem(int itemId);

	ItemVO getItemById(int itemId);

	List<ItemResponse> getItemList();

	List<ItemResponse> getItemCategoryList(int categoryId);

	int removeItem(int itemId);

	int updateItem(ItemVO itmeVO);

	int updateItemStockQuantity(ItemVO itemVO);
}
