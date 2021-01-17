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
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 45,nullable = false,unique = true)
	private String name;
	@Column(length = 64,nullable = true)
	private String logo;
	@OneToMany
	@JoinColumn(name = "brand_id")
	private List<Category>categories= new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String getLogo() {
		if(logo == null || id == null) return null;
		return "/brand-logos/" + id+ "/" + logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Transient
	public String getLogoImagePath() {
		if(logo == null || id == null) return null;
		return "/brand-logos/" + id+ "/" + logo;
	}
	
	
}
