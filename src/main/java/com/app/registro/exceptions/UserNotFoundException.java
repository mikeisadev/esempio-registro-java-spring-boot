package com.app.registro.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(Long id) {
		super("Utente non trovato " + id);
	}

}
