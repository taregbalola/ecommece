package com.halfacode.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.halfacode.ecommerce.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
