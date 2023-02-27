package com.app.inventory.facade;

import java.util.List;
import java.util.Optional;

import com.app.inventory.model.Product;

public interface IProduct {

	public List<Product> EncontrarProduct();
	public Optional<Product> getOne(Long id_prod);
	public Product finById(Long id_prod);
	public void create(Product product);
	public void update(Product product);
	public void delete(Product product);
	
}
