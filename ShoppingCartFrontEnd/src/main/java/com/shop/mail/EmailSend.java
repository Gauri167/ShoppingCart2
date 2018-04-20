package com.shop.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.shop.utility.EmailUtil;

public class EmailSend {
	
	@SuppressWarnings("resource")
	public static void sendMail(String to,String from,String subject,String description)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("email.xml");
		EmailUtil eutil=(EmailUtil) context.getBean("mailMail");
		eutil.sendMail(from,to,subject,description);
	}
     
	
}
