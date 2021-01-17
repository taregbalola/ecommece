package com.halfacode.ecommerce.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryRestController {

	@Autowired
	private CountryRepository repoy;
	
	
	@GetMapping("/countries/list")
	public List<Country> listAll(){
		System.out.println("List All REST API INVOKEDE");
		return (List<Country>) repoy.findAll();
	}
	@PostMapping("/countries/save")
	public String save(@RequestBody Country country) {
		System.out.println(country.getName());
 
		Country countrySave= repoy.save(country);
		return String.valueOf(countrySave.getId());
	
		
	}
	
}
