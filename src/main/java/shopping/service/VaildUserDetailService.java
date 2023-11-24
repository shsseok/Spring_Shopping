package shopping.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shopping.mapper.UserMapper;
import shopping.model.UserVO;

@Service
public class VaildUserDetailService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(int userId) throws UsernameNotFoundException {
		// 데이터베이스에서 사용자 찾기
		UserVO userVo = userMapper.findUser(userId);
		// UserDetails 객체 생성 및 반환
		return new User(userVo.getUserEmail(), userVo.getUserPassword(), getAuthorities(userVo));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(UserVO userVo) {
		// 사용자의 권한을 설정합니다. 권한이 여러 개일 경우 여러 개의 SimpleGrantedAuthority를 생성할 수 있습니다.
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role : userVo.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

}
