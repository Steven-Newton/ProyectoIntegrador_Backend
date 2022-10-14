package com.javamonos.ecoinclusive.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamonos.ecoinclusive.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
