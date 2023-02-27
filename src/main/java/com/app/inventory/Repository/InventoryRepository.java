package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	@Query ( value = "select i.id_inventario, sum(i.existencias - d.cantidad) as existencias, count(i.id_det_com_fk) as id_det_com_fk, count(i.id_det_ped_fk) as id_det_ped_fk, i.id_prod_fk from inventario i join detalle_pedido d on d.id_det_ped = i.id_det_ped_fk group by id_prod_fk desc;",
			nativeQuery = true
			)
	List<Inventory> stock();
}
