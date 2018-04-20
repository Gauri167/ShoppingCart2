package com.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.domain.Order;
import com.shop.mail.EmailSend;

@Controller
public class MailController {

    @Autowired
    private HttpSession httpSession;
    
    
	@RequestMapping("/sendorder")
	public ModelAndView sendEMail()
	{
		
		ModelAndView mv=new ModelAndView("home");
		String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		Order order=(Order)httpSession.getAttribute("orderDetails");
		String description="Order no:-"+order.getId()+"\nProduct Name:-"+order.getProductName()+"\nProduct Price:-"+order.getProductPrice()+
				            "\nPayment Mode:-"+order.getPaymentMode()+"\n Amount:-"+order.getAmount();
		String from="167gauri.g@gmail.com";
		EmailSend.sendMail(loggedInUserId,from,"Order Details", description);
		mv.addObject("successMessage","MailSend");
		return mv;
	}
}
