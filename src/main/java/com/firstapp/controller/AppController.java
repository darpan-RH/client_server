package com.firstapp.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.firstapp.modal.Job;
import com.firstapp.modal.User;
import com.firstapp.services.JobService;
import com.firstapp.services.UserService;

@Controller //to indicate this is web controller class and it scan for path
public class AppController {
	@Autowired
	UserService userService;
	@Autowired
	JobService jobService;

	@RequestMapping("/welcome")
	public String Welcome() {
		return "page1";
	}
	
	@RequestMapping("/register")
	public String registration() {
		return "test 1 registration";
	}
	  
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.SaveUser(user);
		return "usersaved";
	}
	
	@PostMapping("/add-job")
	public String registerUser(@ModelAttribute Job job, BindingResult bindingResultJob, HttpServletRequest requuest) {
		jobService.SaveJob(job);
		return "usersaved";
	}

	@RequestMapping("/delete-user")
	public String deleteuser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.showAllUser());
		return "showuser";
	}

	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("users", userService.editMyUser(id));		
		return "update";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
			request.setAttribute("users", userService.showAllUser());
			request.setAttribute("jobs", jobService.showAllJob());
			return "showuser";
		}
		else {
			request.setAttribute("error", "Invalid uname / password");
			return "login";
		}
	}
}
