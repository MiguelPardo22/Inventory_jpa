package com.app.inventory.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Compra")
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_com;
	
	@Column(name="Numero_Factura",length=40)
	private String Num_fac;
	
	@Column(name="Total_Compra",length=40)
	private long Tot_com;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha;
	
	@ManyToOne
	@JoinColumn(name="id_Supplier_fk", referencedColumnName = "id_Proveedor")
	private Supplier id_Supplier_fk; 
	
	@OneToMany(mappedBy = "id_Purchase_fk")
	private Set<DetalleCompra> detalles;
	
	public long getId_com() {
		return id_com;
	}

	public void setId_com(long id_com) {
		this.id_com = id_com;
	}

	public String getNum_fac() {
		return Num_fac;
	}

	public void setNum_fac(String num_fac) {
		Num_fac = num_fac;
	}

	public long getTot_com() {
		long total = 0l;
		
		for (DetalleCompra detalleCompra : detalles) {	
			total += detalleCompra.getSubTotal();
		}
		return total;
	}

	public void setTot_com(long tot_com) {
		Tot_com = tot_com;
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

	public void setId_Supplier_fk(Supplier id_Supplier_fk) {
		this.id_Supplier_fk = id_Supplier_fk;

	
	}

	public Set<DetalleCompra> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<DetalleCompra> detalles) {
		this.detalles = detalles;
	}

	public Purchase(long id_com, String num_fac, long tot_com, Date fecha, Supplier id_Supplier_fk) {
		super();
		this.id_com = id_com;
		Num_fac = num_fac;
		Tot_com = tot_com;
		Fecha = fecha;
		this.id_Supplier_fk = id_Supplier_fk;
	}

	public Purchase(String num_fac, long tot_com, Date fecha, Supplier id_Supplier_fk) {
		super();
		Num_fac = num_fac;
		Tot_com = tot_com;
		Fecha = fecha;
		this.id_Supplier_fk = id_Supplier_fk;
	}

	public Purchase() {
		super();
	}	
	
}
