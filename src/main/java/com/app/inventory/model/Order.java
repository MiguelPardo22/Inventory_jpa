package com.app.inventory.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Pedido")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Ped;
	
	@Column(name="Nombre_Cliente",length=40)
	private String Name_cli;
	
	@Column(name="Total",length=40)
	private long Total;

    private String Fecha = Utiles.obtenerFechaYHoraActual();
	
	@ManyToOne
	@JoinColumn(name="id_usu_fk", referencedColumnName = "id_usu")
	private User id_usu_fk; 
	
	@ManyToOne
	@JoinColumn(name="id_est_fk", referencedColumnName = "id_est")
	private EstadoPedidos id_est_fk; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "id_ped_fk")
	private List<OrderDetail> detalles;
	
	@OneToMany(mappedBy = "id_ped_fk")
	private List<Sale>Listsale;
	
	public int getId_Ped() {
		return id_Ped;
	}

	public void setId_Ped(int id_Ped) {
		this.id_Ped = id_Ped;
	}

	public String getName_cli() {
		return Name_cli;
	}

	public void setName_cli(String name_cli) {
		Name_cli = name_cli;
	}

	public long getTotal() {
		long Total = 0l;
		
		for (OrderDetail detail : detalles) {	
			
			Total += detail.getSub() + detail.getId_prod_fk().getImp();
		}
		return Total;
	}

	public void setTotal(long total) {
		this.Total = total;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public User getId_usu_fk() {
		return id_usu_fk;
	}

	public void setId_usu_fk(User id_usu_fk) {
		this.id_usu_fk = id_usu_fk;
	}

	public List<OrderDetail> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<OrderDetail> detalles) {
		this.detalles = detalles;
	}
	
	public EstadoPedidos getId_est_fk() {
		return id_est_fk;
	}

	public void setId_est_fk(EstadoPedidos id_est_fk) {
		this.id_est_fk = id_est_fk;
	}

	public Order(int id_Ped, String name_cli, long total, String fecha, User id_usu_fk) {
		super();
		this.id_Ped = id_Ped;
		Name_cli = name_cli;
		Total = total;
		Fecha = fecha;
		this.id_usu_fk = id_usu_fk;
	}

	public Order() {
		super();
	}

	public Order(String name_cli, long total, User id_usu_fk, EstadoPedidos id_est_fk) {
		super();
		Name_cli = name_cli;
		Total = total;
		this.id_usu_fk = id_usu_fk;
		this.id_est_fk = id_est_fk;
	}

	public Order(String name_cli, long total, String fecha, User id_usu_fk, EstadoPedidos id_est_fk,
			List<OrderDetail> detalles) {
		super();
		Name_cli = name_cli;
		Total = total;
		Fecha = fecha;
		this.id_usu_fk = id_usu_fk;
		this.id_est_fk = id_est_fk;
		this.detalles = detalles;
	}
	
	
	
}

