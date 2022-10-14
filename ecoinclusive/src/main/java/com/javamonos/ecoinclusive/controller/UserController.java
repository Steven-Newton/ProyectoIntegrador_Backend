package com.javamonos.ecoinclusive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javamonos.ecoinclusive.model.User;
import com.javamonos.ecoinclusive.service.UserService;

@RestController
	@RequestMapping(path="/api/users")
	public class UserController {	
		private final UserService userService;

		@Autowired
		public UserController(UserService userService) {
			super();
			this.userService = userService; 
		}//constructor
		
		@GetMapping
		public List<User> getAllUsers(){
			return userService.getUsers();
		}//getAllUsers
		
		@GetMapping(path = "{userId}")
		public User getUser(@PathVariable("userId") String email){
			return userService.getUser(email);
		}//getAllUser
		
		@DeleteMapping(path = "{userId}") // http://localhost:8080/api/users/
		public User deleteUser(@PathVariable("userd") String email){
			return userService.deleteUser(email);
		}//deleteUser
		
		@PostMapping
		public User addUser (@RequestBody User user) {
			return userService.addUser(user);
		}//addUser
		
		@PutMapping(path = "{userId}")
		public User updateUser (@PathVariable("userId") String email,
				@RequestParam (required = false) String nombre,
				@RequestParam (required = false) String telefono,
				@RequestParam (required = false) String contrasena)
	{
			return userService.updateUser(email, nombre, telefono, contrasena);
		}//updateUser

}
