package com.app.inventory.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Detalle_OrdenCompra")
public class Detalle_OrderCompra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Detalle_OrderCompra;
	
	@Column(name="Cantidad",length=40)
	private int Can;
	
	@ManyToOne
	@JoinColumn(name="id_prod_fk", referencedColumnName = "id_prod")
	private Product id_prod_fk; 
	
	@Column(name="SubTotal",length=40)
	private int SubTot;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_PurchaseOrder_fk", referencedColumnName = "id_orden_compra")
	private Purchaseorder id_PurchaseOrder_fk;

	public long getId_Detalle_OrderCompra() {
		return id_Detalle_OrderCompra;
	}

	public void setId_Detalle_OrderCompra(long id_Detalle_OrderCompra) {
		this.id_Detalle_OrderCompra = id_Detalle_OrderCompra;
	}

	public int getCan() {
		return Can;
	}

	public void setCan(int can) {
		Can = can;
	}

	public Product getId_prod_fk() {
		return id_prod_fk;
	}

	public void setId_prod_fk(Product id_prod_fk) {
		this.id_prod_fk = id_prod_fk;
	}

	public int getSubTot() {
		return SubTot;
	}

	public void setSubTot(int subTot) {
		SubTot = subTot;
	}

	public Purchaseorder getId_PurchaseOrder_fk() {
		return id_PurchaseOrder_fk;
	}

	public void setId_PurchaseOrder_fk(Purchaseorder id_PurchaseOrder_fk) {
		this.id_PurchaseOrder_fk = id_PurchaseOrder_fk;
	}

	public Detalle_OrderCompra(long id_Detalle_OrderCompra, int can, Product id_prod_fk, int subTot,
			Purchaseorder id_PurchaseOrder_fk) {
		super();
		this.id_Detalle_OrderCompra = id_Detalle_OrderCompra;
		Can = can;
		this.id_prod_fk = id_prod_fk;
		SubTot = subTot;
		this.id_PurchaseOrder_fk = id_PurchaseOrder_fk;
	}

	public Detalle_OrderCompra(int can, Product id_prod_fk, int subTot, Purchaseorder id_PurchaseOrder_fk) {
		super();
		Can = can;
		this.id_prod_fk = id_prod_fk;
		SubTot = subTot;
		this.id_PurchaseOrder_fk = id_PurchaseOrder_fk;
	}

	public Detalle_OrderCompra() {
		super();
	}
	
}