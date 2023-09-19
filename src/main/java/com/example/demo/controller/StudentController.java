package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.entity.Course;

import com.example.demo.entity.Users;
import com.example.demo.service.TrainerService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	@Autowired
TrainerService tservice;
	@Autowired
	UserService uservice;
	@GetMapping("/purchase")
	public String showCourses(Model model,HttpSession session) {
		Users user=(Users)session.getAttribute("loggedInUser");
		List<Course> courselist=tservice.courseList();
		model.addAttribute("courseList",courselist);
		model.addAttribute("loggedInUser",user);
		
		return "purchase";
	}
	@GetMapping("/fetchCourses")

	public String fetchCourses(Model model, HttpSession session) {

	Users loggedUser=(Users) session.getAttribute("loggedInUser");

	String email=loggedUser.getEmail();

	Users user=uservice.getUser(email);

	List<Course> courseList=tservice.courseList();

	model.addAttribute("courseList",courseList);

	return "mycourses";

	}
//	@GetMapping("/viewLesson")
//
//	public String viewLesson(@RequestParam("lessonId")int lessonId,
//
//	Model model,HttpSession session) {
//
//	// Users user = (Users) session.getAttribute("loggedInUser");
//
//	Lesson lesson = uservice.getLesson();
//
//	// Extract the YouTube video id from the URL
//
//	String youtubeUrl = lesson.getLink();
//
//	String videoId = youtubeUrl.substring(youtubeUrl.indexOf("=") + 1);
//
//	lesson.setLink(videoId);
//
//	model.addAttribute("lesson",lesson);
//
//	List<Comments> commentsList=us458ervice.commentList();
//
//	model.addAttribute("comments",commentsList);
//
//	return "myLesson";
//
//	}
 }
