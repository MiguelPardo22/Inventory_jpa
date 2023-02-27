package com.app.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
