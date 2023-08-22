package com.jwt.authentication.repositories;

import com.jwt.authentication.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> findByEmail(String email);
//    @Query("select u from user where u.email = : email ")
//public Optional<User> findByEmail(@Param("email") String email);

}
