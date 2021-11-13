package fr.formation.Gardens.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RolesAllowed(value = { "ROLE_ADMIN" })
	@RequestMapping("/admin")
	public String getUser() {
		return " Welcome admin";
	}

	@GetMapping(value = "/private")
	public String privateArea() {
		return "private";
	}
}
