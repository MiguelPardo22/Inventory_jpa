package com.app.inventory.Dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.inventory.model.Detalle_OrderCompra;
import com.app.inventory.model.Product;
import com.app.inventory.model.Purchaseorder;
import com.app.inventory.model.Supplier;

public class PurchaseOrderDTO {

	private long id_PurchaseOrder_fk;
	private int Can;
	private int SubTot;
	private int Total;
	private Product id_prod_fk;
	private Purchaseorder purchaseorder; 
	private Detalle_OrderCompra detalle_OrderCompra; 
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Fecha;
	
	private Supplier id_Supplier_fk;

	public long getId_PurchaseOrder_fk() {
		return id_PurchaseOrder_fk;
	}

	public void setId_PurchaseOrder_fk(long id_PurchaseOrder_fk) {
		this.id_PurchaseOrder_fk = id_PurchaseOrder_fk;
	}

	public int getCan() {
		return Can;
	}

	public void setCan(int can) {
		Can = can;
	}



	public int getSubTot() {
		return this.Can * this.id_prod_fk.getPre_comp();
	}



	public void setSubTot(int subTot) {
		SubTot = subTot;
	}



	public int getTotal() {
		return this.Total += this.getSubTot();
	}



	public void setTotal(int total) {
		Total = total;
	}



	public Product getId_prod_fk() {
		return id_prod_fk;
	}



	public void setId_prod_fk(Product id_prod_fk) {
		this.id_prod_fk = id_prod_fk;
	}



	public Purchaseorder getPurchaseorder() {
		return purchaseorder;
	}



	public void setPurchaseorder(Purchaseorder purchaseorder) {
		this.purchaseorder = purchaseorder;
	}



	public Detalle_OrderCompra getDetalle_OrderCompra() {
		return detalle_OrderCompra;
	}



	public void setDetalle_OrderCompra(Detalle_OrderCompra detalle_OrderCompra) {
		this.detalle_OrderCompra = detalle_OrderCompra;
	}



	public Date getFecha() {
		return Fecha;
	}



	public void setFecha(Date fecha) {
		Fecha = fecha;
	}



	public Supplier getId_Supplier_fk() {
		return id_Supplier_fk;
	}



	public void setId_Supplier_fk(Supplier id_Supplier_fk) {
		this.id_Supplier_fk = id_Supplier_fk;
	}

	public PurchaseOrderDTO(long id_PurchaseOrder_fk, int can, int subTot, int total,
			Product id_prod_fk, Detalle_OrderCompra detalle_OrderCompra, Date fecha,
			Supplier id_Supplier_fk) {
		super();
		this.id_PurchaseOrder_fk = id_PurchaseOrder_fk;
		Can = can;
		SubTot = subTot;
		Total = total;
		this.id_prod_fk = id_prod_fk;
		this.detalle_OrderCompra = detalle_OrderCompra;
		Fecha = fecha;
		this.id_Supplier_fk = id_Supplier_fk;
	}

	public PurchaseOrderDTO(long id_PurchaseOrder_fk, int can, int subTot, int total, Product id_prod_fk) {
		super();
		this.id_PurchaseOrder_fk = id_PurchaseOrder_fk;
		Can = can;
		SubTot = subTot;
		Total = total;
		this.id_prod_fk = id_prod_fk;
	}

	public PurchaseOrderDTO(Date fecha, Supplier id_Supplier_fk) {
		super();
		Fecha = fecha;
		this.id_Supplier_fk = id_Supplier_fk;
	}

	public PurchaseOrderDTO() {
		super();
	}
	
}