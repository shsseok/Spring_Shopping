/*package shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import shopping.model.UserVO;
import shopping.security.model.UserRoleVO;
@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserVO getUser(String loginUserId) {
		 return new UserVO("carami", "$2a$10$G/ADAGLU3vKBd62E6GbrgetQpEKu2ukKgiDR5TWHYwrem0cSv6Z8m");
	}

	@Override
	public List<UserRoleVO> getUserRoles(String loginUserId) {
		List<UserRoleVO> list = new ArrayList<>();
        list.add(new UserRoleVO("carami", "ROLE_USER"));
        return list;
	}

}*/
