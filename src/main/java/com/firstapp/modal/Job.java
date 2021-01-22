package com.firstapp.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class Job {
	@Id
	private int id;
	private String jobtitle;
	private String jobdescription;
	private String jobstatus;
	
	

	public Job(String jobtitle, String jobdescription, String jobstatus) {
		super();

		this.jobtitle = jobtitle;
		this.jobdescription = jobdescription;
		this.jobstatus = jobstatus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public String getJobstatus() {
		return jobstatus;
	}
	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}
	
	public Job() {
		
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobtitle=" + jobtitle + ", jobdescription=" + jobdescription + ", jobstatus="
				+ jobstatus + "]";
	}
}
