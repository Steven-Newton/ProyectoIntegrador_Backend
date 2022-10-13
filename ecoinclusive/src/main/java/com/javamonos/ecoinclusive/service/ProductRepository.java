package com.javamonos.ecoinclusive.service;
import com.javamonos.ecoinclusive.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
}// interface Product
