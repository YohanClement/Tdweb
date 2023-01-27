package fr.formation.inti.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.entity.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private Userdao dao;

	public Users save(Users entity) {
		Users user = dao.save(entity);
		return user;
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);	
	}

	public void delete(Users entity) {
		dao.delete(entity);		
	}

	public Users findByemail(String email) {
		Users user = dao.findByemail(email);
		return user;
	}

	@Override
	public Optional<Users> findById(Integer id) {
		Optional<Users> user = dao.findById(id);
		return user;
	}

	@Override
	public List<Users> findAll() {
		List<Users> list =  (List<Users>) dao.findAll();
		return list;
	}



}
