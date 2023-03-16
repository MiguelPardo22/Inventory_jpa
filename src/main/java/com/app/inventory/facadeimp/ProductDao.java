package com.app.inventory.facadeimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.Repository.ProductRepository;
import com.app.inventory.facade.IProduct;
import com.app.inventory.model.Product;
import com.app.inventory.model.User;

@Service
public class ProductDao implements IProduct{

	@Autowired
	ProductRepository prorepo;
	
	@Override
	public List<Product> EncontrarProduct() {
		return prorepo.ListProduct();
	}

	@Override
	public Optional<Product> getOne(Long id_prod) {
		return prorepo.findById(id_prod);
	}

	@Override
	public Product finById(Long id_prod) {
		return prorepo.getReferenceById(id_prod);
	}

	@Override
	public void create(Product product) {
		product.setImp(product.getImp());
		this.prorepo.save(product);
	}

	@Override
	public void update(Product product) {
		this.prorepo.save(product);
		
	}

	@Override
	public void delete(Product product) {
		Product pro = this.prorepo.getById(product.getId_prod());
		this.prorepo.save(pro);
	}

}
