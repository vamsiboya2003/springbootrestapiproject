package com.techpalle.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techpalle.springboot.entity.Product;
import com.techpalle.springboot.repository.InventoryRepository;

@Service
public class InventoryService {
	private final  InventoryRepository repository;
	
	@Autowired
	public InventoryService(InventoryRepository repository)
	{
		this.repository=repository;
	}
	
	 //1.insert a product
	public Product saveProduct(Product p)
	{
		Product obj=repository.save(p);
		return obj;
	}
	
	
	// 2.Read all products	
	public List<Product> readAllProduct()
	{
		List<Product>products=repository.findAll();
		return products;
		
	}
	
	
	//3.update a product based on id
	public Product updateproduct(int pno,Product np)
	{
		Optional<Product> temp=repository.findById(pno);
		if(temp.isPresent())
		{
			Product p=temp.get();
			p.setPname(np.getPname());
			p.setPprice(np.getPprice());
			p.setPqty(np.getPqty());
			return repository.save(p);
		}
		else
		{
			throw new RuntimeException("product not found");
		}
	}
	
	
	
	
	// 4.delete a product based on id primary key
	public void delteProduct(int pno)
	{
		repository.deleteById(pno);
	}

}
