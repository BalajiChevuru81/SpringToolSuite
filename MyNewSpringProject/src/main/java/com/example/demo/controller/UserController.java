package com.example.demo.controller;

	
	import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

	import org.springframework.web.bind.annotation.RequestMapping;

	import org.springframework.web.bind.annotation.RestController;

	import com.example.demo.dao.UserRepository;
	import com.example.demo.pojos.User;


	@RestController
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/users")
	public class UserController {
		
		@Autowired
	 private UserRepository userRepository;

	 @RequestMapping("/getAllUsers")

	 public Iterable<User> getAllUsers(){

	 return userRepository.findAll();

	 }
	 @PostMapping("/saveuser")

	 public User saveUser(@RequestBody User user)

	 {

	  System.out.println(user);

	  userRepository.save(user);

	  return user;
	  	 }
	 	 
	 @PutMapping("/updateuser/{username}")

	 public User updateUser(@RequestBody User user,@PathVariable("username") String userName) {

		 user.setUsername(userName);
	  System.out.println(user);

	  userRepository.save(user);
	 
	  return user;
	  	 }
	 @DeleteMapping("/deleteUser/{username}")
	 
		 public Boolean deleteUser(@PathVariable("username") String username) {
			 System.out.println(username);
			 userRepository.deleteById(username);
			 return true;
		 }
	 @GetMapping("/findOneInAll6/{username}")



	 public User findoneinall(@PathVariable("username") String username)



	 {



	 Optional<User> user = userRepository.findById(username);



	 return user.get();



	 }


	 @GetMapping("/findByUsernameAndPassword/{username}/{password}")



	 public User findByUsernameAndPassword(@PathVariable("username") String username, @PathVariable("password") String password)



	 {



	 User user = userRepository.findByUsernameAndPassword(username,password);



	 return user;



	 }


	 
	 }