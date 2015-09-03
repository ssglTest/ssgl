package testdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import testdatajpa.domain.User;





public interface UserDao extends JpaRepository<User,Integer> ,JpaSpecificationExecutor<User>{
	

}
