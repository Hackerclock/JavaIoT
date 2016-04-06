package com.alessiogavioli.esercizio1.model;

import java.util.List;

public class Persona {
	
	private String nome;
	private String cognome;
	private Residenza residenza;
	private List<Figlio> figli;
	
	public Persona () {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Residenza getResidenza() {
		return residenza;
	}

	public void setResidenza(Residenza residenza) {
		this.residenza = residenza;
	}

	public List<Figlio> getFigli() {
		return figli;
	}

	public void setFigli(List<Figlio> figli) {
		this.figli = figli;
	}

	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		for (Figlio f : figli) {
			s.append(f.toString());
		}
		return "\nPersona nome: " + nome + " " + cognome + "\nResidenza: " + residenza + "\nFigli: " + s.toString();
	}

}
