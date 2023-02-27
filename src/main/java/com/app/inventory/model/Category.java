package com.app.inventory.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_cat;
	
	@Column(name = "nombre")
	private String nom;
	
	@Column(name = "estado")
	private String est;
	
	@OneToMany(mappedBy = "id_cat_fk")
	private List<Product>ListProduct;

	public long getId_cat() {
		return id_cat;
	}

	public void setId_cat(long id_cat) {
		this.id_cat = id_cat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}
	
	
}
