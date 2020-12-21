package com.sherinwipapp.photoapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sherinwipapp.photoapp.user.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto createUser(UserDto userDetails);
	UserDto getUserDetailsByEmail(String email); 

}
