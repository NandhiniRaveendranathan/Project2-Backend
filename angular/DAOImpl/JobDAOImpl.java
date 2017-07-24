package com.niit.angular.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.angular.DAO.JobDAO;
import com.niit.angular.model.Blog;
import com.niit.angular.model.Job;

public class JobDAOImpl implements JobDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public List<Job> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Job").list();
	}

	@Transactional
	public void save(Job job) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(job);
	}

	@Transactional
	public void saveOrUpdate(Job job) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(job);
	}

	@Transactional
	public Job getByJobId(int id) {
		// TODO Auto-generated method stub
		Job jobListByID = (Job) sessionFactory.getCurrentSession().get(Job.class, id);

		return jobListByID;

	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		/*sessionFactory.getCurrentSession().delete(id);*/
		
		
		Job jobToDelete = new Job();
		jobToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(jobToDelete);
	}

}