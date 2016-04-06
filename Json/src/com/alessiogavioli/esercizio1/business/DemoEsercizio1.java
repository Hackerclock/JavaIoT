package com.alessiogavioli.esercizio1.business;

import java.util.ArrayList;
import java.util.List;

import com.alessiogavioli.esercizio1.model.Figlio;
import com.alessiogavioli.esercizio1.model.Persona;
import com.alessiogavioli.esercizio1.model.Residenza;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class DemoEsercizio1 {

	public static void main(String[] args) {
		
		Figlio f1 = new Figlio();
		f1.setNome("Marco");
		f1.setEta("12");
		
		Figlio f2 = new Figlio();
		f2.setNome("Luigi");
		f2.setEta("8");
		
		List<Figlio> figli = new ArrayList<>();
		figli.add(f1);
		figli.add(f2);
		
		Residenza residenza = new Residenza();
		residenza.setCitta("Bologna");
		residenza.setIndirizzo("via Indipendenza, 12");
		
		Persona p1 = new Persona();
		p1.setCognome("Rossi");
		p1.setNome("Mario");
		p1.setResidenza(residenza);
		p1.setFigli(figli);
		
		System.out.println("Preserializzazione: " + p1.toString() + "\n\n");
		
		JSONSerializer s = new JSONSerializer();
		s.exclude("class", "residenza.class", "figli.class");
		String json = s.deepSerialize(p1);
		System.out.println("Serializzazione: " + json + "\n\n");
		
		
		JSONDeserializer<Persona> ds = new JSONDeserializer<>();
		Persona p2 = ds.use(null, Persona.class).deserialize(json);
		System.out.println("Deserializzazione: " + p2.toString());
		
		
	}

}
