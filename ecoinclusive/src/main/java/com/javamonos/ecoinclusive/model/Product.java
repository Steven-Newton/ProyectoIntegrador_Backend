package com.javamonos.ecoinclusive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //ES UNA ENTIDAD
@Table(name = "producto") //ESTABLECIENDO EL NOMBRE DE LA TABLA EN LA BD
public class Product {
	@Id // ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //SE GENERA AUTOMÁTICAMENTE
	@Column(name = "producto_id", unique = true, nullable = false) //ÚNICO Y NO ES NULO.
	private Long producto_id; //READ-ONLY
	private String titulo;
	private double precio;
	private String descripcion;
	private String categoria_id;
	private String imagen;
	private String sku;
	private Integer descuento;
	
	
	public Product(Long producto_id, String titulo, double precio, String descripcion, String categoria_id, String imagen,
			String sku, Integer descuento) {
		super();
		this.producto_id = producto_id;
		this.titulo = titulo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.categoria_id = categoria_id;
		this.imagen = imagen;
		this.sku = sku;
		this.descuento = descuento;
	}//constructor

	
	
	public Product() {
		super();
	}//constructor2

	

	public String getTitulo() {
		return titulo;
	}//getTitulo

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}//setTitulo

	public double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(double precio) {
		this.precio = precio;
	}//setPrecio

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public String getCategoria_id() {
		return categoria_id;
	}//getCategoria

	public void setCategoria_id(String categoria_id) {
		this.categoria_id = categoria_id;
	}//setCategoria

	public String getImagen() {
		return imagen;
	}//getImagen

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen

	public String getSku() {
		return sku;
	}//getSku

	public void setSku(String sku) {
		this.sku = sku;
	}//setSku

	public Integer getDescuento() {
		return descuento;
	}//getDescuento

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}//getDescuento

	public Long getId() {
		return producto_id;
	}//getId



	@Override
	public String toString() {
		return "Product [id=" + producto_id + ", titulo=" + titulo + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", categoria_id=" + categoria_id + ", imagen=" + imagen + ", sku=" + sku + ", descuento=" + descuento + "]";
	}//ToString
	
}//Product
