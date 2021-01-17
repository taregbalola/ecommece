package com.halfacode.ecommerce.pizzaservice;

import java.io.IOException;
import java.util.Scanner;

public class PrimeNumberAndEvent {

	public static void main(String[] args) {
		
		Scanner input= new Scanner(System.in);
		
		int no= input.nextInt();
		int temp=0;
		try {
		for(int i=2; i<=no-1;i++) {
			
			if(no%i == 0) {
				temp =temp+1;
			}
		}
		
			if(temp ==0) {
				
			}
			System.out.println("is prime");
			
				
		}catch (ArithmeticException e) {
			System.out.println("no prime");	
			e.printStackTrace();
		
		}
		
		
	}
}