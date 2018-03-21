package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

@Controller
public class HomeController {

	@Autowired
	HttpSession httpSession;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		ModelAndView mv=new ModelAndView("home");
		//httpSession.setAttribute("welcomeMessage","Welcome");
		List<Category> categories=categoryDAO.categorylist();
		httpSession.setAttribute("categories",categories);
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedLogin",true);
		return mv;
	}
	
	@RequestMapping("/signUp")
	public ModelAndView signUp() {
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedSignUp",true);
		return mv;
	}
}
