package com.sherinwipapp.photoapp.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.sherinwipapp.photoapp.user.entities.UserEntitiy;

public interface UserRepository extends CrudRepository<UserEntitiy, Long> {

	public UserEntitiy findByEmail(String userName);

}
