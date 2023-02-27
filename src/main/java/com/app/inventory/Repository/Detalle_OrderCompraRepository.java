package com.app.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Detalle_OrderCompra;

@Repository
public interface Detalle_OrderCompraRepository extends JpaRepository<Detalle_OrderCompra, Long>{

}
