package testdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testdatajpa.dao.RoleDao;
import testdatajpa.domain.Role;

@Service("roleService")
public class RoleService {
	@Autowired 
	RoleDao roleDao;
	public void saveRole(Role role){
		roleDao.save(role);
	}
	public void saveRoles(List<Role> roles){
		for(Role role:roles){
			roleDao.save(role);
		}
	}
	public List<Role> findAll(){
		return roleDao.findAll();
	}

}
