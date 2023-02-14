package com.example.keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import java.security.Principal;

@RestController
public class EmployeeController {

	@GetMapping("/login")
	public String index() {
		return "Welcome to login Screen";
	}

	@GetMapping("/homepage")
	public String homepage(Principal principal) {
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) principal;
		AccessToken accessToken = token.getAccount().getKeycloakSecurityContext().getToken();
		return "Welcome to homepage, " + accessToken.getPreferredUsername() + " successfully logged in";
	}



}
