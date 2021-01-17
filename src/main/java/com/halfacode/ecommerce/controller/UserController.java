package com.halfacode.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.halfacode.ecommerce.domain.User;
import com.halfacode.ecommerce.service.UserService;
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	/*
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Product product = new Product();
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	*/
	@RequestMapping(value="/register")
	public String addNew(Model model) {
		User user= new User();
		model.addAttribute("user",user);
		return "register";
	}
	
	@RequestMapping(value = "user/addNew", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") User user) {
	   userService.save(user);
	     
	    return "redirect:/register";
	}
	/*
	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);	
		RedirectView  redirectView= new RedirectView("/login",true);
	        redir.addFlashAttribute("message",
	    		"You successfully registered! You can now login");
	    return redirectView;				
	}
	*/
		
}
