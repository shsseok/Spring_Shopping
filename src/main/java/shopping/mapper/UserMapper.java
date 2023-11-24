package shopping.mapper;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import shopping.model.UserVO;

@Mapper
public interface UserMapper {
	
	UserVO findUser(int userId);

}
