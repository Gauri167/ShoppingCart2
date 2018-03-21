package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.ProductDAO;
import com.shop.domain.Product;

@Controller
public class ProductController {

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	HttpSession httpSession;
	
	@GetMapping("/product/get/{id}")
	public ModelAndView getProduct(@RequestParam("id") String id)
	{
		ModelAndView mv=new ModelAndView("home");
		product=productDAO.get(id);
		mv.addObject("product",product);
		return mv;
	}
	
	@PostMapping("/product/save/")
	public ModelAndView saveProduct(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("description") String description)
	{
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		ModelAndView mv=new ModelAndView("home");
		if(productDAO.save(product)==true)
		{
			mv.addObject("productSuccessMessage","Product saved");
			List<Product> products =productDAO.productlist();
			httpSession.setAttribute("products",products);
 		}
		else mv.addObject("productErrorMessage","Could not save product try again");
		return mv;
	}
	
	@PutMapping("/product/update/")
	public ModelAndView updateProduct(@RequestBody Product product)
	{
		ModelAndView mv=new ModelAndView("home");
		if(productDAO.update(product)==true)
			mv.addObject("productSuccessMessage","Product Updated");
		else mv.addObject("productErrorMessage","Could not update Product try again");
		return mv;
	}
	
	@DeleteMapping("/product/delete/{id}")
	public ModelAndView deleteProduct(@RequestParam("id") String id)
	{
		ModelAndView mv=new ModelAndView("home");
		if(productDAO.delete(id)==true)
			mv.addObject("productSuccessMessage","Product deleted");
		else mv.addObject("productErrorMessage","Could not delete product try again");
		return mv;
	}
	
	/*@GetMapping("/categories")
	public ModelAndView getAllCategories()
	{
		ModelAndView mv= new ModelAndView("home");
		List<Product> products=productDAO.productlist();
		mv.addObject("products",products);
		return mv;
	}*/
}
