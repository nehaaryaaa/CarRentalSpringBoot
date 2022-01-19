package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.model.Car;
import com.neosoft.model.IssueCarBean;
import com.neosoft.service.IssueCarServiceImpl;

@Controller
public class IssueCarController {

	@Autowired
	private IssueCarServiceImpl issueCarServiceImpl;
	
	@GetMapping("/admin/viewissuedcars")
	public String listOwners(Model model) {
		
		model.addAttribute("issuecar",issueCarServiceImpl.getAllIssuedCar());
		
		return "view_issued_car";
	}
	
	@GetMapping("/admin/issuecars/new")
	public String createCarForm(Model model) {
		
		IssueCarBean issuecar = new IssueCarBean();
		model.addAttribute("issuecar", issuecar);
		
		return "issuecar";
	}
	
	@PostMapping("/admin/issuecar")
	public String issueCar(@ModelAttribute("issuecar") IssueCarBean car) {
		
		issueCarServiceImpl.issueCar(car);
		
		return "redirect:/admin/viewcars";
	}
	
	@GetMapping("/admin/returncar/{customerid}")
	public String  returnCar( @PathVariable String customerid) {
		long custid = Long.parseLong(customerid);
		IssueCarBean bean = issueCarServiceImpl.findByCustomerId(custid).get();
		bean.setReturnstatus("Yes");
		Car car = issueCarServiceImpl.findByCustomerId(custid).get().getCar();
		issueCarServiceImpl.updateIssueStatusAndReturnStatus(bean,car);
		return "redirect:/admin/viewissuedcars";
	}
	
	@GetMapping("/admin/generatebill/{customerid}")
	public String  generateBill(@PathVariable String customerid, Model model) {
		long custid = Long.parseLong(customerid);
		IssueCarBean bean = issueCarServiceImpl.findByCustomerId(custid).get();
		model.addAttribute("issuebean", bean );
		return "generate_bill";
	}
}
