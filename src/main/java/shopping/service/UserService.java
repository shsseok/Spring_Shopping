package shopping.service;


import shopping.model.UserVO;
import shopping.request.UserRegisterRequest;


public interface UserService{
	public void addUser(UserRegisterRequest userRegisterRequest);
	public UserVO findUser(int userId);
}
