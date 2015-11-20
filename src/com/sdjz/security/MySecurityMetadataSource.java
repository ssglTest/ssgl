package com.sdjz.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.sdjz.help.CommonHelp;

/*
 * 执行构造函数中的loadResourceDefine
 * 取出所有的url资源，并取出url对应的权限集合，然后用户登录，执行DefaultUserDetail中的loadUserByUsername方法
 */
//1、2、3、4为服务器启动时调用的顺序
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	//驱动程序名
	private String driver = "com.mysql.jdbc.Driver";
	// 访问数据库的用户名
	private String username;
	// 访问数据库的密码
	private String password;
	// 访问数据库的路径
	private String url;
	/*
	 * 这里的sourceMap用static声明为一个静态的变量，为了避免用户每请求一次都要去数据库读取资源和权限， 这里只读取一次，并保存起来
	 */
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public MySecurityMetadataSource() {
		try {
			loadJdbc();
			loadResourceDefine();
		} catch (Exception e) {
			System.err.println("读取数据库失败");
		}

	}

	/*
	 * 没有用Properties类来获取url,username,password
	 * 因为没有将applicationContext.xml中的有关数据访问的url,username,password抽取到一个属性文件中去
	 * 如果将它们抽取到属性文件中，则程序不能运行，目前还没有找到原因。
	 */
	private void loadJdbc() {
		url = "jdbc:mysql://localhost:3306/ssgl?useUnicode=true&amp;characterEncoding=UTF-8";
		username = "root";
		password = "totoro";
	}

	private void loadResourceDefine() {
		// 获取数据库中的所有权限
		List<String> roleNames = getAllRoleName();
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		for (String roleName : roleNames) {
			//用来装载用户的权限
			ConfigAttribute configAttribute = new SecurityConfig(roleName);
			// 查找出对应的角色资源
			List<String> resources = getURLsByRoleName(roleName);
			for (String url : resources) {
				url = "/" + url.trim();
				if (resourceMap.containsKey(url)) {
					// 获取这个url对应的权限集合
					Collection<ConfigAttribute> value = resourceMap.get(url);
					value.add(configAttribute);
					resourceMap.put(url, value);
				} else {
					Collection<ConfigAttribute> attr = new ArrayList<ConfigAttribute>();
					attr.add(configAttribute);
					resourceMap.put(url, attr);
				}
			}

		}
	}

	public List<String> getAllRoleName() {
		List<String> roleNames = new ArrayList<String>();
		try {
			//加载驱动程序
			Class.forName(driver);
			// Connection是java.sql中的
			//连接数据库
			Connection conn = DriverManager.getConnection(url, username, password);
			// Statement是java.sql中的
			Statement statement = conn.createStatement();
			String hql = "select roleName from role";
			ResultSet rs = statement.executeQuery(hql);
			while (rs.next()) {
				roleNames.add(rs.getString("roleName"));
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleNames;
	}

	public List<String> getURLsByRoleName(String roleName) {
		List<String> urls = new ArrayList<String>();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement statement = conn.createStatement();
			String hql = "SELECT DISTINCT resource.id, role.id, resource.url FROM resource left join role_resource on resource.id = role_resource.resource_id left join role on role.id = role_resource.role_id where parent_id is not null and role.roleName = '"
					+ roleName + "'";
			ResultSet rs = statement.executeQuery(hql);
			String resource = null;
			while (rs.next()) {
				resource = rs.getString("url");
				urls.add(resource);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return urls;
	}

	// 4
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	// 这个方法在url请求时才会调用，服务器启动时不会调用
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// 得到用户请求的url
		String url = ((FilterInvocation) object).getRequestUrl();
		// 用keySet()方法来获取resourceMap集合中所有的key值
		Iterator<String> it = resourceMap.keySet().iterator();
		while (it.hasNext()) {
			String resUrl = it.next();
			// 如果两个url地址相同，则将返回resourceMap中对应的权限集合，然后跳转到MyAccessDecisionManager中的decide方法进行权限判断
			if (CommonHelp.PathMatchesUrl(url, resUrl)) {
				return resourceMap.get(resUrl);
			}
		}
		// 如果不匹配，表示没有定义任何权限，可以直接访问
		return null;
	}

	// 3
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
