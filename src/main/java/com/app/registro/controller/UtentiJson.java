package com.app.registro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.registro.exceptions.UserNotFoundException;
import com.app.registro.model.User;
import com.app.registro.repository.UserRepository;


@RestController
@RequestMapping("api/v1")
public class UtentiJson {
	
	private final UserRepository userRepository;
	
	public UtentiJson(
			UserRepository userRepository
	) {
		this.userRepository = userRepository;
	}
	
	@GetMapping(value="/utenti")
	List<User> all() {
		return userRepository.findAll();
	}
	
	@GetMapping(value="/utenti/{id}")
	User getUser(@PathVariable Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@PostMapping(value="/utente", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	User nuovoUtente(
			@ModelAttribute User newUser
	) throws RuntimeException {	
		return userRepository.save(newUser);
	}
	
	
}
