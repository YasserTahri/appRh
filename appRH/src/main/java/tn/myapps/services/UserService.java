package tn.myapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.myapps.dao.UserRepository;
import tn.myapps.entities.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User save(User user){
		return userRepository.saveAndFlush(user);
	}
	public User update(User user){
		return userRepository.save(user);
		
	}
	public User find(String username){
		return userRepository.findByUsername(username);
		
	}
	public User find(Integer userId){
		return userRepository.findOne(userId);
		
	}

}
