package com.example.jasperreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jasperreport.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByName(String name);

}
