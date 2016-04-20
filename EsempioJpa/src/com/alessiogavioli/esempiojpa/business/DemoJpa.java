package com.alessiogavioli.esempiojpa.business;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.alessiogavioli.esempiojpa.model.*;

public class DemoJpa {

	public static void main(String[] args) {
		
		JPAUtil jpa = new JPAUtil();
		
		/*Azienda a = (Azienda)jpa.load(Azienda.class, 2);
		
		Gruppo g = (Gruppo)jpa.load(Gruppo.class, 3);
		Set<Gruppo> gruppi = new HashSet<>();
		gruppi.add(g);
		
		Utente u = new Utente();
		u.setNome("Paperino");
		u.setCognome("Pap");
		u.setEmail("paperino@live.com");
		u.setAttivo(true);
		u.setAzienda(a);
		u.setGruppi(gruppi);
		u.setDataRegistrazione(new Date());
		u.setUsername("Pape");
		jpa.insert(u);*/
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("nome", "Alessio");
		List<?> utente = jpa.runNamedQuery("UtenteNome", params);
		System.out.println(utente.toString());
		
		jpa.close();

	}

}
