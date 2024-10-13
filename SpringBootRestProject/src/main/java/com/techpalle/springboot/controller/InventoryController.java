package com.techpalle.springboot.controller;

import java.util.List;

//import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techpalle.springboot.entity.Product;
import com.techpalle.springboot.service.InventoryService;
@RestController
@RequestMapping("/api/v1")
public class InventoryController {
	private final InventoryService service;
	
	@Autowired
	public InventoryController(InventoryService service)
	{
		this.service=service;
	}
	
	// crud operations
	// 1.insert one row
	
	@PostMapping("/saveproduct")
	public ResponseEntity<Product> saveproduct(@RequestBody Product p)
	{
		Product obj=service.saveProduct(p);
		return ResponseEntity.ok(obj);
	}
	// 2.Read all products
	@GetMapping("/getproducts")
	public List<Product> getproduct()
	{
		List<Product>products=service.readAllProduct();
		return products;
	}
	
	//3.update a product  based on id	
	@PutMapping("/updateproduct/{pno}")
	public Product updateProduct(@PathVariable int pno,@RequestBody Product np)
	{
		return service.updateproduct(pno, np);
	}
	
	
	
	
	// 4.delete operations
	@DeleteMapping("/deleteproduct/{pno}")
	public void deleteProduct(@PathVariable int pno)
	{
		service.delteProduct(pno);
	}

}
