package com.sdjz.security;

import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sdjz.service.UserService;

/**
 * 提供当前登录用户的权限
 * 
 * @author zhan
 *
 */
public class DefaultUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// 获取对象
		com.sdjz.domain.User user = userService.findByUserName(username);
		if (user == null)
			throw new AccessControlException("用户不存在");

		//获取当前用户对应的所有的角色名字
		
		return null;
	}

}
