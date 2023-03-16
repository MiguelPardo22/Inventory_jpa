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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Inventario")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_inventario;
	
	@Column(name= "Existencias")
	private long exis;
	
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_prod_fk", referencedColumnName = "id_prod")
	private Product id_prod_fk;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_det_com_fk", referencedColumnName = "id_det_com")
	private DetalleCompra id_det_com_fk; 
	
	/*@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_ven_fk", referencedColumnName = "id_ven")
	private Sale id_ven_fk;*/

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id_det_ped_fk", referencedColumnName = "id_det_ped")
	private OrderDetail id_det_ped_fk;	
	
	public long getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(long id_inventario) {
		this.id_inventario = id_inventario;
	}

	public long getExis() {
		return exis;
	}

	public void setExis(long exis) {
		this.exis = exis;
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
	
	public OrderDetail getId_det_ped_fk() {
		return id_det_ped_fk;
	}

	public void setId_det_ped_fk(OrderDetail id_det_ped_fk) {
		this.id_det_ped_fk = id_det_ped_fk;
	}

	public void restarInventario(int cant) {
		this.exis -= cant;
	}
}
