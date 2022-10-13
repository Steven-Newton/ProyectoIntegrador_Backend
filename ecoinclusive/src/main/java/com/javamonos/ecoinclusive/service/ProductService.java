package com.javamonos.ecoinclusive.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamonos.ecoinclusive.model.Product;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}//constructor
	
	public List<Product>  getProducts(){
		return productRepository.findAll();
	}//getProducts
	
	public Product getProduct(Long producto_id){
		return productRepository.findById(producto_id).orElseThrow(() -> new IllegalArgumentException
				("El Producto con el id " + producto_id + " no existe.")
				);
	}//getProduct
	
	public Product deleteProduct (Long producto_id) {
		Product tmpProd = null;
		if (productRepository.existsById(producto_id)) {
			tmpProd = productRepository.findById(producto_id).get();
			productRepository.deleteById(producto_id);
		}//if exist
		return tmpProd;
	}//deleteProduct
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}//addProduct
	
	public Product updateProduct(Long producto_id, String titulo,Double precio,
			String descripcion, String categoria_id, String imagen, String sku, Integer descuento) {
		Product tmpProd = null;
		if (productRepository.existsById(producto_id)) {
			tmpProd = productRepository.findById(producto_id).get();
		if (titulo!=null) tmpProd.setTitulo(titulo);
		if (precio!=null) tmpProd.setPrecio(precio.doubleValue());
		if (descripcion!=null) tmpProd.setDescripcion(descripcion);
		if (categoria_id!=null) tmpProd.setCategoria_id(categoria_id);
		if (imagen!=null) tmpProd.setImagen(imagen);
		if (sku!=null) tmpProd.setSku(sku);
		if (descuento!=null) tmpProd.setDescuento(descuento);
		productRepository.save(tmpProd);
	} else {
		System.out.println("Update - El Producto con el id" + producto_id + "no existe");
	}//else
	return tmpProd;
	}//if exist

}//ProductService
