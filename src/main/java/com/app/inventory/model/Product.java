package com.app.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Producto")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_prod;
	
	@Column(name="Referencia",length=40)
	private long Ref;
	
	@Column(name = "nombre")
	private String nom;
	
	@Column(name="Precio_compra",length=40)
	private int Pre_comp;
	
	@Column(name="Precio_venta",length=40)
	private int Pre_vent;
	
	@Column(name="Impuesto",length=40)
	private int imp;
	
	@Column(name = "estado")
	private String est;
	
	@ManyToOne
	@JoinColumn(name="id_cat_fk", referencedColumnName = "id_cat")
	private Category id_cat_fk;
	
	@ManyToOne
	@JoinColumn(name="id_med_fk", referencedColumnName = "id_med")
	private Measure id_med_fk;

	public long getId_prod() {
		return id_prod;
	}

	public void setId_prod(long id_prod) {
		this.id_prod = id_prod;
	}

	public long getRef() {
		return Ref;
	}

	public void setRef(long ref) {
		Ref = ref;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPre_comp() {
		return Pre_comp;
	}

	public void setPre_comp(int pre_comp) {
		Pre_comp = pre_comp;
	}

	public int getPre_vent() {
		return Pre_vent;
	}

	public void setPre_vent(int pre_vent) {
		Pre_vent = pre_vent;
	}

	public double getImp() {
		
		double iva = 0.19;
		
		iva *= this.Pre_vent;
		
		return iva;
	}

	public void setImp(int imp) {
		this.imp = imp;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public Category getId_cat_fk() {
		return id_cat_fk;
	}

	public void setId_cat_fk(Category id_cat_fk) {
		this.id_cat_fk = id_cat_fk;
	}

	public Measure getId_med_fk() {
		return id_med_fk;
	}

	public void setId_med_fk(Measure id_med_fk) {
		this.id_med_fk = id_med_fk;
	}
	
	
}
