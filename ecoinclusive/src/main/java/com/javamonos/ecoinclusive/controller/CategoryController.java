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
import com.javamonos.ecoinclusive.model.Category;
import com.javamonos.ecoinclusive.service.CategoryServices;

@RestController
@RequestMapping(path="/api/categories/")
public class CategoryController {
	private final CategoryServices categoryServices;
	
	@Autowired
	public CategoryController(CategoryServices categoryServices) {
		super();
		this.categoryServices = categoryServices;
	}//constructor
	
	@GetMapping
	public List<Category> getAllCategory(){
		return categoryServices.getCategory();
	}//getAllCategories
	
	@GetMapping(path = "{cateId}")
	public Category getCategory(@PathVariable("cateId") Long categoria_id) {
		return categoryServices.getCategory(categoria_id);
	}//getCategoria Singular
	
	@DeleteMapping(path = "{cateId}") // http://localhost:8080/api/category/1
	public Category deleteCategory(@PathVariable("cateId") Long categoria_id){
		return categoryServices.deleteCategory(categoria_id);
	}//deleteCategory
	
	@PostMapping
	public Category addCategory (@RequestBody Category categoria) {
		return categoryServices.addCategory(categoria);
	}//addCategory
	
	@PutMapping(path = "{cateId}")
	public Category updateCategory (@PathVariable("cateId") Long categoria_id,
			@RequestParam (required = false) String nombre)
{
		return categoryServices.updateCategory(categoria_id, nombre);
	}//upDateCategory

}//CategoryController
