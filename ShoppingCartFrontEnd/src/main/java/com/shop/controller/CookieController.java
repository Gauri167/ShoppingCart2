package com.shop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.UserDAO;
import com.shop.domain.User;

@Controller
public class CookieController {
	
	@Autowired(required=false)
	private HttpSession httpSession;
	
	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/createCookie")
	public ModelAndView creataCookie(HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView("home");

		String emailId=(String) httpSession.getAttribute("emailId");
		String password=(String) httpSession.getAttribute("password");
		Cookie mailCookie=new Cookie("emailId",emailId);
		mailCookie.setMaxAge(60*60*24*10);
		System.out.println(mailCookie.getMaxAge());
		Cookie pswdCookie=new Cookie("password", password);
		pswdCookie.setMaxAge(60*60*24*10);
		System.out.println(pswdCookie.getMaxAge());
		boolean remember=(boolean) httpSession.getAttribute("rememberMe");
		      mailCookie.setValue(emailId);
		       pswdCookie.setValue(password);
		       
		response.addCookie(mailCookie);
		response.addCookie(pswdCookie);
		 
		mv.addObject("isUserClickedLogin",true);
		if(remember==true)
		{
			String mail=mailCookie.getValue();
			String pswd=pswdCookie.getValue();
			mv.addObject("mail",mail);
			mv.addObject("pswd",pswd);
			System.out.println(mail);
			System.out.println(pswd);
		}
		return mv;
	}
	
	@GetMapping("/checkCookie")
	public ModelAndView fetchCookie(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView("home");
		String emailId="",password="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie mcookie:cookies)
			{
				if(mcookie.getName().equals("emailId"))
				emailId=mcookie.getValue();
				mcookie.setMaxAge(60*60*24);
				int maxage=mcookie.getMaxAge();
				System.out.println(maxage);
				System.out.println(emailId);
			}
			for(Cookie pcookie:cookies)
			{
				if(pcookie.getName().equals("password"))
					password=pcookie.getValue();
				int maxage=pcookie.getMaxAge();
				System.out.println(maxage);
				System.out.println(password);
			}
		}
		if(emailId.isEmpty()&&password.isEmpty())
		{
		   return mv;
		}
		else {
			user=userDAO.get(emailId);
			boolean loggedIn=user.isLoggedIn();
			System.out.println(loggedIn);
			if(loggedIn==true)
			{
				mv.addObject("uname",emailId);
				mv.addObject("pswd",password);
				mv.addObject("keepLoggedIn",loggedIn);
                System.out.println("redirect to validate method");
                System.out.println(emailId);
                System.out.println(password);
                System.out.println(loggedIn);
				mv=new UserController().validate(emailId, password, loggedIn,httpSession);
                }
			return mv;
		}
	}
}
