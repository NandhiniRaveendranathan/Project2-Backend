package com.niit.angular.DAO;

import java.util.List;

import com.niit.angular.model.Friend;

public interface FriendDAO {
	public List<Friend> list();

	public List<Friend> getByUser(int userId);

	public List<Friend> getByName(String userName);

	public List<Friend> getByFriendName(String userName);

	public void save(Friend friend);

	public Friend saveOrUpdate(Friend friend);

	public List<Friend> getByFriendAccepted(String name);

	/*public List<Friend> getByFriendAccepted(String name);*/

	

	public List<Friend> list(int friendId);

	public Friend getByFriendId(int id);

	public void delete(int id);
	
	/*public void save(Friend friend);

	public Friend saveOrUpdate(Friend friend);

	public Friend getByFriendId(int id);
	
	public List<Friend> getByFriendName(String name);
	
	public List<Friend> getByFriendAccepted(String name);

	public void delete(int id);*/

}