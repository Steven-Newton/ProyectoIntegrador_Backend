package com.javamonos.ecoinclusive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //ES UNA ENTIDAD
@Table(name = "categoria")
public class Category {
	@Id // ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //SE GENERA AUTOMÁTICAMENTE
	@Column(name = "categoria_id", unique = true, nullable = false)
	private Long categoria_id;
	private String nombre;
	public Category(Long categoria_id, String nombre) {
		super();
		this.categoria_id = categoria_id;
		this.nombre = nombre;
	}//constructor 1
	
	public Category() {
		super();
	}//constructor 2

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public Long getCategoria_id() {
		return categoria_id;
	}//getID

	@Override
	public String toString() {
		return "Category [categoria_id=" + categoria_id + ", nombre=" + nombre + "]";
	}//ToString
	
	
	
	
}//category
