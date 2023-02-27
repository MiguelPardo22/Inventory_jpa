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
@Table(name = "Venta")
public class Sale implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ven;
	
	@Column(name="Total",length=40)
	private int Total;
	
	@ManyToOne
	@JoinColumn(name="id_ped_fk", referencedColumnName = "id_Ped")
	private Order id_ped_fk; 
	
	public int getId_ven() {
		return id_ven;
	}

	public void setId_ven(int id_ven) {
		this.id_ven = id_ven;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public Order getId_ped_fk() {
		return id_ped_fk;
	}

	public void setId_ped_fk(Order id_ped_fk) {
		this.id_ped_fk = id_ped_fk;
	}

	
	
}

