package com.app.registro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {
	
	@GetMapping("/login")
	public String loginPage(Model model, String error, String logout, String registered) {
        if (error != null) {
            model.addAttribute("errorMsg", "Credenziali non valide");
        }
        if (logout != null) {
            model.addAttribute("logoutMsg", "Logout effettuato");
        }
        if (registered != null) {
            model.addAttribute("successMsg", "Registrazione completata. Ora puoi fare il login.");
        }
        
		return "pages/login";
	}
	
	@GetMapping("/admin") 
	public String adminPage(Model model) {
		return "pages/auth/admin";
	}
	
}
