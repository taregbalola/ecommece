package com.halfacode.ecommerce.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.halfacode.ecommerce.domain.Brand;
import com.halfacode.ecommerce.domain.Category;
import com.halfacode.ecommerce.repository.BrandRepository;
import com.halfacode.ecommerce.repository.CategoryRepo;
import com.halfacode.ecommerce.util.FileUploadUtil;

@Controller
public class BrandController {

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@GetMapping("/brand/new")
	public String showProduct(Model model) {
		
		List<Category> categories= categoryRepo.findAll();
		model.addAttribute("categories",categories);
		
		Brand brand= new Brand();
		
		model.addAttribute("brand", brand);
		
		return "brand_form";
	}
	@GetMapping("/brands")
	public String findAll(Model model) {
		List<Brand> listBrands=brandRepository.findAll();
		model.addAttribute("listBrands",listBrands);
		return "brand";
	}

	@PostMapping("/brand/save")
	public String saveBrand(@ModelAttribute(name = "brand")Brand brand,
			RedirectAttributes ra,
			@RequestParam("fileImage") MultipartFile multipartFile) throws IOException{
		String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
		brand.setLogo(fileName);
		
		Brand saveBrand=brandRepository.save(brand);
		
		String uploadDir= "./brand-logos/" +saveBrand.getId();
		
		FileUploadUtil.saveFile(uploadDir, multipartFile, fileName);
		
		return "redirect:/";
	}
	@GetMapping("/listBrands/edit/{id}")
	public String editBrand(Model model,@PathVariable("id") Integer id) {
		
		List<Category> categories= categoryRepo.findAll();
		model.addAttribute("categories",categories);
		Brand brand=brandRepository.findById(id).get();
		model.addAttribute("brand",brand);
		return "brand_form";
	}
}
