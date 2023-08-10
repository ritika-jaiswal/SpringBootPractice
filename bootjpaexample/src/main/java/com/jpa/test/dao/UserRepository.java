package com.jpa.test.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entites.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name,String city);
	
	
	//JPQL Query
	@Query("Select u from User u")
	public List<User> getAllUser();
	
	//search using single name
	@Query("Select u from User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n") String name);
	
	//search using single name
		@Query("Select u from User u WHERE u.name =:n AND u.city =:c")
		public List<User> getUserByName(@Param("n") String name, @Param("c") String city);
		
	//Native(SQL) Query
		@Query(value = "Select * from user", nativeQuery = true)
		public List<User> getUsers();
		
}
