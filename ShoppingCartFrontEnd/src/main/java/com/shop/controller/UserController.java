package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CartDAO;
import com.shop.dao.UserDAO;
import com.shop.domain.Cart;
import com.shop.domain.User;

@Controller
public class UserController {
	
	   private static final Logger log=LoggerFactory.getLogger(UserController.class);

	
       @Autowired
       private User user;
       
       @Autowired
       private UserDAO userDAO;
       
       @Autowired
       private CartDAO cartDAO;
       
       @Autowired
       private Cart cart;
       
       @Autowired
      HttpSession httpSession;
       
       @PostMapping("/validate")
       public ModelAndView validate(@RequestParam("uname") String emailId,@RequestParam("pswd") String password) 
       {
    	   log.debug("Starting of validate Method");
    	   ModelAndView mv=new ModelAndView("home");
    	   user=userDAO.validate(emailId, password);
    	   if(user==null)
    		   mv.addObject("errorMessage","Invalid Id or Password");
    	   else {
    		   httpSession.setAttribute("welcomeMessage","Welcome "+user.getName());
    		   httpSession.setAttribute("loggedInUserId",user.getEmailId());
    		   httpSession.setAttribute("isUserClickedLogin",true);
    		   //fetch how many products added
    		   //
    		   List<Cart> carts=cartDAO.cartlist(user.getEmailId());
    		   httpSession.setAttribute("size",carts.size());
    		   httpSession.setAttribute("carts",carts);
    		   if(user.getRole()=='A')
    			   httpSession.setAttribute("isAdmin",true);
    	   }
    	   log.debug("ending of validate Method");
    	   return mv;
       }
       
       @PostMapping("/saveUser")
       public ModelAndView saveUser(@RequestParam("email") String emailId,@RequestParam("pswd") String password,@RequestParam("rpswd") String rpassword,
    		                        @RequestParam("name") String name,@RequestParam("mobile")String mobile)
       {
    	   log.debug("Starting of saveUser Method");
    	   ModelAndView mv=new ModelAndView("home");
    	   if(rpassword.equals(password))
    	   {
    		   user.setEmailId(emailId);
    		   user.setPassword(rpassword);
    		   user.setName(name);
    		   user.setMobile(mobile);
    		   
    		   if(userDAO.save(user)==true)
    			   httpSession.setAttribute("welcomeMessage","Welcome "+user.getName());
    		   else httpSession.setAttribute("errorMessage","Invalid...Please try again");
    	   }
    	   
    	   else mv.addObject("errorMessage","Password Mismatch");
    	   log.debug("ending of saveUser Method");
    	   return mv;
       }
}
