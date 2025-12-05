package com.app.registro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.registro.model.User;
import com.app.registro.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/utente")
public class EsempioRestAPI {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value="/tutti")
	List<User> getUsers() {
		List<User> allUsers = userRepository.findAll();
		
		return allUsers;
	}

}