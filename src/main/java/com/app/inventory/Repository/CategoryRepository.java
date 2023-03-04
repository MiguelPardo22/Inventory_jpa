package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query(value = "SELECT * FROM categoria where categoria.estado = 'Activo'",
			nativeQuery = true)
	List<Category> ListCategoria();
	
}
