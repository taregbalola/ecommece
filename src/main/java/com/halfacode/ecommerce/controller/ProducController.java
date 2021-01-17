package com.halfacode.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.halfacode.ecommerce.domain.Category;
import com.halfacode.ecommerce.domain.Product;
import com.halfacode.ecommerce.repository.CategoryRepo;
import com.halfacode.ecommerce.repository.ProductRepository;
import com.halfacode.ecommerce.service.ProductService;
import com.halfacode.ecommerce.util.FileUploadUtil;

@Controller
public class ProducController {

	
	@Autowired
	private ProductService service;
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProductRepository prodRepo;
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		
		List<Category> lisCategories=categoryRepo.findAll();
		model.addAttribute("lisCategories",lisCategories);
	    Product product = new Product();
	    
	    model.addAttribute("product", product);
	     
	    return "new_product";
	}
	@PostMapping("/save")
	public String saveProduct(Product product,HttpServletRequest request,
			RedirectAttributes ra,
			@RequestParam("primaryImage")MultipartFile mainMultipartFile,
			@RequestParam("extraImage")MultipartFile[] extraMultipartFile
			) throws IOException {
	   
		String mainImage= StringUtils.cleanPath(mainMultipartFile.getOriginalFilename());
		product.setMainImage(mainImage);
		
		int count=0;
		for(MultipartFile extraMultipart : extraMultipartFile) {
			String extraImageName= StringUtils.cleanPath(extraMultipart.getOriginalFilename());
		        if(count ==0)product.setExtraImage1(extraImageName);
		        if(count ==1)product.setExtraImage2(extraImageName);
		        if(count ==2)product.setExtraImage3(extraImageName);
		        
		        count++;
		}
		
		String[] detailsName= request.getParameterValues("detailName");
		String[] detailsValue=request.getParameterValues("detailValue");
		
		for(int i=0; i<detailsName.length; i++) {
			product.addDetails(detailsName[i], detailsValue[i]);
		}
		
	  Product saveProduct=prodRepo.save(product);
	 
		
	    String uploadDir=".product-images/" + saveProduct.getId();
	    FileUploadUtil.saveFile(uploadDir, mainMultipartFile, mainImage);
	    for(MultipartFile extraMultipart : extraMultipartFile) {
			String fileName= StringUtils.cleanPath(extraMultipart.getOriginalFilename());

			FileUploadUtil.saveFile(uploadDir, extraMultipart, fileName);
	    }
	  
	    return "redirect:/listProduct";
	}
	@RequestMapping("/listProduct")
	public String viewHomePage(Model model) {
	    List<Product> listProducts = service.listAll();
	    model.addAttribute("listProducts", listProducts);
	    return "products";
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}

	@GetMapping("listProduct/edit/{id}")
	public String showEditProductForm(@PathVariable("id") Long id, Model model) {
		Product product=prodRepo.findById(id).get();
		model.addAttribute("product",product);
		
		List<Category> lisCategories=categoryRepo.findAll();
		model.addAttribute("lisCategories",lisCategories);
		return"new_product";
	}
	@GetMapping("listProduct/delete/{id}")
	public String delwteProduct(@PathVariable("id") Long id, Model model) {
		prodRepo.deleteById(id);
		return"redirect:/listProduct";
	}
	@GetMapping("/home")
	public String homePage(Model model) {
		  List<Product> listProducts = service.listAll();
		    model.addAttribute("listProducts", listProducts);
		return "home";
	}

	@GetMapping("/showcountries")
	public String showCountry() {
		return "countries";
	}
	
}
