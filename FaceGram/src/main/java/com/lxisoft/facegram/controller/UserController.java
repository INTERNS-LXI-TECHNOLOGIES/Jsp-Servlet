package com.lxisoft.facegram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.facegram.model.User;
import com.lxisoft.facegram.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping("/")
	public String homePage() {
		return "index"; 
	}
	
	@RequestMapping("/login")
	public String login() {
		return "Login";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "Login";
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "Register";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		userService.save(user);
		return "login";
	}
	
	
}
