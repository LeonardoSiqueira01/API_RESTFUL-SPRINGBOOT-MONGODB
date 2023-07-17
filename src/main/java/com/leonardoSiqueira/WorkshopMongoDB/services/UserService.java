package com.leonardoSiqueira.WorkshopMongoDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardoSiqueira.WorkshopMongoDB.domain.User;
import com.leonardoSiqueira.WorkshopMongoDB.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
