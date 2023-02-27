package com.app.inventory.Dto;


public class UserRegistroDTO {

    private long id_usu;
	private long iden;
	private String nom;
	private long tel;
	private String mail;
	private String con;
	private String est;
	
	public long getId_usu() {
		return id_usu;
	}
	public void setId_usu(long id_usu) {
		this.id_usu = id_usu;
	}
	public long getIden() {
		return iden;
	}
	public void setIden(long iden) {
		this.iden = iden;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	
	public String getEst() {
		return est;
	}
	public void setEst(String est) {
		this.est = est;
	}
	public UserRegistroDTO(long id_usu, long iden, String nom, long tel, String mail, String con, String est) {
		super();
		this.id_usu = id_usu;
		this.iden = iden;
		this.nom = nom;
		this.tel = tel;
		this.mail = mail;
		this.con = con;
		this.est = est;
	}
	
	public UserRegistroDTO(long iden, String nom, long tel, String mail, String con, String est) {
		super();
		this.iden = iden;
		this.nom = nom;
		this.tel = tel;
		this.mail = mail;
		this.con = con;
		this.est = est;
	}
	public UserRegistroDTO() {
		super();
	}
	
}
