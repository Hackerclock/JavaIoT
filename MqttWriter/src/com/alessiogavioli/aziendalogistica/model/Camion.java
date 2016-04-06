package com.alessiogavioli.aziendalogistica.model;

public class Camion extends Veicolo {
	
	private Carico carico;
	private final int qtaPalletsMax;
	
	public Camion(String targa, Guidatore guidatore, PianoViaggio pianoViaggio, float pesoMax, int qtaPalletsMax) {
		super(targa, guidatore, pianoViaggio, pesoMax);
		this.carico = null;
		this.qtaPalletsMax = qtaPalletsMax;
	}

	public Carico getCarico() {
		return carico;
	}
	public void setCarico(Carico carico) {
		this.carico = carico;
	}

	public int getQtaPalletsMax() {
		return qtaPalletsMax;
	}

	@Override
	public String toString() {
		if (carico == null)
			return super.toString() + " - Carico vuoto" + " - Pallets trasportabili " + qtaPalletsMax;
		return super.toString() + "\nPallets trasportabili " + qtaPalletsMax + "\n" + carico.toString();
	}

}
