package com.alessiogavioli.scuolaballo.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "corsi")
public class Corso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8606972047020367708L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@ManyToOne
	private Docente docente;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Studente> studenti;
	
	@ManyToOne
	private Qualifica qualifica;
	

	public Corso() {
	}

	
	public Corso(String nome, Docente docente, Set<Studente> studenti, Qualifica qualifica) {
		this.nome = nome;
		this.docente = docente;
		this.studenti = studenti;
		this.qualifica = qualifica;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	

	public Set<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Studente> studenti) {
		this.studenti = studenti;
	}
	

	public Qualifica getQualifica() {
		return qualifica;
	}

	public void setQualifica(Qualifica qualifica) {
		this.qualifica = qualifica;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Iterator<Studente> it = studenti.iterator(); it.hasNext(); )
			s.append(it.next().toString() + " - ");
		
		return nome + " docente: " + docente.toString() + " - " + s.toString() + qualifica.toString();
	}
	
	

}
