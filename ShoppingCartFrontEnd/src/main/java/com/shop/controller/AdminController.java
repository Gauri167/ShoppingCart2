package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@GetMapping("/manage_category")
	public ModelAndView adminCategory() 
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isAdminClickedManageCategories",true);
		//mv.addObject("category",new Category());
		List<Category> categories=categoryDAO.categorylist();
		httpSession.setAttribute("categories", categories);
		return mv;
	}
	
	@GetMapping("/manage_supplier")
	public ModelAndView adminSupplier()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isAdminClickedManageSuppliers",true);
		List<Supplier> suppliers=supplierDAO.supplierlist();
		httpSession.setAttribute("suppliers", suppliers);
		return mv;
	}
	
	@GetMapping("/manage_product")
	public ModelAndView adminProduct()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isAdminClickedManageProducts",true);
		List<Product> products=productDAO.productlist();
		List<Category> categories=categoryDAO.categorylist();
		List<Supplier> suppliers=supplierDAO.supplierlist();
		httpSession.setAttribute("products", products);
		httpSession.setAttribute("categories",categories);
		httpSession.setAttribute("suppliers",suppliers);
		//we are supposed tonfetch all the categories and suppliers and add it to manage products
		
		return mv;
	}
}
