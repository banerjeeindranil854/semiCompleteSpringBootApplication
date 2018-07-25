package com.cts.ideathon.demoProject.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.ideathon.demoProject.Repository.LoginUserRepository;
import com.cts.ideathon.demoProject.bean.CustomUserDetails;
import com.cts.ideathon.demoProject.bean.ResisterUser;
import com.cts.ideathon.demoProject.exception.RegisterUserNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private LoginUserRepository loginUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<ResisterUser> resisterUsers = loginUserRepository.findByName(username);
		if (!resisterUsers.isPresent())
			throw new RegisterUserNotFoundException("user name-" + username);
		return new CustomUserDetails(resisterUsers.get());
			
	}

}
