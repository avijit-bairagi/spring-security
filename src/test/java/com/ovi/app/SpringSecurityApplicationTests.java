package com.ovi.app;

import com.ovi.app.entity.UserEntity;
import com.ovi.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {

		Optional<UserEntity> optionalUser = userRepository.findByUsername("a");

		Assertions.assertNotNull(optionalUser);
	}

}
