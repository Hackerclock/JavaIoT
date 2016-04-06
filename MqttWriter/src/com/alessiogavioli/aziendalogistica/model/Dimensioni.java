package com.alessiogavioli.aziendalogistica.model;

public class Dimensioni {
	
	private float larg;
	private float lung;
	private float alt;
	
	public Dimensioni(float larg, float lung, float alt) {
		this.larg = larg;
		this.lung = lung;
		this.alt = alt;
	}

	public float getLarg() {
		return larg;
	}
	public void setLarg(float larg) {
		this.larg = larg;
	}

	public float getLung() {
		return lung;
	}
	public void setLung(float lung) {
		this.lung = lung;
	}

	public float getAlt() {
		return alt;
	}
	public void setAlt(float alt) {
		this.alt = alt;
	}

	@Override
	public String toString() {
		return larg + "x" + lung + "x" + alt + "h";
	}

}
