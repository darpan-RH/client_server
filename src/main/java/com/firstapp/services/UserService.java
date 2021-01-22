package com.firstapp.services;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.firstapp.modal.User;
import com.firstapp.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepo;
	public UserService(UserRepository userRepo){
		this.userRepo=userRepo;
	}
	public void SaveUser(User user) {
		userRepo.save(user);
	}
	public ArrayList<User> showAllUser(){
		return (ArrayList<User>) userRepo.findAll();
	}
	
	public void deleteMyUser(int id) {
		userRepo.deleteById(id);
		
	}
	public String editMyUser(int id) {
		//return userRepo.findById(id); //userRepo.findById(id);
		//userRepo.findAllById(id);
		//userRepo.findById(null)
		return userRepo.findById(id)+"";
	}
	public User findByUsernameAndPassword(String username, String password) {
		return userRepo.findByUsernameAndPassword(username, password);
	}
}
