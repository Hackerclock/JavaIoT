package com.alessiogavioli.aziendalogistica.model;

import java.util.List;

public class Carico {
	
	private List<Pallet> pallets;

	public Carico(List<Pallet> pallets) {
		this.pallets = pallets;
	}

	public List<Pallet> getPallets() {
		return pallets;
	}
	public void setPallets(List<Pallet> pallets) {
		this.pallets = pallets;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Pallet p : pallets)
			s.append(p.toString());
		
		return "Carico: " + s.toString();
	}

}
