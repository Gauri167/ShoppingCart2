package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.OrderDAO;
import com.shop.domain.Order;

public class OrderController {

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private Order order;
	
	@Autowired
	private HttpSession httpSession;
	
	@PostMapping("confirmOrder")
	public ModelAndView confirmOrder()
	{
		ModelAndView mv=new ModelAndView("home");
		String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		order.setEmailId(loggedInUserId);
        if(orderDAO.confirmOrder(order))
        	mv.addObject("successMessage","Order Placed Successfully");
        else mv.addObject("errorMessage","Could not place order");
        return mv;
	}
	
	@GetMapping("/cancelOrder")
	public ModelAndView cancelOrder(@RequestParam String id)
	{
		ModelAndView mv=new ModelAndView("home");
		if(orderDAO.cancelOrder(id)==true)
			mv.addObject("successMessage","Removed Successfully");
		else mv.addObject("errorMessage","Cannot Remove");
		return mv;
	}
	
	@GetMapping("/myOrder")
	public ModelAndView getOrderDetails(@RequestParam String id)
	{
		ModelAndView mv=new ModelAndView("home");
		order=orderDAO.get(id);
		mv.addObject("myOrderDetails",order);
		return mv;
	}
	
	@GetMapping("/myOrders")
	public ModelAndView getAllOrders()
	{
		ModelAndView mv=new ModelAndView("home");
		String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		List<Order> orders=orderDAO.getOrderDetails(loggedInUserId);
		mv.addObject("UserClickedCancelOrder",true);
		mv.addObject("orders",orders);
		return mv;
	}
}
