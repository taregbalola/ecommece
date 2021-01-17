package com.halfacode.ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private Long id;
	private String name;
	private String email;
	private String password;
}
