package com.alessiogavioli.esempiojpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "gruppo")
public class Gruppo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7128925966827341083L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 255)
	private String nome;

	public Gruppo() {
		super();
	}

	public Gruppo(String nome) {
		super();
		this.nome = nome;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public String toString() {
		return "Gruppo [nome=" + nome + "]";
	}

}
