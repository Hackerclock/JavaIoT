package com.alessiogavioli.scuolaballo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "studenti")
public class Studente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2795928611572471029L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String indirizzo;
	
	

	public Studente() {
		super();
	}
	

	public Studente(String nome, String indirizzo) {
		this.nome = nome;
		this.indirizzo = indirizzo;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	@Override
	public String toString() {
		return "Studente [id=" + id + ", nome=" + nome + ", indirizzo=" + indirizzo + "]";
	}
	
	

}
