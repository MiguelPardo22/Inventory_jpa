package com.app.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.DetalleCompra;


@Repository
public interface Detalle_CompraRepository extends JpaRepository <DetalleCompra, Integer> {

}






