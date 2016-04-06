package it.ecipar.helloweb.business;

import java.util.ArrayList;
import java.util.List;

import it.ecipar.helloweb.model.Figlio;
import it.ecipar.helloweb.model.Persona;
import it.ecipar.helloweb.model.Residenza;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class PersonaManager {
	
	private Persona p;
	private String jsonSE;
	private String jsonDESE;
	
	public PersonaManager(String nome) {
		
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
		
		p = new Persona();
		p.setCognome("Rossi");
		p.setNome(nome);
		p.setResidenza(residenza);
		p.setFigli(figli);
		
	}

	public Persona getP() {
		return p;
	}

	public void setP(Persona p) {
		this.p = p;
	}

	public String getJsonSE() {
		return jsonSE;
	}

	public void setJsonSE(String jsonSE) {
		this.jsonSE = jsonSE;
	}

	public String getJsonDESE() {
		return jsonDESE;
	}

	public void setJsonDESE(String jsonDESE) {
		this.jsonDESE = jsonDESE;
	}

	public void serializza () {
		
		JSONSerializer s = new JSONSerializer();
		
		s.exclude("class", "residenza.class", "figli.class");
		String json = s.prettyPrint(true).deepSerialize(p);
		System.out.println("Serializzazione: " + json + "\n\n");
		
		this.jsonSE = json;
		
	}
	
	public void deserializza () {
		
		JSONDeserializer<Persona> ds = new JSONDeserializer<>();
		Persona p1 = ds.use(null, Persona.class).deserialize(jsonSE);
		System.out.println("Deserializzazione: " + p1.toString());
		
		this.jsonDESE = p1.toString();
		
	}
	
	
}
