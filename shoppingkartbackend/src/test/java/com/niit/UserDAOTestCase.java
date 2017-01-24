package com.niit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Model.User;
import com.niit.UserDAO.UserDAO;


import junit.framework.Assert;

public class UserDAOTestCase {

	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User user;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void init()
	{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	user = (User) context.getBean("user");
	userDAO = (UserDAO) context.getBean("userDAOImpl");
	}
	
	@Test
	public void getUserTestCase()
	{
		user = userDAO.get("hi");
		//assert statements
		System.out.println("getUsertestcase executing");
		Assert.assertNotNull("getUserTestcase", user);
	}
	
	@Test
	public void validateCredentials()
	{
		user= userDAO.validate("hi", "going");
		Assert.assertEquals("validate",null, user);
		

	}
	@Test
	public void getAllusertestcase()
	{
		int size = userDAO.list().size();
		Assert.assertEquals("length",8, size);
	}
	
	@Test
	public void saveTestcase()
	{
		//you have to create new row in db		//provide values for user
		user.setId("harish1");
		user.setName("harish2");
		user.setPassword("hari15");
		user.setContact("465465");
		user.setRole("ROLE_CUST");
		
		Assert.assertEquals("save", true, userDAO.save(user));
	}
	@Test
	public void updateTestCase()
	{   //it will update the mentioned one
		user=userDAO.get("ram");//before updating first get the data 
		//updating the method
		user.setName("hi");
		
		Assert.assertEquals("update", true, userDAO.update(user));
		
		System.out.println("executing");
	}
	
	
	}

