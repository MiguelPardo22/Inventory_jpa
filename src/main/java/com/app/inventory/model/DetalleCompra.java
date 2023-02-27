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
@Table(name = "DetalleCompra")
public class DetalleCompra implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_det_com;
	
	@Column(name="Cantidad",length=40)
	private int Can;
	
	@ManyToOne
	@JoinColumn(name = "id_prod_fk", referencedColumnName = "id_prod")
	private Product id_prod_fk; 
	
	@Column(name="SubTotal",length=40)
	private int SubTotal;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_Purchase_fk", referencedColumnName = "id_com")
	private Purchase id_Purchase_fk;

	public int getId_det_com() {
		return id_det_com;
	}

	public void setId_det_com(int id_det_com) {
		this.id_det_com = id_det_com;
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

	public int getSubTotal() {
		return this.Can * this.id_prod_fk.getPre_comp();
	}

	public void setSubTotal(int subTotal) {
		SubTotal = subTotal;
	}

	public Purchase getId_Purchase_fk() {
		return id_Purchase_fk;
	}

	public void setId_Purchase_fk(Purchase id_Purchase_fk) {
		this.id_Purchase_fk = id_Purchase_fk;
	}

	public DetalleCompra(int id_det_com, int can, Product id_prod_fk, int subTotal, Purchase id_Purchase_fk) {
		super();
		this.id_det_com = id_det_com;
		Can = can;
		this.id_prod_fk = id_prod_fk;
		SubTotal = subTotal;
		this.id_Purchase_fk = id_Purchase_fk;
	}

	public DetalleCompra(int can, Product id_prod_fk, int subTotal, Purchase id_Purchase_fk) {
		super();
		Can = can;
		this.id_prod_fk = id_prod_fk;
		SubTotal = subTotal;
		this.id_Purchase_fk = id_Purchase_fk;
	}

	public DetalleCompra() {
		super();
	}
	
}
	

	