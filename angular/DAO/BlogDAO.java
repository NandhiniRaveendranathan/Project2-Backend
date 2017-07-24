package com.niit.angular.DAO;

import java.util.List;

import com.niit.angular.model.Blog;
public interface BlogDAO {
	public List<Blog> list();

	public Blog get(int id);
	
	public Blog getByTitle(String title);

	public void save(Blog blog);
	
	public void saveOrUpdate(Blog blog);

	public void delete(int id);

	public List<Blog> getNotAcceptedList();

	public List<Blog> getAcceptedList();
}
