package com.niit.angular.DAOImpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;
import com.niit.angular.DAO.AppliedJobsDAO;
import com.niit.angular.model.AppliedJobs;

@Transactional
@Repository("appliedJobsDAO")
public class AppliedJobsDAOImpl implements AppliedJobsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public AppliedJobsDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public List<AppliedJobs> list() {
		return sessionFactory.getCurrentSession().createQuery("from AppliedJobs").list();
	}

	public List<AppliedJobs> getByJobId(int jid) {
		Session session=sessionFactory.openSession();
		/*Transaction transac=session.beginTransaction();  */
		String hql = "from AppliedJobs where jobsid ='" + jid + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<AppliedJobs> ajobs=query.list();
		session.close();
		return ajobs;
	}

	public List<AppliedJobs> getByUserName(String name) {
		Session session=sessionFactory.openSession();
		String hql = "from AppliedJobs where userName ='" + name + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
		List<AppliedJobs> uemails=query.list();
		session.close();
		return uemails;
	}

	public void saveOrUpdate(AppliedJobs ajob) {
		sessionFactory.getCurrentSession().saveOrUpdate(ajob);
		
	}

	public AppliedJobs getByAJobId(int id) {   
		AppliedJobs ajobListByID = (AppliedJobs) sessionFactory.getCurrentSession().get(AppliedJobs.class, id);

		return ajobListByID;
	}

	public void delete(int id) {
		AppliedJobs ajobDelete = new AppliedJobs();
		ajobDelete.setAjId(id);
		sessionFactory.getCurrentSession().delete(ajobDelete);
		
	}
	public List<AppliedJobs> getByUserId(int uid) {
		
		Session session=sessionFactory.openSession();
		String hql = "from AppliedJobs where userId ='" + uid + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<AppliedJobs> uemails=query.list();
		session.close();
		return uemails;
	}

}