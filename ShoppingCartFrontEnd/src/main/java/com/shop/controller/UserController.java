package com.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.UserDAO;
import com.shop.domain.User;

@Controller
public class UserController {
	
       @Autowired
       private User user;
       
       @Autowired
       private UserDAO userDAO;
       
       @Autowired
      HttpSession httpSession;
       
       @PostMapping("/validate")
       public ModelAndView validate(@RequestParam("uname") String emailId,@RequestParam("pswd") String password) {
    	   
    	   ModelAndView mv=new ModelAndView("home");
    	   user=userDAO.validate(emailId, password);
    	   if(user==null)
    		   mv.addObject("errorMessage","Invalid Id or Password");
    	   else {
    		   httpSession.setAttribute("welcomeMessage","Welcome "+user.getName());
    		   if(user.getRole()=='A')
    			   httpSession.setAttribute("isAdmin",true);
    	   }
    	   return mv;
       }
       
       @PostMapping("/saveUser")
       public ModelAndView saveUser(@RequestParam("email") String emailId,@RequestParam("pswd") String password,@RequestParam("rpswd") String rpassword,
    		                        @RequestParam("name") String name,@RequestParam("mobile")String mobile)
       {
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
    	   return mv;
       }
}
