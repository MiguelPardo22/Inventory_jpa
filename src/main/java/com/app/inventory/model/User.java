package com.app.inventory.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "Usuario")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usu;
	
	@Column(name="Identificacion",length=40)
	private long iden;
	
	@Column(name="Nombre_Completo",length=40)
	private String nom;
	
	@Column(name="Telefono",length=40)
	private long tel;
	
	@Column(name="Mail",length=40, unique = true)
	private String mail;
	
	@Column(name="Contraseña")
	private String con;
	
	@Column(name="Estado",length=40)
	private String est;
	
	@Column(name="reset_password_token")
	private String resetPasswordToken ;
	
	@ManyToMany(fetch =  FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name= "usuarios_roles",
			joinColumns = @JoinColumn(
					       name="usuario_id", referencedColumnName = "id_usu"),
		    inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = ("id_rol"))
			)
	private Collection<Rol> roles;

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

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public User(long id_usu, long iden, String nom, long tel, String mail, String con, String est,
			Collection<Rol> roles) {
		super();
		this.id_usu = id_usu;
		this.iden = iden;
		this.nom = nom;
		this.tel = tel;
		this.mail = mail;
		this.con = con;
		this.est = est;
		this.roles = roles;
	}

	public User(long iden, String nom, long tel, String mail, String con, Collection<Rol> roles) {
		super();
		this.iden = iden;
		this.nom = nom;
		this.tel = tel;
		this.mail = mail;
		this.con = con;
		this.roles = roles;
	}

	public User() {
		super();
	}

	/*public Rol getId_role_fk() {
		return id_role_fk;
	}

	public void setId_role_fk(Rol id_role_fk) {
		this.id_role_fk = id_role_fk;
	}*/

	
	
}
