package com.app.inventory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estadoPedidos")
public class EstadoPedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_est;
	
	@Column(name = "nombre")
	private String nom;

	public long getId_est() {
		return id_est;
	}
	
	@OneToMany(mappedBy = "id_est_fk")
	private List<Order> pedido;

	public void setId_est(long id_est) {
		this.id_est = id_est;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
