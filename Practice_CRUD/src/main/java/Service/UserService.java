package com.practice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Model.User;
import com.practice.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(User user) 
	{
		userRepository.save(user);
	}

	public List<User> getUsers() 
	{ 
		return userRepository.findAll() ;
	}

	public void updateUser(int id, User user) 
	{		
		
		User user1 = userRepository.findById(id).get();
		
		user1.setAge(user.getAge());
		user1.setEmail(user.getEmail());
		user1.setFirstname(user.getFirstname());
		user1.setLastname(user.getLastname());
		user1.setGender(user.getGender());
		user1.setLocation(user.getLocation());		
		
		userRepository.save(user1);
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

	public User findByUserId(int id) {
		
		return userRepository.findById(id).get();
	}

}
