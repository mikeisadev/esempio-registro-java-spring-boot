package com.app.registro.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.registro.model.User;
import com.app.registro.repository.UserRepository;

// Marks this class as a REST controller
@Controller
// @RequestMapping(value="")
public class HelloController {
	
    private final UserRepository userRepository;
    
    public HelloController(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }


    @GetMapping(value="")
    public String viewHomePage(Model model) {
        return "index";
    }
    
    @GetMapping(value="/utenti")
    public String viewUsersPage(Model model) {
    	List<User> utenti = userRepository.findAll();
    	
    	model.addAttribute("utenti", utenti);
    	
    	return "users";
    }
    
    @PostMapping(value="/utenti") 
    public String addUser(@RequestParam Map<String,String> allParams) {
    	// Prendo i dati dalla richiesta HTTP tramite allParams
    	String nome = allParams.get("nome");
    	String cognome = allParams.get("cognome");
    	
    	// Stampo per fare una prova
    	System.out.println(nome + " " + cognome);
    	
    	// Creo un nuovo utente
    	User user = new User(nome, cognome);
    	
    	userRepository.save(user);
    	
    	// Reindirizzo alla pagina utenti
    	return "redirect:/utenti";
    }
    
}