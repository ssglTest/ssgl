package com.sdjz.security;

import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sdjz.domain.UserRole;
import com.sdjz.service.UserService;

/**
 * 给用户提供自定义的授权处理
 * 
 * @author zhan
 *
 */
public class DefaultUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	/*
	 * 用户访问应用资源前，将会调用此方法获取用户对应的登录信息和权限范围
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// 获取对象
		com.sdjz.domain.User user = userService.findByUserName(username);
		if (user == null)
			throw new AccessControlException("用户不存在");
		
		// 获取当前用户对应的所有的角色名字
		try{
		for (UserRole userRole : user.getUserRoles()) {
			String roleName = userRole.getRole().getRoleName();
			System.out.println("user roleName======"+roleName);
			authorities.add(new SimpleGrantedAuthority(roleName));
		}
		} catch(Exception e){
			e.printStackTrace();
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		User userDetails = new User(user.getUserName(), user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		return userDetails;
	}

}
