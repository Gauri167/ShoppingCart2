package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/product/get/")
	public ModelAndView getProduct(@RequestParam String id)
	{
		ModelAndView mv=new ModelAndView("redirect:/manage_product");
		product=productDAO.get(id);
		mv.addObject("product",product);
		return mv;
	}
	
	@PostMapping("/product/save/")
	public ModelAndView saveProduct(@RequestParam String id,@RequestParam String name,@RequestParam String description,
			                         @RequestParam String categoryId,@RequestParam String supplierId)
	{
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setCategoryId(categoryId);
		product.setSupplierId(supplierId);
		ModelAndView mv=new ModelAndView("redirect:/manage_product");
		if(productDAO.save(product)==true)
		{
			mv.addObject("productSuccessMessage","Product saved");
			List<Product> products =productDAO.productlist();
			httpSession.setAttribute("products",products);
 		}
		else mv.addObject("productErrorMessage","Could not save product try again");
		return mv;
	}
	
	@GetMapping("/product/edit/")
	public ModelAndView editProduct(@RequestParam String id)
	{
		ModelAndView mv= new ModelAndView("redirect:/manage_product");
		product=productDAO.get(id);
		//mv.addObject("editProduct",true);
		httpSession.setAttribute("selectedProduct",product);
		return mv;
	}
	
	@GetMapping("/product/delete/")
	public ModelAndView deleteProduct(@RequestParam String id)
	{
		ModelAndView mv=new ModelAndView("redirect:/manage_product");
		if(productDAO.delete(id)==true)
			mv.addObject("productSuccessMessage","Product deleted");
		else mv.addObject("productErrorMessage","Could not delete product try again");
		return mv;
	}
	
	@GetMapping("/products")
	public ModelAndView getAllCategories()
	{
		ModelAndView mv= new ModelAndView("redirect:/manage_product");
		List<Product> products=productDAO.productlist();
		mv.addObject("products",products);
		return mv;
	}
}
