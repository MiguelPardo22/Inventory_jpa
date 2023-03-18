package com.app.inventory.facade;

import java.util.List;
import java.util.Optional;

import com.app.inventory.Dto.PurchaseOrderDTO;
import com.app.inventory.model.Purchaseorder;

public interface IPurchaseOrder {

	public List<Purchaseorder> EncontrarPurchaseOrder();
	public Optional<Purchaseorder> getOne(Long id_orden_compra);
	public Purchaseorder finById(Long id_orden_compra);
	public void create(Purchaseorder purchaseorder);
	public void update(Purchaseorder purchaseorder);
	public void delete(Purchaseorder purchaseorder);
	public Purchaseorder guardar(PurchaseOrderDTO purchaseOrderDTO, String from, String to, String subject, String body);
	
}
