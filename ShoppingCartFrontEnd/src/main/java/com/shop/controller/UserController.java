package com.shop.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
       
     /*  @RequestMapping(value="/newlogin")
   	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
   			@RequestParam(name="logout", required = false) String logout) {
   		ModelAndView mv= new ModelAndView("redirect:/login");
   		mv.addObject("title", "Login");
   		if(error!=null) {
   			mv.addObject("message", "Username and Password is invalid!");
   		}
   		if(logout!=null) {
   			mv.addObject("logout", "You have logged out successfully!");
   		}
   		return mv;
   	}
       */
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
    		   
    		   System.out.println(httpSession.getAttribute("loggedInUserId"));
    		   httpSession.setAttribute("UserClickedLogin",true);
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
    	   mv.addObject("isUserClickedLogin",true);
    	   log.debug("ending of saveUser Method");
    	   return mv;
    	   
       }
       
       @GetMapping("/myDetails")
	   public ModelAndView getMyDetails()
	   {
		   ModelAndView mv=new ModelAndView("home");
		   String loggedInUserId=(String) httpSession.getAttribute("loggedInUserId");
		   user=userDAO.get(loggedInUserId);
		   mv.addObject("userDetails",user);
		   mv.addObject("userClickedMyDetails",true);
		   return mv;
	   }
       
       @PostMapping("/forgotpswd")
       public ModelAndView frgtpassword(@RequestParam String email)
       {
    	   ModelAndView mv;
    	   List<User> users=userDAO.userlist();
    	  for(User user:users)
    	  {
    		  if(email.equals(user.getEmailId()))
    		  {
    			 mv=new ModelAndView("redirect:/sendpswd");
    			 httpSession.setAttribute("mailId",email);
    			 return mv;
    		  }
    	  }
    	   mv=new ModelAndView("home");
    	   mv.addObject("errorMessage","Invalid emailId");
    	  return mv;
       }
       
       @GetMapping("/checkOTP")
       public ModelAndView check(@RequestParam long otp)
       {
    	   ModelAndView mv=new ModelAndView("home");
    	   long n=(long) httpSession.getAttribute("otp");
    	   if(n==otp)
    	   {
    		   mv.addObject("userClickedEnternewPasswrd",true);
    		   return mv;
    	   }
    	   mv.addObject("errorMessage","Incorrect OTP try again");
    	   return mv;
       }
       
       @PostMapping("/newpswd")
       public ModelAndView newPassword(@RequestParam String password,@RequestParam String cnfrmpswd)
       {
    	   ModelAndView mv=new ModelAndView("home");
    	   if(password.equals(cnfrmpswd))
    	   {
    		   String email=(String) httpSession.getAttribute("mailId");
    		   user.setEmailId(email);
    		   user.setPassword(password);
    		   if(userDAO.update(user)==true)
    		   {
    			   mv.addObject("isUserClickedLogin",true);
    			   return mv;
    		   }
    	   }
    	   mv.addObject("errorMessage","Invalid Password Please Try Again");
    	   return mv;
       }
}
