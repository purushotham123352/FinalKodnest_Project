package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;
import com.example.demo.service.TrainerService;



@Controller
public class TrainerController {
	@Autowired
	TrainerService tService;
	@PostMapping("/addCourse")
    public String addCourse(@RequestParam int courseId,
                            @RequestParam String courseName,
                            @RequestParam int coursePrice,
                            Model model) {

        // Here, you can process the form data and save the course details to a database or perform any other action as needed.

        // For demonstration purposes, we'll just add the course details to the model and display a success message.
       // model.addAttribute("courseId", courseId);
       // model.addAttribute("courseName", courseName);
       // model.addAttribute("coursePrice", coursePrice);
		Course cr=new Course();
		cr.setCourseId(courseId);
		cr.setCourseName(courseName);
		cr.setCoursePrice(coursePrice);
		Course c=tService.addCourse(cr);

		if(c!=null)

		{

		return "/trainerhome";

		}

		else

		{

		return "/createCourseFail";
		}

        // This should be the name of the Thymeleaf template to display the success message.
    	}
	@PostMapping("/lesson")

	public String lesson(@RequestParam("courseId")int courseId,

	@RequestParam("lessonId")int lessonId,

	@RequestParam("lessonName")String lessonName,

	@RequestParam("topics")String topics,

	@RequestParam("link")String link) {

	Course course=tService.getCourse(courseId);

	Lesson lesson=new Lesson(lessonId,lessonName,topics,link,course);

	tService.addLesson(lesson);

	course.getLessons().add(lesson);

	tService.saveCourse(course);

	return "/trainerHome";

	}
	@GetMapping("/showcourses")
	public String showCourses(Model model) {

	List<Course> courseList=tService.courseList();
	//model.add

	model.addAttribute("courseList",courseList);

	// System.out.println(courseList);

	return "course";

	}
}
