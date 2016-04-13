package com.alessiogavioli.esempiojpa.model;

import java.io.Serializable;

public class Azienda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6417363832582252067L;
	
	private Integer id;
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
