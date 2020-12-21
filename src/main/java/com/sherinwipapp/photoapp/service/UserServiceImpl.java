package com.sherinwipapp.photoapp.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sherinwipapp.photoapp.user.dto.UserDto;
import com.sherinwipapp.photoapp.user.entities.UserEntitiy;
import com.sherinwipapp.photoapp.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntitiy userEntity = modelMapper.map(userDetails, UserEntitiy.class);
		userRepository.save(userEntity);
		UserDto userDetail = modelMapper.map(userEntity, UserDto.class);
		return userDetail;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntitiy userEntity = userRepository.findByEmail(username);
		if(userEntity == null) throw new UsernameNotFoundException("user not found");
		return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),true,true, true, true, new ArrayList<>());
	}
	
	public UserDto getUserDetailsByEmail(String email) {
		UserEntitiy userEntity = userRepository.findByEmail(email);
		return new ModelMapper().map(userEntity, UserDto.class);
		
	}

}
