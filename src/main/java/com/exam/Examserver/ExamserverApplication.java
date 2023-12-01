package com.exam.Examserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	/*@Autowired
	private UserService_impl userservice;
	@Autowired
	private BCryptPasswordEncoder passwordencoder;*/
	
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*System.out.println("starting code");
		
		User user=new User();
		user.setFirstName("chetan");
		user.setLastNamen("vhanmane");
		user.setEmail("vhanmanechetan17@gmail.com");
		user.setEnable(true);
		user.setUsername("Chetan17@");
		user.setPassword(this.passwordencoder.encode("chetan17"));
		user.setProfile("sadfa");
		user.setPhone("8999523116");
		
		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		Set<Userrole> userRole=new HashSet<>();
		Userrole userrole=new Userrole();
		
		userrole.setRole(role1);
		userrole.setUser(user);
		
		userRole.add(userrole);
		
		User user1=this.userservice.createUser(user, userRole);
	*/}

}
