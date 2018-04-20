package com.shop.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.dao.ProductDAO;
import com.shop.dao.SupplierDAO;
import com.shop.domain.Product;
import com.shop.utility.FileUtil;

@Controller
public class ProductController {
	
	private static final Logger log=LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	HttpSession httpSession;
	
private static String rootPath = System.getProperty("catalina.home");//catalina home gives the location of tomcat directory
	
	private static final String imageDirectory="ShoppingCartImages";
	
	@GetMapping("/product/get")
	public ModelAndView getProduct(@RequestParam String id)
	{
		log.debug("Starting of getProduct Method");
		ModelAndView mv=new ModelAndView("home");
		product=productDAO.get(id);
		mv.addObject("selectedProduct",product);
		mv.addObject("isUserSelectedProduct",true);
		httpSession.setAttribute("selectedProductImage",rootPath+File.separator+imageDirectory+File.separator+id+".PNG");
		log.debug("ending of getProduct Method");
		return mv;
	}
	
	@PostMapping("/product/save/")
	public ModelAndView saveProduct(@RequestParam String id,@RequestParam String name,@RequestParam String description,
			                         @RequestParam("categoryId") String categoryId,@RequestParam("supplierId") String supplierId,
			                         @RequestParam("price") String price,@RequestParam("file") MultipartFile file)
	{
		log.debug("Starting of saveProduct Method");
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setCategoryId(categoryId);
		product.setCategory(categoryDAO.get(categoryId));
		product.setSupplierId(supplierId);
		product.setSupplier(supplierDAO.get(supplierId));
		price=price.replace(",","");
		product.setPrice(Integer.parseInt(price));
		ModelAndView mv=new ModelAndView("redirect:/manage_product");
		if(productDAO.save(product)==true)
		{
			mv.addObject("productSuccessMessage","Product saved");
			List<Product> products =productDAO.productlist();
			httpSession.setAttribute("products",products);
			//call upload image
			if(FileUtil.fileCopyNIO(file, id + ".PNG"))
				mv.addObject("uploadMessage", "Image successfully uploade");
			else mv.addObject("uploadMessage","Could not update image");
 		}
		else mv.addObject("productErrorMessage","Could not save product try again");
		log.debug("ending of saveProduct Method");
		return mv;
	}
	
	@GetMapping("/product/edit/")
	public ModelAndView editProduct(@RequestParam String id)
	{
		log.debug("Starting of editProduct Method");
		ModelAndView mv= new ModelAndView("redirect:/manage_product");
		product=productDAO.get(id);
		//mv.addObject("editProduct",true);
		httpSession.setAttribute("selectedProduct",product);
		log.debug("ending of editProduct Method");
		return mv;
	}
	
	@GetMapping("/product/delete/")
	public ModelAndView deleteProduct(@RequestParam String id)
	{
		log.debug("Starting of deleteProduct Method");
		ModelAndView mv=new ModelAndView("redirect:/manage_product");
		if(productDAO.delete(id)==true)
			mv.addObject("productSuccessMessage","Product deleted");
		else mv.addObject("productErrorMessage","Could not delete product try again");
		log.debug("ending of deleteProduct Method");
		return mv;
	}
	
	@GetMapping("/products")
	public ModelAndView getAllProducts()
	{
		log.debug("Starting of getAllProduct Method");
		ModelAndView mv= new ModelAndView("redirect:/manage_product");
		List<Product> products=productDAO.productlist();
		mv.addObject("products",products);
		log.debug("ending of getAllProduct Method");
		return mv;
	}
}
