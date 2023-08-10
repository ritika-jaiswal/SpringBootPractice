package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.jpa.test.entites.*;

import com.jpa.test.dao.UserRepository;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
//		
//		User user = new User();
//		user.setName("Ritika Jaiswal");
//		user.setCity("Hyderabd");
//		user.setStatus("I am a Java Programmer");
		
		//Saving single user
//		User user1 = userRepository.save(user);
		

//		User user = new User();
//		user.setName("Mayuri Jaiswal");
//		user.setCity("Indore");
//		user.setStatus("I am a Data Analysist");
//		
//
//		User user1 = new User();
//		user1.setName("Paras Satodiya");
//		user1.setCity("Dhamnod");
//		user1.setStatus("I am a ROR Programmer");
		
//		System.out.println(user1);
		
		//Saving multiple user
//		List<User> list = List.of(user,user1);
		//Saving Multiple Object
//		Iterable<User> result = userRepository.saveAll(list);
//		result.forEach(userResult ->{
//			System.out.println("User List: " +  userResult);
//		});
		
		//Update the user of id 2
		
//		Optional<User> optional = userRepository.findById(2);
//		User user = optional.get();
//		user.setName("Aman Jachpure");
//		User result = userRepository.save(user);
//		System.out.println(result);
		
		//How to get the data
		//findById(id)- return Optinal Contaning your data
		
//		Iterable<User> itr = userRepository.findAll();
//		Iterable<User> iterator = itr.iterator();
//		while(iterator.hasNext())
//		{
//			User user = iterator.next();
//			System.out.println(user);
//		}
//	   itr.forEach(result ->{
//		   System.out.println(result);
//	   });
		
		//Deleting the user element
		//Deleted Single user
//		userRepository.deleteById(202);
//		 System.out.println("deleted");
//		 
//		 //Delete all users
//		 Iterable<User> allusers = userRepository.findAll();
//		 allusers.forEach(user->System.out.println(user));
//		 userRepository.deleteAll();
		
        //call derived method
//		List<User> users = userRepository.findByNameAndCity("Paras","Dhamnod");
//		users.forEach(e->System.out.println(e));
//		System.out.println("Done");
		 
//	List<User> allUser = userRepository.getAllUser();
//	allUser.forEach(e->System.out.println(e));
//	
//	List<User> userByName = userRepository.getUserByName("Paras");
//	userByName.forEach(e->System.out.println(e));
	
//	List<User> userByName = userRepository.getUserByName("Paras","Dhamnod");
//	userByName.forEach(e->System.out.println(e));
	
	userRepository.getUsers().forEach(e->System.out.println(e));
	}

}
