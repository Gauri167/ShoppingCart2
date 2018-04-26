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
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/createCookie")
	public ModelAndView creataCookie(HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView("home");
		
		//increment hit counter
		//hitCounter++;
		
		//create cookie and set it in response
		//Cookie cookie=new Cookie("hitCounter",hitCounter.toString());
		String emailId=(String) httpSession.getAttribute("emailId");
		String password=(String) httpSession.getAttribute("password");
		Cookie mailCookie=new Cookie("emailId",emailId);
		Cookie pswdCookie=new Cookie("password", password);
		boolean remember=(boolean) httpSession.getAttribute("rememberMe");
		      mailCookie.setValue(emailId);
		       pswdCookie.setValue(password);
		       System.out.println("37");
		//response.addCookie(cookie);
		response.addCookie(mailCookie);
		response.addCookie(pswdCookie);
		 System.out.println("41");
		mv.addObject("isUserClickedLogin",true);
		if(remember==true)
		{
			String mail=mailCookie.getValue();
			String pswd=pswdCookie.getValue();
			mv.addObject("mail",mail);
			mv.addObject("pswd",pswd);
			System.out.println(mail);
			System.out.println(pswd);
			/*mv.addObject("emailId",emailId);
			mv.addObject("password",password);*/
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
				if(mcookie.getName().equals("mailCookie"))
				emailId=mcookie.getValue();
				mcookie.setMaxAge(60*60*24);
				int maxage=mcookie.getMaxAge();
				System.out.println(maxage);
				System.out.println(emailId);
			}
			for(Cookie pcookie:cookies)
			{
				if(pcookie.getName().equals("pswdCookie"))
					password=pcookie.getValue();
				System.out.println(password);
			}
		}
		if(emailId.isEmpty()&&password.isEmpty())
		{
		   return mv;
		}
		else {
			userDAO.get(emailId);
			boolean loggedIn=user.isLoggedIn();
			if(loggedIn==true)
			{
				mv.addObject("uname",emailId);
				mv.addObject("pswd",password);
				mv.addObject("keepLoggedIn",loggedIn);
				mv=new ModelAndView("redirect:/validate");
				return mv;}
			else {mv=new ModelAndView("redirect:/login"); 
				return mv;}
		}
	}
}
