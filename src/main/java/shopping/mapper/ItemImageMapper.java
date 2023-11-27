package shopping.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import shopping.model.ImageVO;

@Mapper
public interface ItemImageMapper {
	void itemImageSave(List<ImageVO> imageVO);
}
