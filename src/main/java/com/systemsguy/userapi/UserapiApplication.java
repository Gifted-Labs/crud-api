package com.systemsguy.userapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.systemsguy.userapi.model.UserEntity;
import com.systemsguy.userapi.repository.UserRepository;

@SpringBootApplication
public class UserapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UserapiApplication.class, args);	
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String...args) throws Exception{
		//TODO Auto-generated method stub.
		UserEntity user1 = new UserEntity();
		user1.setFullName("Mark Essien");
		user1.setEmail("markessien@gmail.com");
		userRepository.save(user1);

		
	}
}


