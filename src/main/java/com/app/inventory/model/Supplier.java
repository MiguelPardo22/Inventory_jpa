package com.app.inventory.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proveedor")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_Proveedor;

	@Column(name="nit",length=40)
	private long nit;
	
	@Column(name="nombre",length=40)
	private String nom;
	
	@Column(name="telefono",length=40)
	private long tel;
	
	@Column(name="Direccion",length=40)
	private String dir;
	
	@Column(name="Mail",length=40)
	private String mail;
	
	@Column(name="estado",length=40)
	private String est;
	
	/*@OneToMany(mappedBy = "id_Supplier_fk")
	private List<Purchase>ListPurchase;
	
	@OneToMany(mappedBy = "id_Supplier_fk")
	private List<InventoryDetail>ListInventoryDetail;
	
	@OneToMany(mappedBy = "id_Supplier_fk")
	private List<Purchaseorder>ListPurchaseOrder;*/

	public long getId_Proveedor() {
		return id_Proveedor;
	}

	public void setId_Proveedor(long id_Proveedor) {
		this.id_Proveedor = id_Proveedor;
	}

	public long getNit() {
		return nit;
	}

	public void setNit(long nit) {
		this.nit = nit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}
}
