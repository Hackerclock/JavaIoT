package com.alessiogavioli.aziendalogistica.model;

public class Guidatore {
	
	private String nome;

	public Guidatore(String nome) {
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
		return "Guidatore " + nome;
	}

}
