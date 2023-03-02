package com.app.inventory.Dto;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.inventory.model.Order;
import com.app.inventory.model.OrderDetail;
import com.app.inventory.model.Product;
import com.app.inventory.model.User;

public class OrderDTO {

	private int id_Ped;
	private String Name_cli;
	private long sub;
	private long tot;
	private User id_usu_fk; 
	private int cant;
	private Order id_ped_fk; 
	private Product id_prod_fk; 
	private OrderDetail id_det_ped_fk; 
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String Fecha;

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

	public long getSub() {
		return this.cant * this.id_prod_fk.getPre_vent();
	}

	public void setSub(long sub) {
		this.sub = sub;
	}

	public User getId_usu_fk() {
		return id_usu_fk;
	}

	public void setId_usu_fk(User id_usu_fk) {
		this.id_usu_fk = id_usu_fk;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public Order getId_ped_fk() {
		return id_ped_fk;
	}

	public void setId_ped_fk(Order id_ped_fk) {
		this.id_ped_fk = id_ped_fk;
	}

	public Product getId_prod_fk() {
		return id_prod_fk;
	}

	public void setId_prod_fk(Product id_prod_fk) {
		this.id_prod_fk = id_prod_fk;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public long getTot() {
		
		return this.tot += this.getSub();
	}

	public void setTot(long tot) {
		this.tot = tot;
	}

	public OrderDetail getId_det_ped_fk() {
		return id_det_ped_fk;
	}

	public void setId_det_ped_fk(OrderDetail id_det_ped_fk) {
		this.id_det_ped_fk = id_det_ped_fk;
	}
	
}
