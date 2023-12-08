package shopping.mapper;


import egovframework.rte.psl.dataaccess.mapper.Mapper;
import shopping.model.UserVO;

@Mapper
public interface UserMapper {
	
	void insertUser(UserVO userVO);
	UserVO selectUser(int userId);
	UserVO selectUserByEmail(String email);

}
