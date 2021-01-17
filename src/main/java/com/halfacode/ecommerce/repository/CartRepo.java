package com.halfacode.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.halfacode.ecommerce.domain.Cart;
import com.halfacode.ecommerce.domain.User;

public interface CartRepo extends JpaRepository<Cart, Long>{

	//public List<Cart> findCustomerByName(User user);
}
