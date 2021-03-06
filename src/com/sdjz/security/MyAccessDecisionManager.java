package com.sdjz.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/*
 * 自定义的用户授权
 */
public class MyAccessDecisionManager implements AccessDecisionManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#decide(org.
	 * springframework.security.core.Authentication, java.lang.Object,
	 * java.util.Collection)
	 * 
	 * 参数说明： 1.authentication 装载了从数据库读出来的角色数组，
	 * 这是从DefaultUserDetailService类中的loadUserByUsername方法中传过来的authentication对象
	 * 2.configAttributes: 装载了请求的url所允许的角色数组
	 * 
	 * 如果成立，则通过裁定 否则发生异常
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if (authentication == null)
			return;
		//所请求的资源拥有的权限（一个资源对应多个权限）
		Iterator<ConfigAttribute> ca = configAttributes.iterator();
		while (ca.hasNext()) {
			ConfigAttribute configAttribute = ca.next();
			//访问请求资源拥有的权限
			String realRole = ((SecurityConfig) configAttribute).getAttribute();
			//用户所拥有的权限authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (realRole.equals(ga.getAuthority()))
					return;
			}
		}
		//没有权限
		throw new AccessDeniedException("access denied");

	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
