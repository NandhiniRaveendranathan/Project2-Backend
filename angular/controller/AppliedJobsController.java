package com.niit.angular.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.angular.DAO.AppliedJobsDAO;
import com.niit.angular.model.AppliedJobs;
import com.niit.angular.model.Job;
import com.niit.angular.model.User;

@RestController
public class AppliedJobsController {
	
	@Autowired
	private AppliedJobsDAO  appliedJobsDAO;

	@Autowired
	private AppliedJobs appliedJobs;
	
	
public AppliedJobsDAO getAppliedJobsDAO() {
		return appliedJobsDAO;
	}

	public void setAppliedJobsDAO(AppliedJobsDAO appliedJobsDAO) {
		this.appliedJobsDAO = appliedJobsDAO;
	}

@GetMapping("/allappliedjobs") // working

public List<AppliedJobs> ajobs()
	{	
	return appliedJobsDAO.list();
}

@GetMapping("/alljobid/{jid}") //working
public List<AppliedJobs> ajobsid(@PathVariable("jid")int jid)
{	
return appliedJobsDAO.getByJobId(jid);
}

@GetMapping("/alljobuserid/{id}") // working
public List<AppliedJobs> ajobsuid(@PathVariable("id") int id)
{	
return appliedJobsDAO.getByUserId(id);
}

@GetMapping("/alljobusername/{uname}") // working
public List<AppliedJobs> ajobsuname(@PathVariable("uname")String name)
{	
return appliedJobsDAO.getByUserName(name);
}


@GetMapping("/appliedjobs/{ajobid}")  // works
public ResponseEntity getaJobs(@PathVariable("ajobid") int id) {

	AppliedJobs ajob = appliedJobsDAO.getByAJobId(id);
	if (ajob == null) {
		return new ResponseEntity("No  Applied Job found for ID " + id, HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity(ajob, HttpStatus.OK);
}

@DeleteMapping("/appliedjobs/{ajobid}") //notworking
public ResponseEntity deleteaJob(@PathVariable int id) {
	AppliedJobs ajob=appliedJobsDAO.getByAJobId(id);
		if (ajob==null) {
		return new ResponseEntity("No Job found for ID " + id, HttpStatus.NOT_FOUND);
	}
		appliedJobsDAO.delete(id);
	return new ResponseEntity(id, HttpStatus.OK);

}

@PostMapping("/appliedjobs")      //      Job job
public ResponseEntity applyjob(@RequestBody AppliedJobs appliedJobs/*, HttpSession session*/) {
	/*User user=(User)session.getAttribute("user");*/
	
	/*appliedJobs.setJobsid(job.getId());
	appliedJobs.setUserId(user.getCusId());
	appliedJobs.setJobname(job.getJobtitle());
	appliedJobs.setUserName(user.getName());*/
	
	appliedJobsDAO.saveOrUpdate(appliedJobs);

	return new ResponseEntity(appliedJobs, HttpStatus.OK);

}


}