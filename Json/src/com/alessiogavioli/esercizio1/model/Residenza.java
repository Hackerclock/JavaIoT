package com.alessiogavioli.esercizio1.model;

public class Residenza {
	
	private String indirizzo;
	private String citta;
	
	public Residenza () {
		super();
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return " " + indirizzo + ", " + citta;
	}
	
	
}
