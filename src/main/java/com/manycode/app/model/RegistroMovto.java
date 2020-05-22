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
@Table(name="tbl_RegistroMovto")
//@Data 
//@AllArgsConstructor 
//@NoArgsConstructor 
//@Builder
public class RegistroMovto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String messagesender;
	private String rString1;
	private String rString2;
	private String rString3;
	private String rString4;
	private Long importe_movto;
	private Long importe_acumulado;
	private String messagetype;
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
	public String getMessagesender() {
		return messagesender;
	}
	public void setMessagesender(String messagesender) {
		this.messagesender = messagesender;
	}
	public String getrString1() {
		return rString1;
	}
	public void setrString1(String rString1) {
		this.rString1 = rString1;
	}
	public String getrString2() {
		return rString2;
	}
	public void setrString2(String rString2) {
		this.rString2 = rString2;
	}
	public String getrString3() {
		return rString3;
	}
	public void setrString3(String rString3) {
		this.rString3 = rString3;
	}
	public String getrString4() {
		return rString4;
	}
	public void setrString4(String rString4) {
		this.rString4 = rString4;
	}
	public Long getImporte_movto() {
		return importe_movto;
	}
	public void setImporte_movto(Long importe_movto) {
		this.importe_movto = importe_movto;
	}
	public Long getImporte_acumulado() {
		return importe_acumulado;
	}
	public void setImporte_acumulado(Long importe_acumulado) {
		this.importe_acumulado = importe_acumulado;
	}
	public String getMessagetype() {
		return messagetype;
	}
	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
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