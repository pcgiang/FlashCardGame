package com.pcgiang.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pcgiang.models.Calculation;
import com.pcgiang.models.StudentProfile;

import org.springframework.ui.Model;

@Controller
public class FlashCardController {
	
	@GetMapping("/test1")
	@ResponseBody() // pure text
	public String printHello() {
		return "Hello!";
	}
	
	@GetMapping("/test2")
	public String displayMainPage(Model model) {
		model.addAttribute("title", "Welcome to Flash Card with Math!");
		model.addAttribute("firstNum", 1);
		model.addAttribute("secondNum", 2);
		model.addAttribute("operator", "x");
		return "Home";
	}
	
	@GetMapping("/test3")
	public ModelAndView displayMainPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("firstNum", 1);
		mv.setViewName("Home");
		return mv;
	}
	
	@GetMapping("/test4")
	public String display(@RequestParam("title") String title, Model model) {
		model.addAttribute("title", title); // get from param of url
		model.addAttribute("firstNum", 1);
		model.addAttribute("secondNum", 2);
		model.addAttribute("operator", "x");
		return "Home";
	}
	
	@GetMapping("/profile")
	public String displayProfile(Model model) {
		StudentProfile curStudent = new StudentProfile(1, "john123", "John Doe", 10, "orange");
		model.addAttribute("user", curStudent);
		return "Profile";
	}
	

		
	@GetMapping("/")
	public String displayFlashCard(Model model) {
		Calculation calculation = new Calculation();
		model.addAttribute("calculation", calculation);
		return "Home";
	}
	
	@GetMapping("/getNext")
	@ResponseBody
	public Calculation getNextFlashCard(
			@RequestParam("operator") String operator) {
		Calculation calculation = new Calculation(operator);
		return calculation;
	}
	
	@GetMapping("/getNew")
	@ResponseBody
	public Calculation resetFlashCard() {
		Calculation calculation = new Calculation();
		return calculation;
	}
	
	@GetMapping("/getResult")
	@ResponseBody()
	public String getResult(
			@RequestParam("operator") String operator,
			@RequestParam("first") String first,
			@RequestParam("second") String second
			) {
		Calculation calculation = new Calculation(Integer.parseInt(first), Integer.parseInt(second), operator);
		return String.valueOf(calculation.correctAns);
	}
	
}
