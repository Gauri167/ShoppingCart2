package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.dao.ProductDAO;
import com.shop.dao.SupplierDAO;
import com.shop.domain.Category;
import com.shop.domain.Product;
import com.shop.domain.Supplier;

@Controller
public class AdminController {

	private static final Logger log=LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired(required=false)
	HttpSession httpSession;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@GetMapping("/manage_category")
	public ModelAndView adminCategory() 
	{
		ModelAndView mv=new ModelAndView("home");
		//check whether user logged in or not
	    String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
	    if(loggedInUserId.equals(null))
	    {
	    	mv.addObject("errorMessage","Please Log in to do this operation");
	    	return mv;
	    }
		//if not logeed in give msg please login
		//of logged in check if user is admin or not
	   Boolean isAdmin=(Boolean) httpSession.getAttribute("isAdmin");
	    if(isAdmin==false|| isAdmin==null)
	    {
	    	mv.addObject("errorMessage","You are not Authorized");
	    	return mv;
	    }
		// if not admin give msg not authorized
		
		log.debug("Starting of adminCategory Method");
		mv.addObject("isAdminClickedManageCategories",true);
		//mv.addObject("category",new Category());
		List<Category> categories=categoryDAO.categorylist();
		httpSession.setAttribute("categories", categories);
		log.debug("Ending of adminCategory Method");
		return mv;
	}
	
	@GetMapping("/manage_supplier")
	public ModelAndView adminSupplier()
	{
		log.debug("Starting of adminSupplier Method");
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isAdminClickedManageSuppliers",true);
		List<Supplier> suppliers=supplierDAO.supplierlist();
		httpSession.setAttribute("suppliers", suppliers);
		log.debug("Ending of adminSupplier Method");
		return mv;
	}
	
	@GetMapping("/manage_product")
	public ModelAndView adminProduct()
	{
		log.debug("Starting of adminProduct Method");
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isAdminClickedManageProducts",true);
		List<Product> products=productDAO.productlist();
		List<Category> categories=categoryDAO.categorylist();
		List<Supplier> suppliers=supplierDAO.supplierlist();
		httpSession.setAttribute("products", products);
		httpSession.setAttribute("categories",categories);
		httpSession.setAttribute("suppliers",suppliers);
		//we are supposed to fetch all the categories and suppliers and add it to manage products
		log.debug("Ending of adminProduct Method");
		return mv;
	}
}
