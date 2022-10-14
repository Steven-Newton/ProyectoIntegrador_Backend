package com.javamonos.ecoinclusive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="carrito")
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // genera automáticamente
	@Column(name="id", unique=true, nullable=false)
	private Long id_compras;
//	@OneToMany(targetEntity=User.class)
	private String user_id;
//	@OneToMany(targetEntity=Product.class)
	private Long product_id;
	
	public Carrito(Long id_compras, String user_id, Long product_id) {
		super();
		this.id_compras = id_compras;
		this.user_id = user_id;
		this.product_id = product_id;
	}
	public Carrito() {
		
	}// constructor vacio 
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public Long getId_compras() {
		return id_compras;
	}// gettsett
	
	@Override
	public String toString() {
		return "Carrito [id_compras=" + id_compras + ", user_id=" + user_id + ", product_id=" + product_id + "]";
	}//tostring
}// constructor 


