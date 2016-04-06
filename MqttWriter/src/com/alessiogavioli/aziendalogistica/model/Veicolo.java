package com.alessiogavioli.aziendalogistica.model;

public class Veicolo {
	
	private String targa;
	private Guidatore guidatore;
	private PianoViaggio pianoViaggio;
	private final float pesoMax;
	
	public Veicolo(String targa, Guidatore guidatore, PianoViaggio pianoViaggio, float pesoMax) {
		this.targa = targa;
		this.guidatore = guidatore;
		this.pianoViaggio = pianoViaggio;
		this.pesoMax = pesoMax;
	}
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	public Guidatore getGuidatore() {
		return guidatore;
	}
	public void setGuidatore(Guidatore guidatore) {
		this.guidatore = guidatore;
	}
	
	public PianoViaggio getPianoViaggio() {
		return pianoViaggio;
	}
	public void setPianoViaggio(PianoViaggio pianoViaggio) {
		this.pianoViaggio = pianoViaggio;
	}

	public float getPesoMax() {
		return pesoMax;
	}

	@Override
	public String toString() {
		return "Veicolo " + targa + "\n" + guidatore.toString() + "\n" + pianoViaggio.toString() + "\nPeso massimo trasportabile "
				+ pesoMax + "Kg";
	}
	
}
