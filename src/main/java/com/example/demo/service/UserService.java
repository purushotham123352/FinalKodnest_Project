package com.example.demo.service;

import com.example.demo.entity.Users;

public interface UserService {
public boolean checkEmail(String email);
public String addUser(Users users);


//validates user's credentials

boolean validate(String email, String password);

Users getUser(String email);

String getUserRole(String email);

String updateUser(Users user);
String getLesson();
}
