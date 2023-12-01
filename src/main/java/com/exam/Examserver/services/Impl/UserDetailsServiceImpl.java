package com.exam.Examserver.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.Examserver.Repository.UserRepositoty;
import com.exam.Examserver.entity.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepositoty userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.userrepo.findByUsername(username);
		if(user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("NO User Found !");
		}
		return user;
	}

}
