package com.app.inventory.Dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.inventory.model.Product;
import com.app.inventory.model.Supplier;

public class PurchaseDTO {

	private int id_com;
	private String Num_fac;
	private long Tot_com;
	private Supplier id_Supplier_fk; 
	private int Can;
	private Product id_prod_fk; 
	private int SubTotal;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha;


	public int getId_com() {
		return id_com;
	}


	public void setId_com(int id_com) {
		this.id_com = id_com;
	}


	public String getNum_fac() {
		return Num_fac;
	}


	public void setNum_fac(String num_fac) {
		Num_fac = num_fac;
	}


	public long getTot_com() {
		return this.Tot_com += this.getSubTotal();
	}


	public void setTot_com(long tot_com) {
		Tot_com = tot_com;
	}


	public Supplier getId_Supplier_fk() {
		return id_Supplier_fk;
	}


	public void setId_Supplier_fk(Supplier id_Supplier_fk) {
		this.id_Supplier_fk = id_Supplier_fk;
	}


	public int getCan() {
		return Can;
	}


	public void setCan(int can) {
		Can = can;
	}


	public Product getId_prod_fk() {
		return id_prod_fk;
	}


	public void setId_prod_fk(Product id_prod_fk) {
		this.id_prod_fk = id_prod_fk;
	}


	public Date getFecha() {
		return Fecha;
	}


	public void setFecha(Date fecha) {
		Fecha = fecha;
	}


	public int getSubTotal() {
		return this.Can * this.id_prod_fk.getPre_comp();
	}


	public void setSubTotal(int subTotal) {
		SubTotal = subTotal;
	}
	
	
	
}
