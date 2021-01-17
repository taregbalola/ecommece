package com.halfacode.ecommerce.pizzaservice;

import java.util.Scanner;

public class PrimeOrNot {

	public static void main(String[] args) {
	Scanner input= new Scanner(System.in);
		System.out.println("ENTER YOUR NUMBER");
		int x= input.nextInt();
		int j=0;
		try {
		for(int i=2; i<x;i++) {
		   if(x % i==0)
			   j=1;
		
		}if(j==1) {
			throw new ArithmeticException(); 
		   }
		   else {
			   System.out.println("prime");
		   }
		
		}catch (Exception e) {
			 System.out.println("no prime");
		}
	}
}


