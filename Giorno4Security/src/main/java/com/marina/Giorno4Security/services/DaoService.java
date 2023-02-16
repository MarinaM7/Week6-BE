package com.marina.Giorno4Security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marina.Giorno4Security.entities.Role;
import com.marina.Giorno4Security.entities.User;
import com.marina.Giorno4Security.repos.RoleRepo;
import com.marina.Giorno4Security.repos.UserRepo;


@Service
public class DaoService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public Optional<User> getUserById(int id) {
		return userRepo.findById(id);
	}
	
	public User saveUser(User obj) {
		return userRepo.save(obj);
	}
	
	public Role saveRole(Role obj) {
		return roleRepo.save(obj);
	}
}
