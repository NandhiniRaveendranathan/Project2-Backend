package com.niit.angular.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.angular.DAO.BlogDAO;
import com.niit.angular.DAO.ChatDAO;
import com.niit.angular.DAO.EventDAO;
import com.niit.angular.DAO.ForumDAO;
import com.niit.angular.DAO.FriendDAO;
import com.niit.angular.DAO.JobDAO;
import com.niit.angular.DAO.UserDAO;
import com.niit.angular.DAOImpl.BlogDAOImpl;
import com.niit.angular.DAOImpl.ChatDAOImpl;
import com.niit.angular.DAOImpl.EventDAOImpl;
import com.niit.angular.DAOImpl.ForumDAOImpl;
import com.niit.angular.DAOImpl.FriendDAOImpl;
import com.niit.angular.DAOImpl.JobDAOImpl;
import com.niit.angular.DAOImpl.UserDAOImpl;

import com.niit.angular.model.AppliedJobs;
import com.niit.angular.model.Blog;
import com.niit.angular.model.BlogComment;
import com.niit.angular.model.Chat;
import com.niit.angular.model.Comment;
import com.niit.angular.model.Forum;
import com.niit.angular.model.Friend;
import com.niit.angular.model.Job;
import com.niit.angular.model.User;

import antlr.debug.Event;


@Configuration
@ComponentScan("com.niit.angular")
@EnableTransactionManagement
public class ApplicationContextConfig {
	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(ApplicationContextConfig.class);
	 */

	
	
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		/* logger.debug("Starting of the method getOracleDataSource"); */
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		// dataSource.setUsername("asdfghj"); // Schema name
		dataSource.setUsername("COLLABRATION");
		dataSource.setPassword("COLLABRATION");

		/*
		 * logger.debug("Setting the data source :" +
		 * dataSource.getConnectionProperties());
		 */
		/* logger.debug("Ending of the method getOracleDataSource"); */
		System.out.println("entering");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();

		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		/* logger.debug("Starting of the method getSessionFactory"); */
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		sessionBuilder.addAnnotatedClass(Chat.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Comment.class);
		sessionBuilder.addAnnotatedClass(AppliedJobs.class);
		/* logger.debug("Ending of the method getSessionFactory"); */
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		/* logger.debug("Starting of the method getTransactionManager"); */
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		/* logger.debug("Ending of the method getTransactionManager"); */
		return transactionManager;
	}

	@Autowired(required = true)
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory) {
		return new BlogDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "eventDAO")
	public EventDAO getEventDAO(SessionFactory sessionFactory) {
		return new EventDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "forumDAO")
	public ForumDAO getForumDAO(SessionFactory sessionFactory) {
		return new ForumDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "chatDAO")
	public ChatDAO getChatDAO(SessionFactory sessionFactory) {
		return new ChatDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "friendDAO")
	public FriendDAO getFriendDAO(SessionFactory sessionFactory) {
		return new FriendDAOImpl(sessionFactory);
	}

	@Autowired(required = true)
	@Bean(name = "jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory) {
		return new JobDAOImpl(sessionFactory);
	}

}