package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.model.Owner;
import com.neosoft.service.OwnerServiceImpl;

@Controller
public class OwnerController {

	@Autowired
	private OwnerServiceImpl ownerServiceImpl;
	
	@GetMapping("/login")
	public String adminlogin() {
		return "index";
	}
	
	@GetMapping("/adminlogin")
	public String adminloginform() {
		return "admin_login";
	}
	
	@GetMapping("/logout")
	public String adminlogout() {
		return "redirect:/appLogout";
	}
	
	@GetMapping("/ownerlogin")
	public String ownerloginform(Model model) {
		model.addAttribute("authenticate",new Owner());
		return "owner_login";
	}
	
	@PostMapping("/ownerauthenticate")
	public String ownerAuthentication( @ModelAttribute("authenticate") Owner owner) {
		String email=owner.getEmail();
		String password=owner.getPassword();
		//if(ownerServiceImpl.getOwnerByEmail(email).equals(ownerServiceImpl.getOwnerByPassword(password)))
			
		//Owner auth = ownerServiceImpl.getOwnerByEmail(email);
		//String s= (auth.getPassword().equals(password))?"redirect:/owner":"redirect:/ownerlogin";
			//return s;
		String s= ownerServiceImpl.getOwnerByEmail(email).equals(ownerServiceImpl.getOwnerByPassword(password))?"redirect:/owner":"redirect:/ownerlogin";
		return s;
	}
	
	@GetMapping("/ownerlogout")
	public String ownerlogout() {
		return "redirect:/login";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/admin/owners")
	public String listOwners(Model model) {
		
		model.addAttribute("owners",ownerServiceImpl.getAllOwners());
		
		return "view_owner";
	}
	
	@GetMapping("/admin/owners/new")
	public String createOwnerForm(Model model) {
		
		Owner owner = new Owner();
		model.addAttribute("owner", owner);
		
		return "create_owner";
	}
	
	@PostMapping("/admin/owners")
	public String saveOwner(@ModelAttribute("owner") Owner owner) {
		
		ownerServiceImpl.addOwner(owner);
		
		return "redirect:/admin/owners";
	}
	
	@GetMapping("/admin/owners/edit/{id}")
	public String editOwnerForm(@PathVariable Long id, Model model) {
		
		model.addAttribute("owner",ownerServiceImpl.getOwnerById(id));
		
		return "edit_owner";
	}
	
	@PostMapping("/admin/owners/{id}")
	public String updateOwner(@PathVariable Long id, 
			@ModelAttribute("owner") Owner owner,	Model model) {
		
		Owner existingOwner = ownerServiceImpl.getOwnerById(id);
		existingOwner.setId(id);
		existingOwner.setName(owner.getName());
		existingOwner.setMobile(owner.getMobile());
		existingOwner.setEmail(owner.getEmail());
		existingOwner.setPassword(owner.getPassword());
		ownerServiceImpl.updateOwner(existingOwner);
		
		return "redirect:/admin/owners";
	}
	
	@GetMapping("/admin/owners/{id}")
	public String deleteOwner(@PathVariable Long id) {
		
		ownerServiceImpl.deleteOwnerById(id);
		
		return "redirect:/admin/owners";
	}	
}
