package com.neill.workouttracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neill.workouttracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	User findUserByUserName(String username);
}
