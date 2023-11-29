package shopping.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import shopping.model.ItemVO;
import shopping.response.ItemResponse;

@Mapper
public interface ItemMapper {
	void itemSave(ItemVO itemVO);
	ItemResponse getItem(int itemId);
	List<ItemResponse> getItemList();
}
