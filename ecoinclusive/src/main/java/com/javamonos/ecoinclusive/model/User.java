package com.javamonos.ecoinclusive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //ES UNA ENTIDAD
@Table(name = "usuario")
public class User {
	@Id // ID
	@Column(name = "email", unique = true, nullable = false) //UNICO Y NO ES NULO.
	private String email; //READ-ONLY
	private String nombre;
	private String telefono;
	private String contrasena;
	
	public User(String email, String nombre, String telefono, String contrasena) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
		this.contrasena = contrasena;
	}

	public User() {
		super();
	}

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	public String getContrasena() {
		return contrasena;
	}//getcontrasena

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContrasena

	public String getEmail() {
		return email;
	}//getEmail

	@Override
	public String toString() {
		return "User [email=" + email + ", nombre=" + nombre + ", telefono=" + telefono + ", contrasena=" + contrasena
				+ "]";
	}//toString

}//User
