package com.halfacode.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halfacode.ecommerce.domain.Category;
import com.halfacode.ecommerce.repository.CategoryRepo;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepo cateRepo;
	
	@RequestMapping("/showCategory")
	public String addCategory(Model model) {
		
		Category category= new Category();
		model.addAttribute("addCat",category);
		
		return "addCategory";
	}

	@RequestMapping("/saveCate")
	public String save(Category category) {
		
       cateRepo.save(category);
		//model.addAttribute("category2",category2);
		
		return "redirect:/";
	}
	@GetMapping("/category")
	public String listCategory(Model model) {
		
		List<Category> listCategories=cateRepo.findAll();
		model.addAttribute("listCategories",listCategories);
		return "categories";
	}
	
}
