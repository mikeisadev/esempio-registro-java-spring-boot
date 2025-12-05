package com.app.registro.security;

import java.io.IOException;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RedirectAuthenticatedUserFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException 
	{	
		String path = request.getServletPath();
		
		if ( "GET".equalsIgnoreCase(request.getMethod())
				&& ("/login".equals(path) || "/registrati".equals(path))
				&& isAuthenticated() ) {
			
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	private boolean isAuthenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return  auth != null 
				&& auth.isAuthenticated()
				&& !(auth instanceof AnonymousAuthenticationToken);

	}
	
}
