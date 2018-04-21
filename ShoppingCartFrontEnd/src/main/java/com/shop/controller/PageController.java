package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping("/homepage")
	public ModelAndView homePage()
	{
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping("/terms")
	public ModelAndView termsAndPolicy()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("userClickedTermsandPolicy",true);
		return mv;
	}
	
	@RequestMapping("/FAQ")
	public ModelAndView faqPage()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("userClickedfaq",true);
		return mv;
	}
	
	@RequestMapping("/aboutus")
	public ModelAndView aboutUsPage()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("userClickedAboutUs",true);
		return mv;
	}
}
