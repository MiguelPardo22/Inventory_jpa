package com.app.inventory.Dto;

import com.app.inventory.model.DetalleCompra;
import com.app.inventory.model.Product;

public class InventoryDTO {

	private long id_inventario;
	private Product id_prod_fk; 
	private DetalleCompra id_det_com_fk; 
	//private Sale id_ven_fk;
	private long exis;
	private int Can;
	public long getId_inventario() {
		return id_inventario;
	}
	public void setId_inventario(long id_inventario) {
		this.id_inventario = id_inventario;
	}
	public Product getId_prod_fk() {
		return id_prod_fk;
	}
	public void setId_prod_fk(Product id_prod_fk) {
		this.id_prod_fk = id_prod_fk;
	}
	public DetalleCompra getId_det_com_fk() {
		return id_det_com_fk;
	}
	public void setId_det_com_fk(DetalleCompra id_det_com_fk) {
		this.id_det_com_fk = id_det_com_fk;
	}
	public long getExis() {
		return exis;
	}
	public void setExis(long exis) {
		this.exis = exis;
	}
	public int getCan() {
		return Can;
	}
	public void setCan(int can) {
		Can = can;
	}
	
}
