package com.app.inventory.model;
import java.beans.Transient;
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
@Table(name = "Detalle_Pedido")
public class OrderDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_det_ped;
	
	@Column(name="Cantidad",length=40)
	private int cant;
	
	@Column(name="Subtotal",length=40)
	private long sub;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_ped_fk", referencedColumnName = "id_Ped")
	private Order id_ped_fk; 
	
	@ManyToOne
	@JoinColumn(name="id_prod_fk", referencedColumnName = "id_prod")
	private Product id_prod_fk;

	public int getId_det_ped() {
		return id_det_ped;
	}
    
	public void setId_det_ped(int id_det_ped) {
		this.id_det_ped = id_det_ped;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	
	@Transient
	public long getSub() {
		
		return this.cant * this.id_prod_fk.getPre_vent();
		
	}

	public void setSub(long sub) {
		this.sub = sub;
	}

	public Order getId_ped_fk() {
		return id_ped_fk;
	}

	public void setId_ped_fk(Order id_ped_fk) {
		this.id_ped_fk = id_ped_fk;
	}

	public Product getId_prod_fk() {
		return id_prod_fk;
	}

	public void setId_prod_fk(Product id_prod_fk) {
		this.id_prod_fk = id_prod_fk;
	}

	public OrderDetail(int id_det_ped, int cant, long sub, Order id_ped_fk, Product id_prod_fk) {
		super();
		this.id_det_ped = id_det_ped;
		this.cant = cant;
		this.sub = sub;
		this.id_ped_fk = id_ped_fk;
		this.id_prod_fk = id_prod_fk;
	}

	public OrderDetail(int cant, long sub, Order id_ped_fk, Product id_prod_fk) {
		super();
		this.cant = cant;
		this.sub = sub;
		this.id_ped_fk = id_ped_fk;
		this.id_prod_fk = id_prod_fk;
	}

	public OrderDetail() {
		super();
	}
	
	
	
}
