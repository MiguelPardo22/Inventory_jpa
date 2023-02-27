package com.app.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Purchaseorder;

@Repository
public interface Purchase_OrderRepository extends JpaRepository<Purchaseorder, Long>{

}
