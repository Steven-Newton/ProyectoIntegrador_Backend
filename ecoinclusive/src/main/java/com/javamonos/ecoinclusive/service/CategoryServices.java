package com.javamonos.ecoinclusive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamonos.ecoinclusive.model.Category;

@Service
public class CategoryServices {
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServices(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}//constructor
	
	public List<Category> getCategory(){
		return categoryRepository.findAll();
	}//getCategorys
	
	public Category getCategory(Long categoria_id) {
		return categoryRepository.findById(categoria_id).orElseThrow(()-> new IllegalArgumentException
				("La categoria con el id " + categoria_id + " no existe."));
	}//getCategoria
	
	public Category deleteCategory(Long categoria_id) {
		Category tmpCate=null;
		if(categoryRepository.existsById(categoria_id)) {
			tmpCate=categoryRepository.findById(categoria_id).get();
			categoryRepository.deleteById(categoria_id);
		}//if exist
		return tmpCate;
	}//deleteCategory
	
	public Category addCategory(Category categoria) {
		return categoryRepository.save(categoria);
	}//addCategoria	
	
	public Category updateCategory(Long categoria_id, String nombre) {
		Category tmpCate=null;
		if(categoryRepository.existsById(categoria_id)) {
			tmpCate = categoryRepository.findById(categoria_id).get();
		if (nombre!=null) tmpCate.setNombre(nombre);
		categoryRepository.save(tmpCate);
		}
		else {
			System.out.println("Update - La categoria con el id" + categoria_id + "no existe");
		}//else
		return tmpCate;
	}//if exist
	
}//CategoryServices
