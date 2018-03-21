package com.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.SupplierDAO;
import com.shop.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	HttpSession httpSession;
	
	@GetMapping("/supplier/get/{id}")
	public ModelAndView getSupplier(@RequestParam("id") String id)
	{
		ModelAndView mv=new ModelAndView("home");
		supplier=supplierDAO.get(id);
		mv.addObject("supplier",supplier);
		return mv;
	}
	
	@PostMapping("/supplier/save/")
	public ModelAndView saveSupplier(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("address") String address)
	{
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		ModelAndView mv=new ModelAndView("home");
		if(supplierDAO.save(supplier)==true)
		{
			mv.addObject("supplierSuccessMessage","Supplier Save");
			List<Supplier> suppliers=supplierDAO.supplierlist();
			httpSession.setAttribute("suppliers",suppliers);
		}
		else mv.addObject("supplierErrorMessage","CCould not save Supplier try again");
		return mv;
	}
	
	@PutMapping("/supplier/update/")
	public ModelAndView updateSupplier(@RequestBody Supplier supplier)
	{
		ModelAndView mv=new ModelAndView("home");
		if(supplierDAO.update(supplier)==true)
			mv.addObject("supplierSuccessMessage","Supplier Updated");
		else mv.addObject("supplierErrorMessage","Could not update Supplier try again");
		return mv;
	}
	
	@DeleteMapping("/supplier/delete/{id}")
	public ModelAndView deleteSupplier(@RequestParam("id") String id)
	{
		ModelAndView mv=new ModelAndView("home");
		if(supplierDAO.delete(id)==true)
			mv.addObject("supplierSuccessMessage","Supplier deleted");
		else mv.addObject("supplierErrorMessage","Could not delete Supplier try again");
		return mv;
	}
	
	/*@GetMapping("/categories")
	public ModelAndView getAllCategories()
	{
		ModelAndView mv=new ModelAndView("home");
		List<Supplier> suppliers=supplierDAO.supplierlist();
		mv.addObject("suppliers",suppliers);
		return mv;
	}*/
}
