package com.exam.Examserver.entity;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Examportal_user")
public class User implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String username;
	private String password;
	private String firstName;
	private String lastNamen;
	private String email;
	private String phone;
	private boolean enable = true;
	private String profile;

	// user many roles
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private Set<Userrole> userRole = new HashSet<>();

	public Set<Userrole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<Userrole> userRole) {
		this.userRole = userRole;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNamen() {
		return lastNamen;
	}

	public void setLastNamen(String lastNamen) {
		this.lastNamen = lastNamen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public User(Long id, String username, String password, String firstName, String lastNamen, String email,
			String phone, boolean enable, String profile) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastNamen = lastNamen;
		this.email = email;
		this.phone = phone;
		this.enable = enable;
		this.profile = profile;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

       Set<Authority> set=new HashSet<>();
       
       this.userRole.forEach(userRole->{
    	   set.add(new Authority(userRole.getRole().getRoleName()));
       });
		return set;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
