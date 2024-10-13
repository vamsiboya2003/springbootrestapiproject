package com.techpalle.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techpalle.springboot.entity.Product;
@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {

	

}
