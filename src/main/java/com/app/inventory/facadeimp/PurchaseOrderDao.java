package com.app.inventory.facadeimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.Dto.PurchaseOrderDTO;
import com.app.inventory.Repository.Detalle_OrderCompraRepository;
import com.app.inventory.Repository.Purchase_OrderRepository;
import com.app.inventory.facade.IPurchaseOrder;
import com.app.inventory.model.Detalle_OrderCompra;
import com.app.inventory.model.Purchaseorder;

@Service
public class PurchaseOrderDao implements IPurchaseOrder {

	@Autowired
	Purchase_OrderRepository purorderrepo;

	@Autowired
	Detalle_OrderCompraRepository detorcomrepo;

	@Override
	public List<Purchaseorder> EncontrarPurchaseOrder() {
		return purorderrepo.findAll();
	}

	@Override
	public Optional<Purchaseorder> getOne(Long id_orden_compra) {
		return purorderrepo.findById(id_orden_compra);
	}

	@Override
	public Purchaseorder finById(Long id_orden_compra) {
		return purorderrepo.getReferenceById(id_orden_compra);
	}

	@Override
	public void create(Purchaseorder purchaseorder) {
		 this.purorderrepo.save(purchaseorder);
	}

	@Override
	public void update(Purchaseorder purchaseorder) {
		this.purorderrepo.save(purchaseorder);
	}

	@Override
	public void delete(Purchaseorder purchaseorder) {

		Purchaseorder puror = purorderrepo.getById(purchaseorder.getId_orden_compra());
		purorderrepo.save(puror);

	}

	@Override
	public Purchaseorder guardar(PurchaseOrderDTO purchaseOrderDTO) {
  
		//Map<String, String> salida = new HashMap<>();
		
		Purchaseorder purorder = new Purchaseorder(purchaseOrderDTO.getFecha(),
				purchaseOrderDTO.getTotal(),
				purchaseOrderDTO.getId_Supplier_fk());

		Detalle_OrderCompra detordercom = new Detalle_OrderCompra();
		detordercom.setId_PurchaseOrder_fk(purorder);
		detordercom.setCan(purchaseOrderDTO.getCan());
		detordercom.setSubTot(purchaseOrderDTO.getSubTot());
		detordercom.setId_prod_fk(purchaseOrderDTO.getId_prod_fk());
		
		
		this.detorcomrepo.save(detordercom);
		return purorderrepo.save(purorder);
	}
}
