package com.halfacode.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halfacode.ecommerce.domain.Cart;
import com.halfacode.ecommerce.domain.User;
import com.halfacode.ecommerce.repository.CartRepo;

@Service
public class ShoppingCartService {

	
	@Autowired
	private CartRepo cartRepo;
	
	//public List<Cart> listCartItems(User user){
		
		//return cartRepo.findCustomerByName(user);
	//}
}
