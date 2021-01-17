package com.halfacode.ecommerce.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig  implements WebMvcConfigurer{

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path brandUploadDir= Paths.get("./brand-logos");
		String brandUploadPath= brandUploadDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/brand-logos/**").addResourceLocations("file:/" + brandUploadPath + "/");
		
		Path productUploadDir= Paths.get(".product-images");
		String productUploadPath= productUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/product-images/**").addResourceLocations("file:/" + productUploadPath + "/");
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slfr= new SessionLocaleResolver();
		slfr.setDefaultLocale(Locale.US);
		return slfr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci= new LocaleChangeInterceptor();
		
		lci.setParamName("lang");
		return lci;
		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
