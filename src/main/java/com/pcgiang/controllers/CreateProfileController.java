package com.pcgiang.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcgiang.models.StudentLogin;
import com.pcgiang.models.StudentProfile;

import jakarta.validation.Valid;

@Controller
public class CreateProfileController {
	@GetMapping("/createProfile")
	public String displayCreateProfileForm(Model model, StudentLogin loginModel) {
		model.addAttribute("studentProfile", new StudentProfile());
		return "SetupProfile";
	}	
}
