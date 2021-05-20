package com.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Service.UserService;
import com.practice.Model.*;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index()
	{
		return "Welcome to homepage..";
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user)	
	{		
		userService.saveUser(user);
		return ResponseEntity.ok(user);
//		return "User registered Successfullyyyy...";
	}
	
	@GetMapping("/list")
	public List<User> listUser()	
	{		
		return userService.getUsers();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody User user)	
	{		
		userService.updateUser(id, user);
		return ResponseEntity.ok(user);
//		return "User updated Successfullyyyy...";
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id)	
	{		
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
//		return "User deleted Successfullyyyy...";
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") int id)	
	{		
		return userService.findByUserId(id);
	}
	
	
}
