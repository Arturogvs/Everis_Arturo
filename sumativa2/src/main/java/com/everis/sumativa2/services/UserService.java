package com.everis.sumativa2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.everis.sumativa2.models.User;
import com.everis.sumativa2.repositories.RolRepository;
import com.everis.sumativa2.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RolRepository rolRepository;

	public User ingresoUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	

	
	public User guardarUser(User user) {
		System.out.println("guardar - USER ");
		
		Long cantidad = userRepository.count();
		
		if(cantidad>0) {
			this.saveUser(user);
		}else {
			this.saveAdmin(user);
		}
		System.out.println(cantidad);
		
		return user; //pRepository.save(persona);
	}
	
	
	public User saveAdmin(User user) {
		 String hashed = BCrypt.hashpw(user.getPass(), BCrypt.gensalt());
		 user.setPass(hashed);
		 user.setRoles(rolRepository.findByNombre("ROL_ADMIN"));
		return userRepository.save(user);
	}
	
	public User saveUser(User user) {
		 String hashed = BCrypt.hashpw(user.getPass(), BCrypt.gensalt());
		 user.setPass(hashed);
		 user.setRoles(rolRepository.findByNombre("ROL_USER"));
		return userRepository.save(user);
	}
	/*
	public User saveUser(User user) {
		System.out.println("USER - SAVE USER");
		 String hashed = BCrypt.hashpw(user.getPass(),BCrypt.gensalt());
		 user.setPass(hashed);
		// user.setRoles(rolRepository.findByNombre("ROL_ADMIN"));
		try {
			 userRepository.save(user);
		} catch (Exception e) {
			System.out.println("no pude guardar");
		}
		return user; 
	}
	
	*/
	

	public List<User> listarUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public void eliminarUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	public Optional<User> buscarUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public @Valid User actualizarUser(@Valid User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	
	public boolean autenticacion(String email,String password) {
		System.out.println("Service -auth");
		User user = userRepository.findByEmail(email);
		//existencia de la persona
		if(user == null) {
			System.out.println("No hay correo asociados");
			return false;
		}else {
			if(BCrypt.checkpw(password, user.getPass())) {
				System.out.println("checkie passoword");
				return true;
				
			}else {
				System.out.println("pass mala");
				return false;
				
			}
		}
	}



	public User buscarRol(String email) {
		// TODO Auto-generated method stub
			return userRepository.findByEmail(email);
	}
	
}
