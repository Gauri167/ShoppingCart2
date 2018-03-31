package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

@Controller
public class CategoryController {
	
	private static final Logger log=LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private Category category;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	HttpSession httpSession;
	
	@GetMapping("/category/get/{id}")
	public ModelAndView getCategory(@RequestParam String id)
	{
		log.debug("Starting of getCategory Method");
		ModelAndView mv=new ModelAndView("home");
		category=categoryDAO.get(id);
		mv.addObject("category",category);
		log.debug("Ending of getCategory Method");
		return mv;
	}
	
	@PostMapping("/category/save/")
	public ModelAndView saveCategory(@RequestParam String id,@RequestParam String name,@RequestParam String description)
	{
		log.debug("Starting of saveCategory Method");
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		ModelAndView mv=new ModelAndView("redirect:/manage_category");
		if(categoryDAO.save(category)==true)
			{
			mv.addObject("categorySuccessMessage","Category saved");
			//fetch all the categories again and set to http page
			List<Category> categories=categoryDAO.categorylist();
			httpSession.setAttribute("categories",categories);
			}
		else mv.addObject("categoryErrorMessage","Could not save Category...Try again");
		log.debug("ending of saveCategory Method");
		return mv;
	}
	
	@GetMapping("/category/edit/")
	public ModelAndView editCategory(@RequestParam String id)
	{
		log.debug("Starting of editCategory Method");
		ModelAndView mv=new ModelAndView("redirect:/manage_category");
		//based on category id fetch category details.
		category=categoryDAO.get(id);
		mv.addObject("editCategories",true);
		httpSession.setAttribute("selectedCategory",category);
		/*if(categoryDAO.update(category)==true)
			mv.addObject("categorySuccessMessage","Category Update");
		else mv.addObject("categoryErrorMessage","Could not update Category try again");*/
		log.debug("ending of editCategory Method");
		return mv;
	}
	
	@GetMapping(name="/category/delete/")
	public ModelAndView deleteCategory(@RequestParam String id)
	{ 
		log.debug("starting of deleteCategory Method");
		ModelAndView mv=new ModelAndView("redirect:/manage_category");
		if(categoryDAO.delete(id)==true)
			mv.addObject("categorySuccessMessage","Category Deleted");
		else mv.addObject("categoryErrorMessage","Could not delete Category try again");
		log.debug("ending of deleteCategory Method");
        return mv;
	}

    @GetMapping("/categories")
	public ModelAndView getAllCategories()
	{
    	log.debug("starting of getAllCategory Method");
		ModelAndView mv=new ModelAndView("home");
		List<Category> categories=categoryDAO.categorylist();
		mv.addObject("categories",categories);
		log.debug("ending of getAllCategory Method");
		return mv;
	}
}
