package com.shop.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;
import com.shop.domain.User;

@Controller
public class HomeController {

	private static final Logger log=LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private User user;

	@RequestMapping("/")
	public ModelAndView home() {
		
		log.debug("Starting of home Method");
		ModelAndView mv=new ModelAndView("redirect:/checkCookie");
		//httpSession.setAttribute("welcomeMessage","Welcome");
		List<Category> categories=categoryDAO.categorylist();
		httpSession.setAttribute("categories",categories);
		log.debug("ending of home Method");
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		
		log.debug("Starting of login Method");
		ModelAndView mv=new ModelAndView("home");
		boolean remember=user.isRememberMe();
		if(remember==true)
		{
		Cookie[] cookies=request.getCookies();
		String emailId="";
		if(cookies!=null) {
			for(Cookie mcookie:cookies)
			{
				if(mcookie.getName().equals("mailCookie"))
				emailId=mcookie.getValue();
				mv.addObject("mail",emailId);
				System.out.println(emailId);
			}
		  }
		}
		mv.addObject("isUserClickedLogin",true);
		log.debug("ending of login Method");
		return mv;
	}
	
	@GetMapping("/myprofile")
	public ModelAndView myProfile()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedMyProfile",true);
		return mv;
	}
	
	@GetMapping("/forgotPasswrd")
	public ModelAndView frgtPasswrd()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedForgotPassword",true);
		return mv;
	}
	
	@RequestMapping("/signUp")
	public ModelAndView signUp() {
		
		log.debug("Starting of signUp Method");
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedSignUp",true);
		log.debug("Ending of SignUp Method");
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout()
	{
		log.debug("Starting of logout Method");
		//at time of login we added user in http session
		//at time of logout we need to remove it 
		ModelAndView mv=new ModelAndView("home");
		//httpSession.invalidate();
		httpSession.removeAttribute("loggedInUserId");
		httpSession.removeAttribute("UserClickedLogin");
		mv.addObject("thankyouPage",true);
		mv.addObject("logoutMessage","You are Successfully Logged Out");
		log.debug("ending of logout Method");
		return mv;
	}
}
