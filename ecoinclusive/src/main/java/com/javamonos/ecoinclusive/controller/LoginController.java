/**
 * 
 */
package com.javamonos.ecoinclusive.controller;
import com.javamonos.ecoinclusive.jwt.config.JwtFilter;
import com.javamonos.ecoinclusive.model.Token;
import com.javamonos.ecoinclusive.model.User;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javamonos.ecoinclusive.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Steven
 *
 */
@RestController
@RequestMapping(path = "/api/login/")
public class LoginController {
	private final UserService userService;
	/**
	 * @param usuarioservice
	 */
	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public Token login (@RequestParam (required = true) String email,
			@RequestParam (required = true) String password) throws ServletException {
		if(userService.validaUsuario(email,password)) {
			return new Token(generateToken(email));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos");
	}//login
	
	private String generateToken(String email) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(email).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	}// generateToken

}