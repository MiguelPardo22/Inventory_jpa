package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

	@Query(value = "SELECT * FROM proveedor where proveedor.estado = 'Activo'",
			nativeQuery = true)
	List<Supplier> ListSupplier();
	
}
