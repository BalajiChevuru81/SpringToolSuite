package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.pojos.User;

public interface UserRepository extends CrudRepository<User,String> {

	User findByUsernameAndPassword(String username,String password);

	User findByUsernameAndPasswordAndConfirm(String username, String password, String string);

	Optional<User> findByEmail(String emailId);

	
}
