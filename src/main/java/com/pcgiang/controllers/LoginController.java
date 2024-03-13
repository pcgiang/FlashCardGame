package com.pcgiang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcgiang.models.StudentLogin;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String displayLoginForm(Model model) {
		model.addAttribute("loginModel", new StudentLogin());
		return "LoginForm.html";
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("loginModel") StudentLogin loginModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginModel", loginModel);
			return "LoginForm.html";
		}
		model.addAttribute("loginModel", loginModel);
		return "redirect:/createProfile";
	}
}
