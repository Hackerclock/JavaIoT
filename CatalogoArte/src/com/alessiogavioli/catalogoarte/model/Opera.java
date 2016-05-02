package com.alessiogavioli.catalogoarte.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Opera {
	
	private String titolo;
	private Date dataCreazione;
	private Tipo tipo;
	private Stile stile;
	private Autore autore;
	
	public Opera() {
	}

	public Opera(String titolo, Date dataCreazione, Tipo tipo, Stile stile, Autore autore) {
		this.titolo = titolo;
		this.dataCreazione = dataCreazione;
		this.tipo = tipo;
		this.stile = stile;
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Stile getStile() {
		return stile;
	}

	public void setStile(Stile stile) {
		this.stile = stile;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		
		return "Opera: " + titolo + "\n\tData creazione " + f.format(dataCreazione) + "\n\t" + tipo + " - " + stile
				+ "\n" + autore + "\n";
	}

}
