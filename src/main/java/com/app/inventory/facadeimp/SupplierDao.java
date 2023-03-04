package com.app.inventory.facadeimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.Repository.SupplierRepository;
import com.app.inventory.facade.ISupplier;
import com.app.inventory.model.Supplier;

@Service
public class SupplierDao implements ISupplier{

	@Autowired
	SupplierRepository supplierrepo;
	
	@Override
	public List<Supplier> EncontrarSupplier() {
		return supplierrepo.ListSupplier();
	}

	@Override
	public Optional<Supplier> getOne(Long id_Proveedor) {
		return supplierrepo.findById(id_Proveedor);
	}

	@Override
	public Supplier finById(Long id_Proveedor) {
		return supplierrepo.getReferenceById(id_Proveedor);
	}

	@Override
	public void create(Supplier supplier) {
		supplierrepo.save(supplier);	
	}

	@Override
	public void update(Supplier supplier) {
		supplierrepo.save(supplier);
		
	}

	@Override
	public void delete(Supplier supplier) {
		Supplier sup = this.supplierrepo.getById(supplier.getId_Proveedor());
		supplierrepo.save(sup);
	}

}
