package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "SELECT * FROM product where producto.estado = 'Activo'",
			nativeQuery = true)
	List<Product> ListProduct();
	
}
