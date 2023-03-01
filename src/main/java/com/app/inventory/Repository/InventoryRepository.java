package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	@Query ( value = "select id_inventario, sum(existencias) as existencias, count(id_det_com_fk) as id_det_com_fk, id_det_ped_fk, id_prod_fk from inventario group by id_prod_fk;",
			nativeQuery = true
			)
	List<Inventory> stock();
}
