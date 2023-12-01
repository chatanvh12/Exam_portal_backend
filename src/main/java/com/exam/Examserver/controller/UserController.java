package com.exam.Examserver.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.Examserver.entity.Role;
import com.exam.Examserver.entity.User;
import com.exam.Examserver.entity.Userrole;
import com.exam.Examserver.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	private BCryptPasswordEncoder passwordincoder;

	// creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		//Encrypting password with
		System.out.println(user.getUsername()+" "+ user.getPassword()+" "+user.getEmail()+" "+user.getLastNamen()+" "+user.getPhone()+" "+user.getUserRole());
		
		user.setPassword(this.passwordincoder.encode(user.getPassword()));
		
		Set<Userrole> roles = new HashSet<>();

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");

		Userrole userrole = new Userrole();
		userrole.setUser(user);
		userrole.setRole(role);

		roles.add(userrole);

		return this.userservice.createUser(user, roles);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userservice.getUser(username);
	}
	
	@GetMapping("/d/{id}")
	public void deleteuser(@PathVariable Long id) {
		this.userservice.Deleteuser(id);
	}
	
}
