package com.alessiogavioli.esempiojpa.model;

import java.io.Serializable;

public class Gruppo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7128925966827341083L;
	
	private Integer id;
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
