package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/nav")
public class NavigationController {
	@Autowired
	UserService uService;
	@GetMapping("/home")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String registerUser() {
	return "register";
	}	
	@GetMapping("/login")
	public String loginUser() {
		return "login";
	}
	@PostMapping("/adduser")
	public String addUser(@RequestParam("email") String email,
			@RequestParam("name") String name,
			@RequestParam("role") String role,
			@RequestParam("password") String password) {
		if(!(uService.checkEmail(email))) {
			Users us=new Users();
			us.setEmail(email);
			us.setName(name);
			us.setRole(role);
			us.setPassword(password);
			uService.addUser(us);
			
			return "redirect:/nav/login";
			
		}
		else {
			return "registerfail";
		}
		
	}
	@PostMapping("/validate")

	public String validate(@RequestParam("email")String email,

	@RequestParam("password")String password,

	HttpSession session) {

	if(uService.checkEmail(email)) {

	boolean val=uService.validate(email, password);

	

	if(val) {

	Users user = uService.getUser(email); // Assuming you have a method to get the User object

	session.setAttribute("loggedInUser", user); // Saving the User object in session

	if(uService.getUserRole(email).equals("trainer")) {

	return "trainerhome";

	}

	else {

	return "studenthome";

	}

	}

	else {

	

	return "loginfail";

	}

	}

	else {

	return "loginfail";

	}

	}
	@GetMapping("/addcourse")
	public String addCourse() {
		return "addcourse";
	}
	@GetMapping("/addlesson")
	public String addLesson() {
		return "addlesson";
	}
		@GetMapping("/showcourse")
		public String showCourse() {
			return "showcourse";
		}
}
