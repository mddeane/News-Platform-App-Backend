package com.nolarity.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nolarity.exception.UserNotFoundException;
import com.nolarity.model.User;
import com.nolarity.repository.UserRepository;

@Service
public class UserService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public Set<User> getAllUsers() {
		Set<User> allUsers = userRepository.findAll().stream().collect(Collectors.toSet());
		log.info("Getting all users: " + allUsers.size() + " total users.");
		return allUsers;
	}

	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		User user = new User();
		try {
			user = userRepository.findUserByUsername(username);
			log.info("User with username " + username + ": " + user.getFirstName() + " " + user.getLastName() + " ID: " + user.getId());
		} catch (Exception e) {
			log.error("User not found with username: " + username);
			new UserNotFoundException("User not found with username: " + username);
		}
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User addUser(User user) {
		User addedUser = userRepository.save(user);
		log.info("Added user with ID " + addedUser.getId());
		return addedUser;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User modifyUser(User user) {
		log.info("Modified user with ID " + user.getId());
		return userRepository.save(user);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteUser(long id) {
		User user = userRepository.findUserById(id);
		userRepository.delete(user);
		log.info("Deleted user with ID " + id);
	}
}
