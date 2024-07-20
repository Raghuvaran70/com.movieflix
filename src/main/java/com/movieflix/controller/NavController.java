package com.movieflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("map_signup")
	public String signUp() {
		return "signUp";
	}

	@GetMapping("map_login")
	public String login() {
		return "login";
	}
	
	@GetMapping("map_addmovie")
	public String addMovie() {
		return "addMoviePage";
	}
	
//	@GetMapping("home")
//	public String homePage() {
//		return "index.html";
//	}
}
