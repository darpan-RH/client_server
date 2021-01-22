package com.firstapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.firstapp.modal.Job;
import com.firstapp.modal.User;
import com.firstapp.services.JobService;
import com.firstapp.services.UserService;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private UserService userService;
	@Autowired
	private JobService jobService;
	
	//for testing purpose 
	//not using sufix anf prifix like appcontroller
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/view/login.jsp";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password) {
		User user=new User(username, firstname, lastname, age, password);
		userService.SaveUser(user);
		return user.getFirstname()+" IS SAVED";
	}
	@PostMapping("/savejob")
	public String saveJob(@RequestParam String jobtitle, @RequestParam String jobdescription, @RequestParam String jobstatus) {
		Job job=new Job(jobtitle, jobdescription, jobstatus);
		jobService.SaveJob(job);
		return job.getJobtitle()+" IS ADDED";
	}
	@GetMapping("/allusers")
	public ArrayList<User> allusers(){
		return userService.showAllUser();
	}
	@GetMapping("/jobs")
	public ArrayList<Job> jobs(){
		return jobService.showAllJob();
	}
}
