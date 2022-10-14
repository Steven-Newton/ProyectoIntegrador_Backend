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

import com.javamonos.ecoinclusive.model.Carrito;
import com.javamonos.ecoinclusive.service.CarritoService;

@RestController
@RequestMapping(path="/api/carrito/")
public class CarritoController {
	private final CarritoService carritoService;
	@Autowired
	public CarritoController(CarritoService carritoService) {
		super();
		this.carritoService = carritoService;
	}//constructorCarrito
	
	@GetMapping
	public List<Carrito> getAllCarrito(){
		return carritoService.getCarritos();
	}//getAllCarrito
	
	@GetMapping(path = "{carritoId}")
	public Carrito getCarrito(@PathVariable("carritoId") Long carrito_id) {
		return carritoService.getCarrito(carrito_id);
	}//getCarrito
	
	@DeleteMapping(path = "{carritoId}") // http://localhost:8080/api/carrito/1
	public Carrito deleteCategory(@PathVariable("carritoId") Long carrito_id){
		return carritoService.deleteCarrito(carrito_id);
	}//deleteCarrito
	
	@PostMapping
	public Carrito addCarrito (@RequestBody Carrito carrito) {
		return carritoService.addCarrito(carrito);
	}//addCarrito
	
	@PutMapping(path = "{carritoId}")
	public Carrito updateCcarrito (@PathVariable("carritoId") Long carrito_id,
			@RequestParam (required = false) String email, 
			@RequestParam (required = false) Long product_id )
{
		return carritoService.updateCarrito(carrito_id, email, product_id);
	}//upDateCarrito

	
}//CarritoCotroller
