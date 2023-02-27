package com.app.inventory.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Orden_Compra")
public class Purchaseorder implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_orden_compra;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha;
	
	@Column(name="Total",length=40)
	private int Total;
	
	@ManyToOne
	@JoinColumn(name="id_Supplier_fk", referencedColumnName = "id_Proveedor")
	private Supplier id_Supplier_fk; 
	
	@OneToMany(mappedBy = "id_PurchaseOrder_fk", cascade = CascadeType.ALL)
	private List<Detalle_OrderCompra> detalles = new ArrayList<>();

	public long getId_orden_compra() {
		return id_orden_compra;
	}

	public void setId_orden_compra(Long id_orden_compra) {
		this.id_orden_compra = id_orden_compra;
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

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public void setId_Supplier_fk(Supplier id_Supplier_fk) {
		this.id_Supplier_fk = id_Supplier_fk;
	}
	
	public Purchaseorder(Long id_orden_compra, Date fecha, int total, Supplier id_Supplier_fk) {
		super();
		this.id_orden_compra = id_orden_compra;
		Fecha = fecha;
		Total = total;
		this.id_Supplier_fk = id_Supplier_fk;
	}

	public Purchaseorder(Date fecha, int total, Supplier id_Supplier_fk) {
		super();
		Fecha = fecha;
		Total = total;
		this.id_Supplier_fk = id_Supplier_fk;
	}
	
	public Purchaseorder(Date fecha) {
		super();
		Fecha = fecha;
	}

	public Purchaseorder() {
		super();
	}
	
	

	
	
}