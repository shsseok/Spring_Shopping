package shopping.security.service;

import java.util.List;

import shopping.model.UserVO;
import shopping.security.model.UserRoleVO;

public interface UserSecurityService {
    public UserVO getUser(String loginUserId);
    public List<UserRoleVO> getUserRoles(String loginUserId);
}
