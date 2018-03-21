package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

@Controller
public class CategoryController {
	
	@Autowired
	private Category category;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	HttpSession httpSession;
	
	@GetMapping("/category/get/{id}")
	public ModelAndView getCategory(@RequestParam("id") String id)
	{
		ModelAndView mv=new ModelAndView("home");
		category=categoryDAO.get(id);
		mv.addObject("category",category);
		return mv;
	}
	
	@PostMapping("/category/save/")
	public ModelAndView saveCategory(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("description") String description)
	{
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		ModelAndView mv=new ModelAndView("home");
		if(categoryDAO.save(category)==true)
			{
			mv.addObject("categorySuccessMessage","Category saved");
			//fetch all the categories again and set to http page
			List<Category> categories=categoryDAO.categorylist();
			httpSession.setAttribute("categories",categories);
			}
		else mv.addObject("categoryErrorMessage","Could not save Category...Try again");
		return mv;
	}
	
	@PostMapping("/category/update/")
	public ModelAndView updateCategory(@RequestBody Category Category)
	{
		ModelAndView mv=new ModelAndView("home");
		if(categoryDAO.update(category)==true)
			mv.addObject("categorySuccessMessage","Category Update");
		else mv.addObject("categoryErrorMessage","Could not update Category try again");
		return mv;
	}
	
	@RequestMapping(name="/category/delete/{id}")
	public ModelAndView deleteCategory(@RequestParam("id") String id)
	{ 
		ModelAndView mv=new ModelAndView("home");
		if(categoryDAO.delete(id)==true)
			mv.addObject("categorySuccessMessage","Category Deleted");
		else mv.addObject("categoryErrorMessage","Could not delete Category try again");
        return mv;
	}

    @GetMapping("/categories")
	public ModelAndView getAllCategories()
	{
		ModelAndView mv=new ModelAndView("home");
		List<Category> categories=categoryDAO.categorylist();
		mv.addObject("categories",categories);
		return mv;
	}
}
