package com.niit.angular.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.angular.DAO.ForumDAO;
import com.niit.angular.model.Blog;
import com.niit.angular.model.Forum;

public class ForumDAOImpl implements ForumDAO{

	
	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Forum> list() {
		@SuppressWarnings("unchecked")
		List<Forum> forumList = sessionFactory.getCurrentSession().createQuery("from Forum").list();
		return forumList;
	}

	@Transactional
	public Forum get(int forumId) {
		Forum forumListByID = (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumId);

		return forumListByID;

	}

	@Transactional
	public void save(Forum forum) {
		sessionFactory.getCurrentSession().save(forum);
	}

	@Transactional
	public Forum saveOrUpdate(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return forum;

	}

	@Transactional
	public void delete(int forumId) {
		Forum forumToDelete = new Forum();
		forumToDelete.setForumId(forumId);
		sessionFactory.getCurrentSession().delete(forumToDelete);
		
	}
	@Transactional
	public List<Forum> getAcceptedList() {
		// TODO Auto-generated method stub
		
				String hql = "from Forum where status = " + "'A'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
				List<Forum> list = (List<Forum>) query.list();
				
				return list;
	}
	@Transactional
	public List<Forum> getNotAcceptedList() {
		String hql = "from Forum where status = " + "'NA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
		
		return list;

	}

}
