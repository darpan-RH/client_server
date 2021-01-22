package com.firstapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.firstapp.modal.Job;

public interface JobRepository extends CrudRepository<Job, Integer>{
	

}
