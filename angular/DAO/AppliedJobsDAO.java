package com.niit.angular.DAO;

import java.util.List;

import com.niit.angular.model.AppliedJobs;

public interface AppliedJobsDAO {
	
	
	public List<AppliedJobs> list();
	
	public List<AppliedJobs> getByJobId(int jid);           // local variable         
	public List<AppliedJobs> getByUserName(String name);  // user class
	public List<AppliedJobs> getByUserId(int uid);
	public void saveOrUpdate(AppliedJobs ajob);

	public AppliedJobs getByAJobId(int id);
	
	
	public void delete(int id);
	

}