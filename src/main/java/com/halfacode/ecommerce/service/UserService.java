package com.halfacode.ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.halfacode.ecommerce.domain.User;
import com.halfacode.ecommerce.repository.UserRepository;
@Service
@Transactional
public class UserService{
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		 userRepository.save(user);
	}
	
}
