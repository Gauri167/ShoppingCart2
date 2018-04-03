package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CartDAO;
import com.shop.domain.Cart;

@Controller
public class CartController {
	
	@Autowired
	private HttpSession httpSession;

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	
	@PostMapping("/cart/add")
	public ModelAndView addToCart(@RequestParam String productName,@RequestParam int price,@RequestParam int quantity)
	{
		ModelAndView mv=new ModelAndView("home");
		String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		if(loggedInUserId.equals(null))
		{
			mv.addObject("errorMessage","please log in to add any product to cart");
			return mv;
		}
		cart.setEmailId(loggedInUserId);
		cart.setPrice(price);
		cart.setQuantity(quantity);
		
		if(cartDAO.save(cart))
		{
			mv.addObject("successMessage","Product added to cart");
		}
		else mv.addObject("errorMessage","Product not added to cart");
		return mv;
	}
	
	//get my cart details
	@GetMapping("/mycart/")
	public ModelAndView getMyCartDetails()
	{
		ModelAndView mv=new ModelAndView("home");
		// it will return all the products which are added to cart
		// this is not correct bcoz we must display only the products that are added by him
		String loggedInUserId= (String) httpSession.getAttribute("loggedInUserId");
		if(loggedInUserId.equals(null))
		{
			mv.addObject("errorMessage","please log in to add any product to cart");
			return mv;
		}
		List<Cart> cartList=cartDAO.cartlist(loggedInUserId);
		mv.addObject("cartList",cartList);
		return mv;
	}
	
	@GetMapping("/mycart")
	public ModelAndView myCart()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("isUserClickedMyCart",true);
		return mv;
		
	}
}
