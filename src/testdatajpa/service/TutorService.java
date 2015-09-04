package testdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testdatajpa.dao.TutorDao;
import testdatajpa.domain.Tutor;

@Service("tutorService")
public class TutorService {
	@Autowired
	TutorDao tutorDao;
	public TutorService(){}
	public void saveTutor(Tutor tutor){
		tutorDao.save(tutor);
	}
	public void saveTutors(List<Tutor> tutors){
		for(Tutor tutor:tutors){
			tutorDao.save(tutor);
		}
	}
	public List<Tutor> findAll(){
		return tutorDao.findAll();
	}

}
