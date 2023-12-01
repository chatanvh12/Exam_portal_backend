package com.exam.Examserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.Examserver.entity.JwtResponse;
import com.exam.Examserver.entity.User;
import com.exam.Examserver.entity.jwtRequest;
import com.exam.Examserver.security.JwtHelper;
import com.exam.Examserver.services.Impl.UserDetailsServiceImpl;
@RestController
@CrossOrigin("*")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationmanager; 
   
	@Autowired
	private UserDetailsServiceImpl userdetail;
	
	@Autowired
	private JwtHelper jwthelper;
	
	//generate token 
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody jwtRequest jwtrequest){
		try {
		//	System.out.println(jwtrequest.getPassword()+" "+ jwtrequest.getUsername());
			authenticate(jwtrequest.getUsername(),jwtrequest.getPassword());
		}catch(Exception e) {
			e.printStackTrace();
		}
		UserDetails details=this.userdetail.loadUserByUsername(jwtrequest.getUsername());
		
		String token=this.jwthelper.generateToken(details);
	    
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username,String password) throws Exception {
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e)
		{
			throw new Exception("User Disabled");
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Creadentials");
		}
	}
	//returns the details of current users
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User) this.userdetail.loadUserByUsername(principal.getName()));
	}
}
