package com.shop.utility;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MacIpAddress {
	
	@Autowired
	private HttpSession httpSession;

	@RequestMapping("/generateIp")
	public ModelAndView address()
	{
		ModelAndView mv=new ModelAndView("redirect:/saveUser");
		InetAddress ip;
		try {
			ip=InetAddress.getLocalHost();
			System.out.println("CurrentIpAddress:-  "+ip.getHostAddress());
			NetworkInterface network=NetworkInterface.getByInetAddress(ip);
			byte mac[]=network.getHardwareAddress();
			System.out.print("Current Mac Address:-  ");
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<mac.length;i++)
			{
				sb.append(String.format("%02X%S",mac[i],(i<mac.length-1)?"-":""));
			}
			System.out.println(sb.toString());
			String macAdd=sb.toString();
			httpSession.setAttribute("ip",ip);
			httpSession.setAttribute("mac",macAdd);
			return mv;
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/*InetAddress ip;
	String ipAdd;
	
	public String ipAddress()
	{
		
		try {
			ip=InetAddress.getLocalHost();
			ipAdd=ip.getHostAddress();
			System.out.println("CurrentIpAddress:-  "+ipAdd);
			return ipAdd;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ipAdd;
		
	}
	
	public String macAddress()
	{
		NetworkInterface network=NetworkInterface.getByInetAddress(ip);
		byte mac[]=network.getHardwareAddress();
	}*/
}
