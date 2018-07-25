package com.cts.ideathon.demoProject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ideathon.demoProject.bean.ResisterUser;

public interface LoginUserRepository extends JpaRepository<ResisterUser, Integer>{
	Optional<ResisterUser> findByName(String username);
}
