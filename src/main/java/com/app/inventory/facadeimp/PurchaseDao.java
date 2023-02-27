package com.app.inventory.facadeimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.Dto.PurchaseDTO;
import com.app.inventory.Repository.Detalle_CompraRepository;
import com.app.inventory.Repository.InventoryRepository;
import com.app.inventory.Repository.PurchaseRepository;
import com.app.inventory.facade.IPurchase;
import com.app.inventory.model.DetalleCompra;
import com.app.inventory.model.Inventory;
import com.app.inventory.model.Purchase;

@Service
public class PurchaseDao implements IPurchase{

	@Autowired
	PurchaseRepository purrepo;
	
	@Autowired
	Detalle_CompraRepository detrepo;
	
	@Autowired
	InventoryRepository invenrepo;
	
	@Override
	public List<Purchase> EncontrarPurchaseOrder() {
		return purrepo.findAll();
	}

	@Override
	public Optional<Purchase> getOne(Long id_com) {
		return purrepo.findById(id_com);
	}

	@Override
	public Purchase finById(Long id_com) {
		return purrepo.getReferenceById(id_com);
	}

	@Override
	public void create(Purchase purchase) {
		 purrepo.save(purchase);
		
	}

	@Override
	public void update(Purchase purchase) {
		purrepo.save(purchase);
	}

	@Override
	public void delete(Purchase purchase) {
		
		Purchase pur = purrepo.getById(purchase.getId_com());
		purrepo.save(purchase);
		
	}

	@Override
	public Purchase guardar(PurchaseDTO purchaseDTO) {
		
		Purchase pur = new Purchase(purchaseDTO.getNum_fac(),
				purchaseDTO.getTot_com(),
				purchaseDTO.getFecha(),
				purchaseDTO.getId_Supplier_fk());
		
		DetalleCompra detcom = new DetalleCompra();
		detcom.setId_Purchase_fk(pur);
		detcom.setCan(purchaseDTO.getCan());
		detcom.setId_prod_fk(purchaseDTO.getId_prod_fk());
		detcom.setSubTotal(purchaseDTO.getSubTotal());
		
		Inventory inven = new Inventory();
		
		inven.setId_det_com_fk(detcom);
		inven.setExis(purchaseDTO.getCan());
		inven.setId_prod_fk(purchaseDTO.getId_prod_fk());
		
		this.invenrepo.save(inven);
		this.detrepo.save(detcom);
		return purrepo.save(pur);
	}

}
