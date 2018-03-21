package com.shop.shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.dao.UserDAO;
import com.shop.domain.User;

public class UserDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static User user;
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
		user=(User)context.getBean("user");
	}
	@Ignore
	@Test
	public void saveUserTestCase() {
		user.setEmailId("abcd8@gmail.com");
		user.setMobile("1111111");
		user.setName("User");
		user.setPassword("user@123");
		boolean status=userDAO.save(user);
		assertEquals("saveUserTestCase",true,status);
	}
	@Ignore
	@Test
	public void updateUserTestCase() {
		
		user.setEmailId("abcd@gmail.com");
	    user.setMobile("1234567");
	    boolean status=userDAO.update(user);
	    assertEquals("updateUserTestCase",true,status);
	}
	@Ignore
	@Test
	public void deleteUserTestCase() {
		
		boolean status=userDAO.delete("abcd7@gmail.com");
		assertEquals("deleteUserTestCase",true,status);
	}
	@Ignore
	@Test
	public void deleteUserFailureTestCase() {
		
		boolean status=userDAO.delete("xyz@gmail.com");
		assertEquals("deleteUserFailureTestCase",false,status);
	}
	@Ignore
	@Test
	public void getUserSuccessTestCase() {
		
		user=userDAO.get("abcd1@gmail.com");
		assertNotNull("getUserSuccessTestCase",user);
	}
	@Ignore
	@Test
	public void getUserFailureTest() {
		user=userDAO.get("xyz@gmail.com");
		assertNull("getUserFailureTestCase",user);
	}
	@Ignore
	@Test
	public void getAllUsersTestCase() {
		
		List<User> users=userDAO.userlist();
		assertNotNull("got error", users);
	}
	@Ignore
	@Test
	public void validateUserTestCase() {
		user=userDAO.validate("abcd2@gmail.com", "user@123");
		assertNotNull("validateUserTestCase",user);
	}
}
