package com.javamonos.ecoinclusive.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamonos.ecoinclusive.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{
	
	
}
