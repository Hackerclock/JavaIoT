package com.alessiogavioli.aziendalogistica.model;

public class Pallet {
	
	private Dimensioni dimensioni;
	private Articolo articolo;
	
	public Pallet(Dimensioni dimensioni, Articolo articolo) {
		this.dimensioni = dimensioni;
		this.articolo = articolo;
	}

	public Dimensioni getDimensioni() {
		return dimensioni;
	}
	public void setDimensioni(Dimensioni dimensioni) {
		this.dimensioni = dimensioni;
	}

	public float getPeso() {
		return articolo.getPesoNetto() * articolo.getQta();
	}

	public Articolo getArticolo() {
		return articolo;
	}
	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	@Override
	public String toString() {
		return "\n\tMisura pallet " + dimensioni.toString() + " - Peso=" + getPeso() + "\n\t" + articolo;
	}
	
}
