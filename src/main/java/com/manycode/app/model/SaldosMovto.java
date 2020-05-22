package com.manycode.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_SaldosMovto")
//@Data 
//@AllArgsConstructor 
//@NoArgsConstructor 
//@Builder
public class SaldosMovto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombresaldo;
	private Long importe_saldo_movto;
	private String status;
	@Column(name="create_at")		
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombresaldo() {
		return nombresaldo;
	}
	public void setNombresaldo(String nombresaldo) {
		this.nombresaldo = nombresaldo;
	}
	public Long getImporte_saldo_movto() {
		return importe_saldo_movto;
	}
	public void setImporte_saldo_movto(Long importe_saldo_movto) {
		this.importe_saldo_movto = importe_saldo_movto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	
}
