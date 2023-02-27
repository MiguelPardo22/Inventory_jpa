package com.app.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_rol;
	
	@Column(name = "nombre")
	private String nom;

	public long getId_rol() {
		return id_rol;
	}

	public void setId_rol(long id_rol) {
		this.id_rol = id_rol;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Rol(long id_rol, String nom) {
		super();
		this.id_rol = id_rol;
		this.nom = nom;
	}

	public Rol() {
		super();
	}

	public Rol(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}
	
	
	
}
