package shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.ItemMapper;
import shopping.model.ItemVO;

@Service
public class ItemService {
	@Autowired
	private ItemMapper itemMapper;
	
	
	public int itemAdd(ItemVO itemVO)
	{
		itemMapper.itemSave(itemVO);
		int generatedKey=itemVO.getItemId();
		return generatedKey;
				
	}
}
