package com.algowebpro.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserDetailsService userDetailsService;

	// this will show only name
	@GetMapping("/current")
	public ResponseEntity<String> getCurrentUser(Principal principal){
		String name = principal.getName();
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
	
	// this will show all user info
	@GetMapping("/allinfo")
	public ResponseEntity<UserDetails> getAllInfoOfUser(Principal principal){
		String name=principal.getName();
		return new ResponseEntity<>(userDetailsService.loadUserByUsername(name),HttpStatus.OK);
	}
}
