package com.sherinwipapp.photoapp.user.ui.request.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	@NotNull
	@Size(min = 2, message = "first name should be minimum 2 characters")
	private String firstName;
	@NotNull
	@Size(min = 2, message = "last name should be minimum 2 characters")
	private String lastName;
	@NotNull
	private String password;
	@NotNull
	@Email
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
