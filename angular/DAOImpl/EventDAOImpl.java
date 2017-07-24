package com.niit.angular.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.angular.DAO.EventDAO;
import com.niit.angular.model.Event;

public class EventDAOImpl implements EventDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Event> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}

	@Transactional
	public void save(Event event) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(event);
	}

	@Transactional
	public void saveOrUpdate(Event event) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}

	@Transactional
	public Event getEventId(int id) {
		// TODO Auto-generated method stub
		Event eventListByID = (Event) sessionFactory.getCurrentSession().get(Event.class, id);

		return eventListByID;

	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(id);
	}

}
