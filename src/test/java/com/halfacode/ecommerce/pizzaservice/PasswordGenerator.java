package com.halfacode.ecommerce.pizzaservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String rowPass="0912658511";
		String encoderPassword= encoder.encode(rowPass);
		System.out.println(encoderPassword);
		

	}
}
