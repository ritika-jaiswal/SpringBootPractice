package com.jwt.authentication;

import com.jwt.authentication.entites.User;
import com.jwt.authentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class JwtAuthenticationApplicationTests {

//	@Test
//	void contextLoads() {
////	}
//	private UserService service;
//
//
//	@Test
//	public void getUsersTest() {
//		when(service.getUsers()).thenReturn(Stream.of(new User(UUID.randomUUID().toString(),"Rahul Girgal","rgirgal123@gmail.com"), new User(UUID.randomUUID().toString(),"Aman Jachpure", "ajachpure123@gmail.com")).collect(Collectors.toList()));
//	   assertEquals(2,service.getUsers().size());
//	};

}
