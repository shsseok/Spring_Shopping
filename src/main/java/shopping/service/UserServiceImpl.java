package shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.UserMapper;
import shopping.model.UserVO;
import shopping.request.UserRegisterRequest;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void addUser(UserRegisterRequest userRegisterRequest) {
		userEmailVaildate(userRegisterRequest.getUserEmail());
		UserVO userVO = new UserVO(userRegisterRequest.getUserEmail(), userRegisterRequest.getUserPassword(),
				userRegisterRequest.getUserName());
		userMapper.insertUser(userVO);
	}

	@Override
	public UserVO findUser(int userId) {
		UserVO userVO=userMapper.selectUser(userId);
		return userVO;
		
	}
	/*
	 * @Override public UserVO getUser(String loginUserId) { return new
	 * UserVO("carami",
	 * "$2a$10$G/ADAGLU3vKBd62E6GbrgetQpEKu2ukKgiDR5TWHYwrem0cSv6Z8m"); }
	 * 
	 * @Override public List<UserRoleVO> getUserRoles(String loginUserId) {
	 * List<UserRoleVO> list = new ArrayList<>(); list.add(new UserRoleVO("carami",
	 * "ROLE_USER")); return list; }
	 */

	/**
	 * 회원의 이메일을 검증하는 로직입니다 DB 유니크 조건도 같이 걸 예정
	 */
	public void userEmailVaildate(String email) {
		if (userMapper.selectUserByEmail(email)!=null) {
			throw new IllegalStateException("유저의 이메일이 중복됩니다.");
		}
	}
}
