package com.javamonos.ecoinclusive.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javamonos.ecoinclusive.model.User;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	public User getUser(String email) {
		return userRepository.findById(email).orElseThrow(() -> new IllegalArgumentException
				("El Usuario con este email " + email + " no existe.")
				);
	}
	
	public User deleteUser (String email) {
		User tmpUser = null;
		if (userRepository.existsById(email)) {
			tmpUser = userRepository.findById(email).get();
			userRepository.deleteById(email);
		}//if exist
		return tmpUser;
	}
	
	public User addUser (User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(String email, String nombre, String telefono, String contrasena) {
		User tmpUser = null;
		if (userRepository.existsById(email)) {
			tmpUser = userRepository.findById(email).get();
		if (nombre!=null) tmpUser.setNombre(nombre);
		if (telefono!=null) tmpUser.setTelefono(telefono);
		if (contrasena!=null) tmpUser.setContrasena(contrasena);
		userRepository.save(tmpUser);
	} else {
		System.out.println("Update - El Usuario con el email" + email + "no existe");
	}//else
	return tmpUser;
	}//if exist
}
