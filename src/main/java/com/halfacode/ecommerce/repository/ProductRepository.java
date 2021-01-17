package com.halfacode.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.halfacode.ecommerce.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
