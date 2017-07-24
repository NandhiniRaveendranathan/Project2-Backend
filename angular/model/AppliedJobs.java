package com.niit.angular.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "appjobs")
public class AppliedJobs {   // one job how many applied admin as well as user should be able 2 view
	                            // varaibale first letter small 
	@Id
	@GeneratedValue	                                      // db config bean and dao pending
	private int ajId;
	
	
	private int  jobsid;
	private String jobname;
	private int userId;
	private String userName;
	private Date dateofapply ;
	private String timeofapply;
	


	public int getJobsid() {
		return jobsid;
	}
	public void setJobsid(int jobsid) {
		this.jobsid = jobsid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDateofapply() {
		return dateofapply;
	}
	public void setDateofapply(Date dateofapply) {
		this.dateofapply = dateofapply;
	}
	public String getTimeofapply() {
		return timeofapply;
	}
	public void setTimeofapply(String timeofapply) {
		this.timeofapply = timeofapply;
	}
	public int getAjId() {
		return ajId;
	}
	public void setAjId(int id) {
		this.ajId = id;
	}


	
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
	
	
}


