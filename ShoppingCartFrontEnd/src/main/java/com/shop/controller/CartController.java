package com.shop.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CartDAO;
import com.shop.dao.UserDAO;
import com.shop.domain.Cart;
import com.shop.domain.User;

@Controller
public class CartController {

	@Autowired(required = false)
	private HttpSession httpSession;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;

	private static String rootPath = "resources/images";

	@PostMapping("product/cart/add")
	public ModelAndView addToCart(@RequestParam String productName, @RequestParam int price, @RequestParam int quantity,
			@RequestParam String productId) {
		ModelAndView mv = new ModelAndView("home");
		String loggedInUserId = (String) httpSession.getAttribute("loggedInUserId");
		if (loggedInUserId.equals(null)) {
			mv.addObject("errorMessage", "please log in to add any product to cart");
			return mv;
		}
		List<Cart> cartList = cartDAO.cartlist(loggedInUserId);
		boolean f = false;
		for (Cart cartItem : cartList) {
		
			if (cartItem.getProductId().equals(productId)) {
				
				f = true;
			}
			
		}
		
		if (f) {
			for (Cart cartItem : cartList) {
				if (cartItem.getProductId().equals(productId)) {
					cartItem.setQuantity(cartItem.getQuantity() + quantity);
					if (cartDAO.update(cartItem)) {
						mv.addObject("successMessage", "Product added to cart");
					} else
						mv.addObject("errorMessage", "Product not added to cart");
				}
			}
		} 
		else {
			cart.setEmailId(loggedInUserId);
			cart.setPrice(price);
			cart.setQuantity(quantity);
			cart.setProductName(productName);
			cart.setProductId(productId);

			System.out.println(productId);

			if (cartDAO.save(cart)) {
				System.out.println("here 83");
				mv.addObject("successMessage", "Product added to cart");
			} else
				mv.addObject("errorMessage", "Product not added to cart");
		}
		cartList = cartDAO.cartlist(loggedInUserId);
		mv.addObject("isUserClickedMyCart", true);
		mv.addObject("cartList", cartList);
		httpSession.setAttribute("size", cartList.size());
		return mv;
	}

	// get my cart details
	@GetMapping("/mycart")
	public ModelAndView getMyCartDetails() {
		ModelAndView mv = new ModelAndView("home");
		// it will return all the products which are added to cart
		// this is not correct bcoz we must display only the products that are added by
		// him
		String loggedInUserId = (String) httpSession.getAttribute("loggedInUserId");
		if (loggedInUserId.equals(null)) {
			mv.addObject("errorMessage", "please log in to add any product to cart");
			return mv;
		}
		mv.addObject("isUserClickedMyCart", true);
		List<Cart> cartList = cartDAO.cartlist(loggedInUserId);
		mv.addObject("selectedProductImage", rootPath + File.separator + cart.getProductId() + ".PNG");
		mv.addObject("cartList", cartList);
		return mv;
	}

	@GetMapping("/remove")
	public ModelAndView removeItem(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("redirect:/mycart");
		// cart=cartDAO.get(id);
		String loggedInUserId = (String) httpSession.getAttribute("loggedInUserId");
		if (cartDAO.delete(id))
			mv.addObject("successMessage", "Product removed successfully");
		else
			mv.addObject("errorMessage", "Cannot Remove");
		List<Cart> cartList = cartDAO.cartlist(loggedInUserId);
		httpSession.setAttribute("size", cartList.size());
		return mv;
	}

	@GetMapping("/buy")
	public ModelAndView buyProduct(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("home");
		String loggedInUserId = (String) httpSession.getAttribute("loggedInUserId");
		cart = cartDAO.get(id);
		mv.addObject("cart", cart);
		user = userDAO.get(loggedInUserId);
		mv.addObject("user", user);
		mv.addObject("UserClickedBuy", true);
		return mv;
	}

}
