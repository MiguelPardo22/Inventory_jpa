package com.app.inventory.facade;

import java.util.List;
import java.util.Optional;

import com.app.inventory.model.Supplier;

public interface ISupplier {

	public List<Supplier> EncontrarSupplier();
	public Optional<Supplier> getOne(Long id_Proveedor);
	public Supplier finById(Long id_Proveedor);
	public void create(Supplier supplier);
	public void update(Supplier supplier);
	public void delete(Supplier supplier);
	
}
