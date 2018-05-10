package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.OrderDAO;
import com.shop.domain.Order;

@Controller
public class OrderController {

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private Order order;
	
	@Autowired(required=false)
	private HttpSession httpSession;
	
	
	@PostMapping("/confirmOrder")
	public ModelAndView confirmOrder(@RequestParam String paymentMode,@RequestParam String name,@RequestParam String mobile,@RequestParam String address,
			                         @RequestParam String productName,@RequestParam String price,@RequestParam int quantity)
	{
		ModelAndView mv=new ModelAndView("redirect:/sendorder");
		String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		order.setEmailId(loggedInUserId);
		order.setAddress(address);
		order.setMobile(mobile);
		order.setProductName(productName);
		order.setProductPrice(price);
		order.setQuantity(quantity);
		order.setPaymentMode(paymentMode);
		int amount=Integer.parseInt(price)*quantity;
		order.setAmount(amount);
        if(orderDAO.confirmOrder(order))
        	{
        	mv.addObject("successMessage","Order Placed Successfully");
        	httpSession.setAttribute("orderDetails",order);
            }
        else mv.addObject("errorMessage","Could not place order");
        return mv;
	}
	
	

	@GetMapping("/cancelOrder")
	public ModelAndView cancelOrder(@RequestParam("id") int id)
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
		order=orderDAO.get(Integer.parseInt(id));
		mv.addObject("UserClickedDeleteOrder",true);
		mv.addObject("order",order);
		return mv;
	}
	
	@GetMapping("/myOrders")
	public ModelAndView getAllOrders(@RequestParam(value="id",required=false)String id)
	{
		ModelAndView mv=new ModelAndView("home");
		String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		List<Order> orders=orderDAO.getOrderDetails(loggedInUserId);
		mv.addObject("UserClickedCancelOrder",true);
		mv.addObject("orders",orders);
		return mv;
	}
}
