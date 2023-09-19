package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;
@Service
public interface TrainerService {
public Course addCourse(Course courses);
public String addLesson(Lesson lesson);
Course getCourse(int courseId);
List<Course> courseList();
String saveCourse(Course course);
}
