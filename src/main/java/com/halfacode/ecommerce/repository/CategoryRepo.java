package com.halfacode.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.halfacode.ecommerce.domain.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
