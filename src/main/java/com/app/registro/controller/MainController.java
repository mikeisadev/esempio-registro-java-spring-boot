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

@Controller
public class MainController {
	
    private final UserRepository userRepository;
    
    public MainController(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }


    @GetMapping(value="")
    public String viewHomePage(Model model) {
        return "pages/index";
    }
    
    @GetMapping(value="/utenti")
    public String viewUsersPage(Model model) {
    	List<User> utenti = userRepository.findAll();
    	
    	model.addAttribute("utenti", utenti);
    	
    	return "pages/auth/users";
    }
    
    @PostMapping(value="/utenti") 
    public String addUser(@RequestParam Map<String,String> params) {
    	String nome = params.get("nome");
    	String cognome = params.get("cognome");
    	String email = params.get("email");
    	
    	System.out.println(nome + " " + cognome);
    	
    	User user = new User(email, nome, cognome);
    	
    	userRepository.save(user);
    	
    	return "redirect:/pages/auth/utenti";
    }
    
}