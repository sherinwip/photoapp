package com.sherinwipapp.photoapp.user.api.ui.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherinwipapp.photoapp.service.UserService;
import com.sherinwipapp.photoapp.user.api.ui.model.LoginRequestModel;
import com.sherinwipapp.photoapp.user.api.ui.model.UserDetailResponseModel;
import com.sherinwipapp.photoapp.user.dto.UserDto;
import com.sherinwipapp.photoapp.user.ui.request.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/status")
	public String status() {
		return "working";
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDetailResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetail) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetail, UserDto.class);
		UserDto userDetailsResponse = userService.createUser(userDto);
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDetailResponseModel userDetailResponse = modelMapper.map(userDetailsResponse,
				UserDetailResponseModel.class);
		return new ResponseEntity<UserDetailResponseModel>(userDetailResponse, HttpStatus.CREATED);

	}
	
	public ResponseEntity<UserDetails> login(@RequestBody LoginRequestModel loginRequestModel){
		return null;
		
	}
}
