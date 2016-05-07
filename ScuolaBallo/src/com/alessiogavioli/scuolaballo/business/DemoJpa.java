package com.alessiogavioli.scuolaballo.business;

//import java.util.GregorianCalendar;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

//import com.alessiogavioli.scuolaballo.model.Corso;
//import com.alessiogavioli.scuolaballo.model.Docente;
//import com.alessiogavioli.scuolaballo.model.Qualifica;
//import com.alessiogavioli.scuolaballo.model.Scuola;
//import com.alessiogavioli.scuolaballo.model.Studente;
//import com.alessiogavioli.scuolaballo.web.JSONWriter;

public class DemoJpa {

	public static void main(String[] args) throws InterruptedException {
		
		JPAUtil jpa = new JPAUtil();
		
/////////////////////////////////////////////////////////////////
		
		/*Studente stu1 = new Studente();
		stu1.setNome("Alessio");
		stu1.setIndirizzo("Modena");
		jpa.insert(stu1);
		System.out.println(stu1.toString());
		
		Studente stu2 = new Studente();
		stu2.setNome("Lorenzo");
		stu2.setIndirizzo("Reggio");
		jpa.insert(stu2);
		System.out.println(stu2.toString());
		
		Studente stu3 = new Studente();
		stu3.setNome("Andrea");
		stu3.setIndirizzo("Sassuolo");
		jpa.insert(stu3);
		System.out.println(stu3.toString());
		
/////////////////////////////////////////////////////////////////
		
		Qualifica qua1 = new Qualifica();
		qua1.setNome("Tango");
		jpa.insert(qua1);
		
		Qualifica qua2 = new Qualifica();
		qua2.setNome("Salsa");
		jpa.insert(qua2);
		
		Qualifica qua3 = new Qualifica();
		qua3.setNome("Merengue");
		jpa.insert(qua3);
		
/////////////////////////////////////////////////////////////////
		
		Docente docente1 = new Docente();
		Set<Qualifica> qualifiche1 = new HashSet<>();
		qualifiche1.add(qua1);
		docente1.setNome("Docente1");
		docente1.setQualifiche(qualifiche1);
		jpa.insert(docente1);
		
		Docente docente2 = new Docente();
		Set<Qualifica> qualifiche2 = new HashSet<>();
		qualifiche2.add(qua2);
		docente2.setNome("Docente2");
		docente2.setQualifiche(qualifiche2);
		jpa.insert(docente2);
		
		Docente docente3 = new Docente();
		Set<Qualifica> qualifiche3 = new HashSet<>();
		qualifiche3.add(qua3);
		docente3.setNome("Docente3");
		docente3.setQualifiche(qualifiche3);
		jpa.insert(docente3);
		
/////////////////////////////////////////////////////////////////
		
		Corso corso1 = new Corso();
		Set<Studente> studenti1 = new HashSet<>();
		studenti1.add(stu1);
		studenti1.add(stu2);
		corso1.setDocente(docente1);
		corso1.setQualifica(qua1);
		corso1.setStudenti(studenti1);
		corso1.setNome("Tango");
		jpa.insert(corso1);
		System.err.println("CORSO1: " + corso1.toString());
		
		Corso corso2 = new Corso();
		Set<Studente> studenti2 = new HashSet<>();
		studenti2.add(stu2);
		studenti2.add(stu3);
		corso2.setDocente(docente2);
		corso2.setQualifica(qua2);
		corso2.setStudenti(studenti2);
		corso2.setNome("Salsa");
		jpa.insert(corso2);
		System.out.println("CORSO2: " + corso2.toString());
				
/////////////////////////////////////////////////////////////////
		
		Scuola scuola1 = new Scuola();
		Set<Corso> corsi1 = new HashSet<>();
		corsi1.add(corso1);
		Set<Docente> docenti1 = new HashSet<>();
		docenti1.add(docente1);
		docenti1.add(docente2);
		scuola1.setCorsi(corsi1);
		scuola1.setpIva("XXXXXXXXXXXXX");
		scuola1.setRagioneSociale("Scuola1");
		scuola1.setDocenti(docenti1);
		jpa.insert(scuola1);
		System.out.println("SCUOLA1: " + scuola1.toString());
		
		Scuola scuola2 = new Scuola();
		Set<Corso> corsi2 = new HashSet<>();
		corsi2.add(corso2);
		Set<Docente> docenti2 = new HashSet<>();
		docenti1.add(docente2);
		docenti1.add(docente3);
		scuola2.setCorsi(corsi2);
		scuola2.setpIva("XXXXXXXXXXXXX");
		scuola2.setRagioneSociale("Bailando");
		scuola2.setDocenti(docenti2);
		jpa.insert(scuola2);
		System.out.println("SCUOLA2: " + scuola2.toString());*/
		
/////////////////////////////////////////////////////////////////
		
		/*JSONWriter json = new JSONWriter();
		for (int i = 0; i < 5; i++){
			json.write(scuola);
			Thread.sleep(3000);
		}*/
		
		
		/*JSONDeserializer<Scuola> ds = new JSONDeserializer<>();
		Scuola s2 = ds.use(null, Scuola.class).deserialize(json);
		System.out.println("Deserializzazione: " + s2.toString());*/
		
		
		
		/*Corso corso2 = new Corso();
		Set<Studente> studenti2 = new HashSet<>();
		studenti2.add((Studente)jpa.load(Studente.class, 59));
		studenti2.add((Studente)jpa.load(Studente.class, 60));
		corso2.setDocente((Docente)jpa.load(Docente.class, 65));
		corso2.setQualifica((Qualifica)jpa.load(Qualifica.class, 62));
		corso2.setStudenti(studenti2);
		corso2.setNome("Salsa");
		jpa.insert(corso2);*/
		
		/*Corso c = (Corso)jpa.load(Corso.class, 71);
		c.setDataInizio(new GregorianCalendar(2016, 3, 1).getTime());
		c.setDataFine(new GregorianCalendar(2016, 5, 15).getTime());
		jpa.update(c);*/
		
		/*Scuola s = (Scuola)jpa.load(Scuola.class, 69);
		s.getCorsi().add((Corso)jpa.load(Corso.class, 71));
		jpa.update(s);*/
		
		HashMap<String, Object> params1 = new HashMap<>();
		params1.put("nome", "Scuola1");
		List<?> scuola = jpa.runNamedQuery("CorsiPerScuola", params1);
		System.out.println(scuola.toString() + "\n\n");
		
		HashMap<String, Object> params2 = new HashMap<>();
		params2.put("nome", "Scuola1");
		params2.put("qualifica", "Tango");
		List<?> docente = jpa.runNamedQuery("DocentiConQualifica", params2);
		System.out.println(docente.toString() + "\n\n");
		
		HashMap<String, Object> params3 = new HashMap<>();
		params3.put("nome", "Salsa");
		List<?> studenti = jpa.runNamedQuery("StudentiPerCorso", params3);
		System.out.println(studenti.toString() + "\n\n");
		
		HashMap<String, Object> params4 = new HashMap<>();
		params4.put("nome", "Scuola1");
		List<?> corso = jpa.runNamedQuery("UltimoCorsoAvviato", params4);
		System.out.println(corso.toString() + "\n\n");
		
		HashMap<String, Object> params5 = new HashMap<>();
		params5.put("nomeScuola", "Scuola1");
		params5.put("nomeDocente", "Docente2");
		params5.put("nomeCorso", "Salsa");
		List<?> studentiCorso = jpa.runNamedQuery("StudentiPerCorsoDocente", params5);
		System.out.println(studentiCorso.toString() + "\n\n");
		
		
		jpa.close();

	}

}
