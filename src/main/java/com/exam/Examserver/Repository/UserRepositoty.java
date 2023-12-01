package com.exam.Examserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.Examserver.entity.User;

public interface UserRepositoty extends JpaRepository<User,Long> {

	public User findByUsername(String username);
	
	//deleting user by username
    public void deleteById(Long id);
}
