package com.app.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
