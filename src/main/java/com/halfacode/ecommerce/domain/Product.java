package com.halfacode.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String brand;
   private String madein;
   private float price;

   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;
   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
   List<ProductDetails> productDetails=new ArrayList<>();
  @Column(name = "main_image")
   private String mainImage;
  @Column(name = "extra_image1")
   private String extraImage1;
  @Column(name = "extra_image2")
   private String extraImage2;
  @Column(name = "extra_image3")
   private String extraImage3;
   public Product() {
   }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getMadein() {
	return madein;
}

public void setMadein(String madein) {
	this.madein = madein;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public List<ProductDetails> getProductDetails() {
	return productDetails;
}

public void setProductDetails(List<ProductDetails> productDetails) {
	this.productDetails = productDetails;
}

public void addDetails(String name,String value) {
	
	this.productDetails.add(new ProductDetails(name,value,this));
}

public String getMainImage() {
	
	if(id == null || mainImage == null)return null;
	
	return "/product-images/" + id + "/" + mainImage;
}

public void setMainImage(String mainImage) {
	this.mainImage = mainImage;
}

public String getExtraImage1() {
	
	
	if(id == null || extraImage1 == null)return null;
	
	return "/product-images/" + id + "/" + extraImage1;
	
}

public void setExtraImage1(String extraImage1) {
	this.extraImage1 = extraImage1;
}

public String getExtraImage2() {

	if(id == null || extraImage2 == null)return null;
	
	return "/product-images/" + id + "/" + extraImage2;
}

public void setExtraImage2(String extraImage2) {
	this.extraImage2 = extraImage2;
}

public String getExtraImage3() {

	if(id == null || extraImage3 == null)return null;
	
	return "/product-images/" + id + "/" + extraImage3;
}

public void setExtraImage3(String extraImage3) {
	this.extraImage3 = extraImage3;
}
  
   
}