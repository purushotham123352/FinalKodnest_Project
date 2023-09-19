package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LessonRepository;
@Service
public class TrainerServiceImpl implements TrainerService {
	@Autowired

	CourseRepository courseRepo;
	@Autowired
	LessonRepository lessonRepo;
	@Override
	public Course addCourse(Course courses) {
		// TODO Auto-generated method stub
		return courseRepo.save(courses);
	}

	
	@Override

	public String addLesson(Lesson lesson) {

	lessonRepo.save(lesson);

	return "lesson added successfully!";

	}

	@Override

	public Course getCourse(int courseId) {

	return courseRepo.findById(courseId).get();

	}

	@Override

	public List<Course> courseList() {

	return courseRepo.findAll();

	}

	@Override

	public String saveCourse(Course course) {

	courseRepo.save(course);

	return "Course saved successfully!";

	}

}
