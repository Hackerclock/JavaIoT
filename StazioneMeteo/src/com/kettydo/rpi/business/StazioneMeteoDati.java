package com.kettydo.rpi.business;

public class StazioneMeteoDati {
	
	private float temperatura;
	private float umidita;
	private float uvIntensity;
	private float pressione;
	private float airQuality;
	private float etanolo;
	private float butano;
	private float idrogeno;
	
	public StazioneMeteoDati() {
		
	}

	public float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public float getUmidita() {
		return umidita;
	}
	public void setUmidita(float umidita) {
		this.umidita = umidita;
	}

	public float getUvIntensity() {
		return uvIntensity;
	}
	public void setUvIntensity(float uvIntensity) {
		this.uvIntensity = uvIntensity;
	}

	public float getPressione() {
		return pressione;
	}
	public void setPressione(float pressione) {
		this.pressione = pressione / 100;
	}

	public float getAirQuality() {
		return airQuality;
	}
	public void setAirQuality(float airQuality) {
		this.airQuality = airQuality;
	}

	public float getEtanolo() {
		return etanolo;
	}
	public void setEtanolo(float etanolo) {
		this.etanolo = etanolo;
	}

	public float getButano() {
		return butano;
	}
	public void setButano(float butano) {
		this.butano = butano;
	}

	public float getIdrogeno() {
		return idrogeno;
	}
	public void setIdrogeno(float idrogeno) {
		this.idrogeno = idrogeno;
	}

	@Override
	public String toString() {
		return "StazioneMeteoDati"
				+ "\n\ttemperatura= " + temperatura +
				"\n\tumidita= " + umidita +
				"\n\tuvIntensity= " + uvIntensity +
				"\n\tpressione= " + pressione +
				"\n\tairQuality= " + airQuality +
				"\n\tetanolo= " + etanolo +
				"\n\tbutano= " + butano +
				"\n\tidrogeno=" + idrogeno;
	}
	
	
	
}
