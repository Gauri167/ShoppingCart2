package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@GetMapping("/manage_category")
	public ModelAndView adminCategory() 
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isAdminClickedManageCategories",true);
		//mv.addObject("category",new Category());
		return mv;
	}
	
	@GetMapping("/manage_supplier")
	public ModelAndView adminSupplier()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isAdminClickedManageSuppliers",true);
		return mv;
	}
	
	@GetMapping("/manage_product")
	public ModelAndView adminProduct()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isAdminClickedManageProducts",true);
		return mv;
	}
}
