package com.niit.angular.DAO;


import java.util.List;

import com.niit.angular.model.BlogComment;

public interface BlogCommentDAO {
	
	public List<BlogComment> list();
	
	public List<BlogComment> getBlogComments(int blogId);
	
	public BlogComment getBlogComment(int blogCommentId);
	
	public BlogComment save(BlogComment bcomment);
	
	public BlogComment saveOrUpdate(BlogComment bcomment);
		
	public void delete(int id);


}