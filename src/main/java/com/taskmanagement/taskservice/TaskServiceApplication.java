package com.taskmanagement.taskservice;

import com.taskmanagement.taskservice.model.Role;
import com.taskmanagement.taskservice.model.User;
import com.taskmanagement.taskservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskServiceApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}


/**
*
 * @param args
 * @throws Exception
*/
	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setUsername("demo");
//		user.setFullName("test");
//		user.setRole(Role.USER);
//		user.setEmail( "demo@123");
//		user.setPassword("1234");
//
//		this.userService.createUser(user);

	}
}
