package com.alessiogavioli.aziendalogistica.model;

import java.util.List;

public class PianoViaggio {

	private List<Destinazione> destinazioni;

	public PianoViaggio(List<Destinazione> destinazioni) {
		this.destinazioni = destinazioni;
	}

	public List<Destinazione> getDestinazioni() {
		return destinazioni;
	}
	public void setDestinazioni(List<Destinazione> destinazioni) {
		this.destinazioni = destinazioni;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Destinazione d : destinazioni) {
			s.append(d.toString());
		}
		return "Piano di viaggio" + s.toString();
	}
	
}
