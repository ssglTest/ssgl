package testdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import testdatajpa.domain.Tutor;

public interface TutorDao extends JpaRepository<Tutor,Integer>,JpaSpecificationExecutor<Tutor>{

}
