package com.halfacode.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.halfacode.ecommerce.domain.Cart;
import com.halfacode.ecommerce.domain.User;
import com.halfacode.ecommerce.repository.CartRepo;
import com.halfacode.ecommerce.repository.UserRepository;
import com.halfacode.ecommerce.service.MyUserDetailService;
import com.halfacode.ecommerce.service.ShoppingCartService;

@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MyUserDetailService userDetails;
	@GetMapping("/cart")
	public String shoppingCart(Model model) {
		
	    
	     List<Cart> listCart= cartRepo.findAll();
	     
	     model.addAttribute("cartItems", listCart);
		model.addAttribute("pageTitle","shopping cart");
		return"shopping_cart";
	}
}
