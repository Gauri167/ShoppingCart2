package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.SupplierDAO;
import com.shop.domain.Supplier;

@Controller
public class SupplierController {

	private static final Logger log=LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	HttpSession httpSession;
	
	@GetMapping("/supplier/get/")
	public ModelAndView getSupplier(@RequestParam String id)
	{
		log.debug("Starting of getSupplier Method");
		ModelAndView mv=new ModelAndView("redirect:/manage_supplier");
		supplier=supplierDAO.get(id);
		mv.addObject("supplier",supplier);
		log.debug("ending of getSupplier Method");
		return mv;
	}
	
	@PostMapping("/supplier/save/")
	public ModelAndView saveSupplier(@RequestParam String id,@RequestParam String name,@RequestParam String address)
	{
		log.debug("Starting of saveSupplier Method");
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		ModelAndView mv=new ModelAndView("redirect:/manage_supplier");
		if(supplierDAO.save(supplier)==true)
		{
			mv.addObject("supplierSuccessMessage","Supplier Save");
			List<Supplier> suppliers=supplierDAO.supplierlist();
			httpSession.setAttribute("suppliers",suppliers);
		}
		else mv.addObject("supplierErrorMessage","CCould not save Supplier try again");
		log.debug("ending of saveSupplier Method");
		return mv;
	}
	@GetMapping("/supplier/edit/")
	public ModelAndView editSupplier(@RequestParam String id)
	{
		log.debug("Starting of editSupplier Method");
		ModelAndView mv=new ModelAndView("redirect:/manage_supplier");
		supplier=supplierDAO.get(id);
		mv.addObject("editSupplier",true);
		httpSession.setAttribute("selectedSupplier",supplier);
		log.debug("ending of editSupplier Method");
		return mv;
	}
	
	@GetMapping("/supplier/delete/")
	public ModelAndView deleteSupplier(@RequestParam String id)
	{
		log.debug("starting of deleteSupplier Method");
		ModelAndView mv=new ModelAndView("redirect:/manage_supplier");
		if(supplierDAO.delete(id)==true)
			mv.addObject("supplierSuccessMessage","Supplier deleted");
		else mv.addObject("supplierErrorMessage","Could not delete Supplier try again");
		log.debug("ending of deleteSupplier Method");
		return mv;
	}
	
	@GetMapping("/suppliers")
	public ModelAndView getAllSuppliers()
	{
		log.debug("starting of getAllSupplier Method");
		ModelAndView mv=new ModelAndView("redirect:/manage_supplier");
		List<Supplier> suppliers=supplierDAO.supplierlist();
		mv.addObject("suppliers",suppliers);
		log.debug("ending of getAllSupplier Method");
		return mv;
	}
}
