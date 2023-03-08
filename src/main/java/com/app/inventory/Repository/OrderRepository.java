package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query(value = "SELECT * FROM inventory_jpa.pedido where pedido.id_est_fk = 1;",
			nativeQuery = true)
	List<Order> EstadoEnProceso();
	
	@Query(value = "SELECT * FROM inventory_jpa.pedido where pedido.id_est_fk = 2;",
			nativeQuery = true)
	List<Order> EstadoPagado();
	
	@Query(value = "SELECT * FROM inventory_jpa.pedido where pedido.id_est_fk = 3;",
			nativeQuery = true)
	List<Order> EstadoSinPagar();
	
}
