package com.app.inventory.facade;

import java.util.List;
import java.util.Optional;

import com.app.inventory.Dto.PurchaseDTO;
import com.app.inventory.model.Purchase;


public interface IPurchase {

	public List<Purchase> EncontrarPurchaseOrder();
	public Optional<Purchase> getOne(Long id_com);
	public Purchase finById(Long id_com);
	public void create(Purchase purchase);
	public void update(Purchase purchase);
	public void delete(Purchase purchase);
	public Purchase guardar(PurchaseDTO purchaseDTO);
	
}
