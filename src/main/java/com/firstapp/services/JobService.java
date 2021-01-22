package com.firstapp.services;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.firstapp.modal.Job;
import com.firstapp.repository.JobRepository;
@Service
@Transactional

public class JobService {
	private final JobRepository jobRepo;
	public JobService(JobRepository jobRepo) {
		this.jobRepo=jobRepo;
	}
	public void SaveJob(Job job) {
		jobRepo.save(job);
	}
	
	public ArrayList<Job> showAllJob(){
		
		return (ArrayList<Job>)jobRepo.findAll();
	}
}
