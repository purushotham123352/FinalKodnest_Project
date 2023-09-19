package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repo;

	@Override
	public boolean checkEmail(String email) {
		boolean b=repo.existsByEmail(email);
		return b;
	}

	@Override
	public String addUser(Users users) {
		repo.save(users);
		
		return "User Added successfully";
	}
	@Override

	public boolean validate(String email, String password) {

	if(repo.existsByEmail(email)) {

	Users u=repo.getByEmail(email);

	String dbPassword=u.getPassword();

	if(password.equals(dbPassword)) {

	return true;

	}

	else {

	return false;

	}

	}

	else {

	return false;

	}

	}

	@Override
	public Users getUser(String email) {
		Users u=repo.getByEmail(email);
		return u;
	}

	@Override
	public String getUserRole(String email) {
		Users u2=repo.getByEmail(email);
		String s=u2.getRole();
		return s;
	}

	@Override
	public String updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLesson() {
		repo.findAll();
		return null;
	}

}
