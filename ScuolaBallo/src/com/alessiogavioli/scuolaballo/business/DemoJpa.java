package com.alessiogavioli.scuolaballo.business;

import java.util.HashSet;
import java.util.Set;

import com.alessiogavioli.scuolaballo.model.Corso;
import com.alessiogavioli.scuolaballo.model.Docente;
import com.alessiogavioli.scuolaballo.model.Qualifica;
import com.alessiogavioli.scuolaballo.model.Scuola;
import com.alessiogavioli.scuolaballo.model.Studente;
import com.alessiogavioli.scuolaballo.web.JSONWriter;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class DemoJpa {

	public static void main(String[] args) throws InterruptedException {
		
		JPAUtil jpa = new JPAUtil();
		
		Set<Studente> studenti = new HashSet<>();
		Studente stu1 = new Studente();
		stu1.setNome("Alessio");
		stu1.setIndirizzo("Modena");
		Studente stu2 = new Studente();
		stu2.setNome("Lorenzo");
		stu2.setIndirizzo("Reggio");
		Studente stu3 = new Studente();
		stu3.setNome("Andrea");
		stu3.setIndirizzo("Sassuolo");
		studenti.add(stu1);
		studenti.add(stu2);
		studenti.add(stu3);
		
		Docente docente = new Docente();
		Qualifica qua1 = new Qualifica();
		qua1.setNome("Tango");
		Qualifica qua2 = new Qualifica();
		qua2.setNome("Salsa");
		Qualifica qua3 = new Qualifica();
		qua3.setNome("Merengue");
		docente.setNome("Marco");
		Set<Qualifica> qualifiche = new HashSet<>();
		qualifiche.add(qua1);
		qualifiche.add(qua2);
		qualifiche.add(qua3);
		docente.setQualifiche(qualifiche);
		
		Corso corso1 = new Corso();
		corso1.setDocente(docente);
		corso1.setQualifica(qua1);
		corso1.setStudenti(studenti);
		corso1.setNome("Tango");
		
		Corso corso2 = new Corso();
		corso1.setDocente(docente);
		corso1.setQualifica(qua2);
		corso1.setStudenti(studenti);
		corso1.setNome("Salsa");
		
		Set<Corso> corsi = new HashSet<>();
		corsi.add(corso1);
		corsi.add(corso2);
		
		Scuola scuola = new Scuola();
		scuola.setCorsi(corsi);
		scuola.setpIva("XXXXXXXXXXXXX");
		scuola.setRagioneSociale("Bailando");
		
		JSONWriter json = new JSONWriter();
		for (int i = 0; i < 5; i++){
			json.write(scuola);
			Thread.sleep(3000);
		}
		
		
		/*JSONDeserializer<Scuola> ds = new JSONDeserializer<>();
		Scuola s2 = ds.use(null, Scuola.class).deserialize(json);
		System.out.println("Deserializzazione: " + s2.toString());*/

		
		jpa.close();

	}

}
