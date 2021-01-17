package com.halfacode.ecommerce.pizzaservice;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


import com.halfacode.ecommerce.domain.Product;
import com.halfacode.ecommerce.domain.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ShoppingCartTests {

	//@Autowired
	//private CartItemRepository cartRepo;
	
//	@Autowired
	//private TestEntityManager entityManager;
	
	//@Test
	//public void testAddOneCartItem() {
	//Product product=entityManager.find(Product.class, 6);
	//User user=entityManager.find(User.class, 10);
	
	//CartItem newItem=new CartItem();
	//newItem.setUser(user);
	//newItem.setProduct(product);
	//newItem.setQuantity(1);
	
 // CartItem saveCartItem=cartRepo.save(newItem);
	
  
 //(saveCartItem.getId() >0);
	//assertTrue(saveCartItem.getId() >0);
	//}
	
	/*
	@Test
	public void testGetCartByCustomer() {
		
		User user= new User();
		user.setId(10);
		//List<CartItem> cartItems=cartRepo.findCustomerByName(user);
	//	assertEquals(2, cartItems.size());
		
	}
*/	
}
