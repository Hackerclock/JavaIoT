package com.alessiogavioli.catalogoarte.model;

public class Stile {
	
	private String nome;

	public Stile() {
	}

	public Stile(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "\tStile: " + nome;
	}
	
	

}
