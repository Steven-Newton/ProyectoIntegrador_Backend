package com.javamonos.ecoinclusive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.javamonos.ecoinclusive.model.Product;
import com.javamonos.ecoinclusive.service.ProductService;

@RestController
@RequestMapping(path="/api/products")
public class ProductController {	
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService; 
	}//constructor
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getProducts();
	}//getAllProducts
	
	@GetMapping(path = "{prodId}")
	public Product getProduct(@PathVariable("prodId") Long producto_id){
		return productService.getProduct(producto_id);
	}//getAllProduct
	
	@DeleteMapping(path = "{prodId}") // http://localhost:8080/api/productos/1
	public Product deleteProduct(@PathVariable("prodId") Long producto_id){
		return productService.deleteProduct(producto_id);
	}//deleteProduct
	
	@PostMapping
	public Product addProduct (@RequestBody Product product) {
		return productService.addProduct(product);
	}//addProducto
	
	@PutMapping(path = "{prodId}")
	public Product updateProduct (@PathVariable("prodId") Long producto_id,
			@RequestParam (required = false) String titulo,
			@RequestParam (required = false) Double precio,
			@RequestParam (required = false) String descripcion,
			@RequestParam (required = false) String categoria_id,
			@RequestParam (required = false) String imagen,
			@RequestParam (required = false) String sku,
			@RequestParam (required = false) Integer descuento)
{
		return productService.updateProduct(producto_id, titulo, precio, descripcion, categoria_id, imagen, sku, descuento);
	}//updateProducto

}//ProductController
