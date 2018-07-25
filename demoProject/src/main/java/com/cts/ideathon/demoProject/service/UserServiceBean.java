package com.cts.ideathon.demoProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ideathon.demoProject.Repository.UserRepository;
import com.cts.ideathon.demoProject.bean.User;
@Service
public class UserServiceBean implements UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUser(long id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);

	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}

}
