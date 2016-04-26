package com.alessiogavioli.scuolaballo.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany
	private Set<Docente> docenti;
	
	

	public Scuola() {
	}

	public Scuola(String ragioneSociale, String pIva, Set<Corso> corsi, Set<Docente> docenti) {
		this.ragioneSociale = ragioneSociale;
		this.pIva = pIva;
		this.corsi = corsi;
		this.docenti = docenti;
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

	
	public Set<Docente> getDocenti() {
		return docenti;
	}
	public void setDocenti(Set<Docente> docenti) {
		this.docenti = docenti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder c = new StringBuilder();
		StringBuilder d = new StringBuilder();
		
		for (Iterator<Corso> it = corsi.iterator(); it.hasNext(); )
			c.append(it.next().toString() + " - ");
		for (Iterator<Docente> itD = docenti.iterator(); itD.hasNext(); )
			d.append(itD.next().toString() + " - ");
		
		return ragioneSociale + " " + pIva + " "+ c.toString() + " " + d.toString() + "\n\n";
	}

	
	

	
	

}
