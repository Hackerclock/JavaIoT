package com.alessiogavioli.scuolaballo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Scuole")
public class Scuola implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1948463081183556650L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String ragioneSociale;
	
	private String pIva;
	
	@OneToMany
	private Set<Corso> corsi;
	
	

	public Scuola() {
	}

	public Scuola(String ragioneSociale, String pIva, Set<Corso> corsi) {
		this.ragioneSociale = ragioneSociale;
		this.pIva = pIva;
		this.corsi = corsi;
	}

	
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	
	public String getpIva() {
		return pIva;
	}
	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	
	public Set<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	@Override
	public String toString() {
		return "Scuola [id=" + id + ", ragioneSociale=" + ragioneSociale + ", pIva=" + pIva + ", corsi=" + corsi + "]";
	}
	
	

}
