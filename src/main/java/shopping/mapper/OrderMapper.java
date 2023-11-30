package shopping.mapper;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import shopping.model.OrderVO;

@Mapper
public interface OrderMapper {
	void insertOrder(OrderVO orderVO);
}
