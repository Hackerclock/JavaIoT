package com.alessiogavioli.raspserver.business;

import com.alessiogavioli.raspserver.model.StazioneMeteoDati;

import flexjson.JSONDeserializer;

public class StazioneMeteoDatiManager {
	
	private String jsonSE;
	private String jsonDESE;
	
	public StazioneMeteoDatiManager(String jsonSE) {
		
		this.jsonSE = jsonSE;
	}

	public String getJsonDESE() {
		return jsonDESE;
	}

	public void setJsonDESE(String jsonDESE) {
		this.jsonDESE = jsonDESE;
	}

	public void deserializza() {
		
		JSONDeserializer<StazioneMeteoDati> ds = new JSONDeserializer<>();
		StazioneMeteoDati s1 = ds.use(null, StazioneMeteoDati.class).deserialize(jsonSE);
		System.out.println("Deserializzazione: " + s1.toString());
		
		this.setJsonDESE(s1.toString());
		
	}

}
