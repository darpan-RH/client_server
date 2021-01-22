package com.firstapp.repository;
import org.springframework.data.repository.CrudRepository;
import com.firstapp.modal.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByUsernameAndPassword(String username, String password);
	//public List <User> findAll();
	//public User editMyUser(int id);
}
