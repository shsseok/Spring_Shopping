package shopping.mapper;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import shopping.model.ItemVO;

@Mapper
public interface ItemMapper {
	void itemSave(ItemVO itemVO);
}
