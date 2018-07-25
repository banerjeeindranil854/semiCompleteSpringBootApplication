package com.cts.ideathon.demoProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ideathon.demoProject.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
