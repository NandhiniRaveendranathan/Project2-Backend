package com.niit.angular.DAO;
import java.util.List;

import com.niit.angular.model.Job;
public interface JobDAO {
	public List<Job> list();

	public void save(Job job);

	public void saveOrUpdate(Job job);

	public Job getByJobId(int id);

	public void delete(int id);

}
