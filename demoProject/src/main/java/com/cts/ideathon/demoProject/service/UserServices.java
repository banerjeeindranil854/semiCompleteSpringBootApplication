package com.cts.ideathon.demoProject.service;

import java.util.List;
import java.util.Optional;

import com.cts.ideathon.demoProject.bean.User;

public interface UserServices {
	List<User> findAllUser();
	Optional<User> findUser(long id);
	void deleteUser(long id);
	User saveUser(User user);
	User updateUser(long id,User user);
}
