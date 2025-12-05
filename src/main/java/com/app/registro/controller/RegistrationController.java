package com.app.registro.controller;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.registro.dto.RegistrationRequest;
import com.app.registro.model.User;
import com.app.registro.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/registrati")
	public String registratiPage(Model model) {
		model.addAttribute("regForm", new RegistrationRequest());
		
		return "pages/registrati";
	}
	
	@PostMapping("/registrati") 
	public String processRegistratation(
			@Valid @ModelAttribute("regForm") RegistrationRequest form,
			BindingResult bindingResult,
			Model model
	) {
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            bindingResult.rejectValue(
                    "confirmPassword",
                    "password.mismatch",
                    "Le password non coincidono"
            );
        }

        if (userRepository.findByEmail(form.getEmail()).isPresent()) {
            bindingResult.rejectValue(
                    "email",
                    "email.exists",
                    "Esiste già un account con questa email"
            );
        }

        if (bindingResult.hasErrors()) {
            return "pages/registrati";
        }

        User user = new User();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setEnabled(true);
        user.setRoles(Set.of("ROLE_USER"));

        userRepository.save(user);

        return "redirect:/pages/login?registered=true";
	}
}
