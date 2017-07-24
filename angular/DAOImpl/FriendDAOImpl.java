package com.niit.angular.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.angular.DAO.FriendDAO;
import com.niit.angular.model.AppliedJobs;
import com.niit.angular.model.Blog;
import com.niit.angular.model.Friend;
import com.niit.angular.model.User;

public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Friend> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Friend> friendList = sessionFactory.getCurrentSession().createQuery("from Friend").list();
		return friendList;
	}
	
	
@Transactional
	public List<Friend> getByUser(int userId) {
		Session session=sessionFactory.openSession();
		/*Transaction transac=session.beginTransaction();  */
		String hql = "from Friend where userId ='" + userId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> friens=query.list();
		session.close();
		return friens;
	}
@Transactional
public List<Friend> getByName(String userName) {
	Session session=sessionFactory.openSession();
	/*Transaction transac=session.beginTransaction();  */
	String hql = "from Friend where userName ='" + userName + "'";
	org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> frien=query.list();
	session.close();
	return frien;
}
@Transactional
public List<Friend> getByFriendName(String name) {
	Session session=sessionFactory.openSession();
	String hql = "from Friend where userName =" + "'" + name + "' and status = " + "'A'";
	org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> listFriend = (List<Friend>) query.list();
	session.close();
	return listFriend;
}


@Transactional
	public void save(Friend friend) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(friend);
	}
@Transactional
public List<Friend> getByFriendAccepted(String name){
	String hql = "from Friend where friendName =" + "'" + name + "' and status = " + "'A'";
	org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> listFriend = (List<Friend>) query.list();
	return listFriend;
}


	@Transactional
	public Friend saveOrUpdate(Friend friend) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		return friend;
	}

	@Transactional
	public Friend getByFriendId(int id) {
		// TODO Auto-generated method stub
		Friend friendListByID = (Friend) sessionFactory.getCurrentSession().get(Friend.class, id);

		return friendListByID;

	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Friend friendToDelete = new Friend();
		friendToDelete.setUserId(id);
		sessionFactory.getCurrentSession().delete(friendToDelete);
	}

	/*@Transactional
	public List<Friend> getByFriendName(String name) {
		String hql = "from Friend where friendName =" + "'" + name + "' and status = " + "'P'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();
		return listFriend;
	}
	
	@Transactional
	public List<Friend> getByFriendAccepted(String name){
		String hql = "from Friend where friendName =" + "'" + name + "' and status = " + "'A'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();
		return listFriend;
	}*/
	
	@Transactional
	public List<Friend> list(int userId) {
		String hql = "from Friend where userId =" + "'" + userId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Friend> listFriend = (List<Friend>) query.list();

		return listFriend;
	}



}