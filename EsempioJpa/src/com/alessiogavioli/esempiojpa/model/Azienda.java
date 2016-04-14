package com.alessiogavioli.esempiojpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "azienda")
public class Azienda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6417363832582252067L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 255)
	private String ragioneSociale;

	public Azienda() {
		super();
	}

	public Azienda(String ragioneSociale) {
		super();
		this.ragioneSociale = ragioneSociale;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	
	@Override
	public String toString() {
		return "Azienda [ragioneSociale=" + ragioneSociale + "]";
	}
	
}
