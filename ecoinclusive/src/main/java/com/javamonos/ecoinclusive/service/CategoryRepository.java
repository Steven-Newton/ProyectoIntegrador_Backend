package com.javamonos.ecoinclusive.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamonos.ecoinclusive.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
