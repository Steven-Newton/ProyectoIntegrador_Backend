package com.javamonos.ecoinclusive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javamonos.ecoinclusive.model.Carrito;

@Service
public class CarritoService {
	private final CarritoRepository carritoRepository;

	@Autowired
	public CarritoService(CarritoRepository carritoRepository) {
		super();
		this.carritoRepository = carritoRepository;
	}
	
	public List<Carrito> getCarritos(){
		return carritoRepository.findAll();
	}//getcarritos
	
	public Carrito getCarrito(Long id) {
		return carritoRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Carrito con el id" + id +"no existe")
			);
	}//getcarrito
	
	public Carrito deleteCarrito (Long id) {
		Carrito tmpCar = null;
		if (carritoRepository.existsById(id)) {
			tmpCar = carritoRepository.findById(id).get();
			carritoRepository.deleteById(id);
			}//if exist
		return tmpCar;
		}//delete carrito
	
	public Carrito addCarrito(Carrito carrito) {
		return carritoRepository.save(carrito);
	}// add Carrito

	public Carrito updateCarrito(Long id, String email, Long producto ) {
			Carrito tmpCar = null;
			if (carritoRepository.existsById(id)) {
				tmpCar = carritoRepository.findById(id).get();
				if (email!= null) tmpCar.setUser_id(email);
				if (producto!= null) tmpCar.setProduct_id(producto);
				carritoRepository.save(tmpCar);
				} else{
					System.out.println("Update - El Carrito con el id "+ id + "no existe.");
				}//if exist
			return tmpCar;
			}//updateCarrito
	
}
