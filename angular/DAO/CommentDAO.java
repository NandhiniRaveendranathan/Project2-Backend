package com.niit.angular.DAO;

import java.util.List;

import com.niit.angular.model.Comment;

public interface CommentDAO {
	
	
		public List<Comment> list();
		
		public List<Comment> getForumComments(int forumId);
		
		public Comment getComment(int CommentId);
		
		public Comment saveOrUpdate(Comment comment);
			
		public void delete(int id);

}