package com.exam.Examserver.services;

import java.util.Set;

import com.exam.Examserver.entity.User;
import com.exam.Examserver.entity.Userrole;

public interface UserService {
//creating user
	public User createUser(User user, Set<Userrole> userRole) throws Exception;

//getting user using user name
	public User getUser(String username);

	// Deleting user b user name
	public void Deleteuser(Long id);
}
