package com.jwt.authentication.services;

import com.jwt.authentication.config.CustomUserDetail;
import com.jwt.authentication.entites.User;
import com.jwt.authentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //load user from database
        User user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found!!"));
//        CustomUserDetail customUserDetail = new CustomUserDetail(user);
        return user;
    }
}
