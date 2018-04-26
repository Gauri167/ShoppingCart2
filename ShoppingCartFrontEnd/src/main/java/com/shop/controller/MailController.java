package com.shop.controller;

import java.util.Random;
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
    
    private String from="167gauri.g@gmail.com";
    
	@RequestMapping("/sendorder")
	public ModelAndView sendEMail()
	{
		
		ModelAndView mv=new ModelAndView("home");
		String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		Order order=(Order)httpSession.getAttribute("orderDetails");
		String description="Order no:-"+order.getId()+"\n<span style=\"color:red\">Product Name</span>:-"+order.getProductName()+"\nProduct Price:-"+order.getProductPrice()+
				            "\nPayment Mode:-"+order.getPaymentMode()+"\n Amount:-"+order.getAmount();
		EmailSend.sendMail(loggedInUserId,from,"Order Details", description);
		mv.addObject("successMessage","MailSend");
		mv.addObject("thankyouPage",true);
		return mv;
	}
	
	@RequestMapping("/sendpswd")
	public ModelAndView sendPassword()
	{
		ModelAndView mv=new ModelAndView("home");
		Random rnd=new Random();
		long n=rnd.nextLong();
		httpSession.setAttribute("otp",n);
		String to=(String) httpSession.getAttribute("mailId");
		String description="Enter this code to create new password:"+n;
		EmailSend.sendMail(to, from,"OTP", description);
		mv.addObject("isUserEntersOTP",true);
		return mv;
	}
}
