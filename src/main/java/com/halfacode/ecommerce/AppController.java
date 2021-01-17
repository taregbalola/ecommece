package com.halfacode.ecommerce;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/index")
	public String goHome(Model model,HttpServletRequest request) {
		model.addAttribute("pageTitle", "Home - Shopme Admin");
		
		Locale currentLocal=request.getLocale();
		
		String countryCode = currentLocal.getCountry();
		String countryName= currentLocal.getDisplayCountry();
		
		String langCode = currentLocal.getLanguage();
		String langName= currentLocal.getDisplayLanguage();
		
		System.out.println(countryCode + ": " + countryName );
		System.out.println(langCode + ": " + langName);
		
		System.out.println("===========================");
		String[] languages = Locale.getISOLanguages();
		
		for(String language : languages) {
			Locale locale= new Locale(language);
			System.out.println(language + ": " + locale.getDisplayLanguage());
		}
		
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	/*
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	*/
}
