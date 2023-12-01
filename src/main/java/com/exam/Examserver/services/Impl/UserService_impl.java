package com.exam.Examserver.services.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Examserver.Repository.RoleRepository;
import com.exam.Examserver.Repository.UserRepositoty;
import com.exam.Examserver.entity.User;
import com.exam.Examserver.entity.Userrole;
import com.exam.Examserver.services.UserService;

@Service
public class UserService_impl implements UserService {
	@Autowired
	private UserRepositoty userrepository;

	@Autowired
	private RoleRepository rolerepository;

	// Creating Users
	@Override
	public User createUser(User user, Set<Userrole> userRole) throws Exception {

		User local = this.userrepository.findByUsername(user.getUsername());
		System.out.println(user.getUsername());
		if (local != null) {
			throw new Exception("User Already there");
		} else {
			// user create
			for (Userrole ur : userRole) {
				rolerepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRole);
			local = this.userrepository.save(user);
		}
		return local;
	}

	// getting user by username
	@Override
	public User getUser(String username) {

		User user = this.userrepository.findByUsername(username);
		return user;
	}
	//Delete user by user name

	@Override
	public void Deleteuser(Long id) {
		this.userrepository.deleteById(id);
	}
	
	

}
