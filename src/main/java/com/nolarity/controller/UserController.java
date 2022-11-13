package com.nolarity.controller;

import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nolarity.model.User;
import com.nolarity.service.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<Set<User>> getAllUsers() {
		Set<User> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		User user = userService.getUserByUsername(username);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User addedUser = userService.addUser(user);
		return ResponseEntity.ok(addedUser);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<User> modifyUser(@Valid @RequestBody User user) {
		User modifiedUser = userService.modifyUser(user);
		return ResponseEntity.ok(modifiedUser);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
	}
}
