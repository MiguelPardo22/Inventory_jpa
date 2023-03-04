package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long> {

	@Query(value = "SELECT * FROM medida where medida.estado = 'Activo'",
			nativeQuery = true)
	List<Measure> ListMedida();
	
}
