package com.alessiogavioli.parcogiochi.business;

//import java.util.Date;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

/*
import com.alessiogavioli.parcogiochi.model.Attrazione;
import com.alessiogavioli.parcogiochi.model.Categoria;
import com.alessiogavioli.parcogiochi.model.Negozio;
import com.alessiogavioli.parcogiochi.model.ParcoGiochi;
import com.alessiogavioli.parcogiochi.model.Personale;
import com.alessiogavioli.parcogiochi.model.TipoNegozio;
*/

public class DemoParcoGiochi {

	public static void main(String[] args) {
		
		JPAUtil jpa = new JPAUtil();

/*
		// Oggetti tipoNegozio
		TipoNegozio tipo1 = new TipoNegozio();
		tipo1.setNomeTipo("tipo1");
		Set<Negozio> negTipo1 = new HashSet<>();
		jpa.insert(tipo1);
		
		TipoNegozio tipo2 = new TipoNegozio();
		tipo2.setNomeTipo("tipo2");
		Set<Negozio> negTipo2 = new HashSet<>();
		jpa.insert(tipo2);
		
		TipoNegozio tipo3 = new TipoNegozio();
		tipo3.setNomeTipo("tipo3");
		Set<Negozio> negTipo3 = new HashSet<>();
		jpa.insert(tipo3);
		
		TipoNegozio tipo4 = new TipoNegozio();
		tipo4.setNomeTipo("tipo4");
		Set<Negozio> negTipo4 = new HashSet<>();
		jpa.insert(tipo4);
		
		// Oggetti Negozio
		Negozio negozio1 = new Negozio();
		negozio1.setNomeNegozio("Negozio1");
		negozio1.setPosizione("P1");
		negozio1.setTipoNegozio(tipo1);
		negTipo1.add(negozio1);
		jpa.insert(negozio1);
		
		Negozio negozio2 = new Negozio();
		negozio2.setNomeNegozio("Negozio2");
		negozio2.setPosizione("P2");
		negozio2.setTipoNegozio(tipo2);
		negTipo2.add(negozio2);
		jpa.insert(negozio2);
		
		Negozio negozio3 = new Negozio();
		negozio3.setNomeNegozio("Negozio3");
		negozio3.setPosizione("P3");
		negozio3.setTipoNegozio(tipo3);
		negTipo3.add(negozio3);
		jpa.insert(negozio3);
		
		Negozio negozio4 = new Negozio();
		negozio4.setNomeNegozio("Negozio4");
		negozio4.setPosizione("P4");
		negozio4.setTipoNegozio(tipo4);
		negTipo4.add(negozio4);
		jpa.insert(negozio4);
		
		Negozio negozio5 = new Negozio();
		negozio5.setNomeNegozio("Negozio5");
		negozio5.setPosizione("P5");
		negozio5.setTipoNegozio(tipo1);
		negTipo1.add(negozio5);
		jpa.insert(negozio5);
		
		Negozio negozio6 = new Negozio();
		negozio6.setNomeNegozio("Negozio6");
		negozio6.setPosizione("P6");
		negozio6.setTipoNegozio(tipo2);
		negTipo2.add(negozio6);
		jpa.insert(negozio6);
		
		Negozio negozio7 = new Negozio();
		negozio7.setNomeNegozio("Negozio7");
		negozio7.setPosizione("P7");
		negozio7.setTipoNegozio(tipo3);
		negTipo3.add(negozio7);
		jpa.insert(negozio7);
		
		Negozio negozio8 = new Negozio();
		negozio8.setNomeNegozio("Negozio8");
		negozio8.setPosizione("P8");
		negozio8.setTipoNegozio(tipo4);
		negTipo4.add(negozio8);
		jpa.insert(negozio8);
		
		tipo1.setNegozi(negTipo1);
		jpa.update(tipo1);
		tipo2.setNegozi(negTipo2);
		jpa.update(tipo2);
		tipo3.setNegozi(negTipo3);
		jpa.update(tipo3);
		tipo4.setNegozi(negTipo4);
		jpa.update(tipo4);
		
		// Oggetti Categoria
		Categoria categoria1 = new Categoria();
		categoria1.setNomeCategoria("Categoria1");
		Set<Attrazione> attCat1 = new HashSet<>();
		jpa.insert(categoria1);
		
		Categoria categoria2 = new Categoria();
		categoria2.setNomeCategoria("Categoria2");
		Set<Attrazione> attCat2 = new HashSet<>();
		jpa.insert(categoria2);
		
		Categoria categoria3 = new Categoria();
		categoria3.setNomeCategoria("Categoria3");
		Set<Attrazione> attCat3 = new HashSet<>();
		jpa.insert(categoria3);
		
		Categoria categoria4 = new Categoria();
		categoria4.setNomeCategoria("Categoria4");
		Set<Attrazione> attCat4 = new HashSet<>();
		jpa.insert(categoria4);
		
		// Oggetti Attrazione
		Attrazione attrazione1 = new Attrazione();
		attrazione1.setNomeAttrazione("Attrazione1");
		attrazione1.setDataInaugurazione(new Date());
		attrazione1.setDataDismissione(new Date());
		Set<Categoria> catAtt1 = new HashSet<>();
		catAtt1.add(categoria1);
		catAtt1.add(categoria2);
		attCat1.add(attrazione1);
		attCat2.add(attrazione1);
		jpa.insert(attrazione1);
		
		Attrazione attrazione2 = new Attrazione();
		attrazione2.setNomeAttrazione("Attrazione2");
		attrazione2.setDataInaugurazione(new Date());
		attrazione2.setDataDismissione(new Date());
		Set<Categoria> catAtt2 = new HashSet<>();
		catAtt2.add(categoria3);
		catAtt2.add(categoria4);
		attCat3.add(attrazione2);
		attCat4.add(attrazione2);
		jpa.insert(attrazione2);
		
		Attrazione attrazione3 = new Attrazione();
		attrazione3.setNomeAttrazione("Attrazione3");
		attrazione3.setDataInaugurazione(new Date());
		attrazione3.setDataDismissione(new Date());
		Set<Categoria> catAtt3 = new HashSet<>();
		catAtt3.add(categoria1);
		catAtt3.add(categoria4);
		attCat1.add(attrazione3);
		attCat4.add(attrazione3);
		jpa.insert(attrazione3);
		
		Attrazione attrazione4 = new Attrazione();
		attrazione4.setNomeAttrazione("Attrazione4");
		attrazione4.setDataInaugurazione(new Date());
		attrazione4.setDataDismissione(new Date());
		Set<Categoria> catAtt4 = new HashSet<>();
		catAtt4.add(categoria2);
		catAtt4.add(categoria3);
		attCat2.add(attrazione4);
		attCat3.add(attrazione4);
		jpa.insert(attrazione4);
		
		attrazione1.setCategorie(catAtt1);
		jpa.update(attrazione1);
		attrazione2.setCategorie(catAtt2);
		jpa.update(attrazione2);
		attrazione3.setCategorie(catAtt3);
		jpa.update(attrazione3);
		attrazione4.setCategorie(catAtt4);
		jpa.update(attrazione4);
		
		categoria1.setAttrazioni(attCat1);
		jpa.update(categoria1);
		categoria2.setAttrazioni(attCat2);
		jpa.update(categoria2);
		categoria3.setAttrazioni(attCat3);
		jpa.update(categoria3);
		categoria4.setAttrazioni(attCat4);
		jpa.update(categoria4);
		
		// Oggetti Personale
		Personale personale1 = new Personale();
		personale1.setMatricola("XXXXXX");
		personale1.setNome("Persona1");
		personale1.setNegozio(negozio1);
		jpa.insert(personale1);
		
		Personale personale2 = new Personale();
		personale2.setMatricola("XXXXXX");
		personale2.setNome("Persona2");
		personale2.setNegozio(negozio2);
		jpa.insert(personale2);
		
		Personale personale3 = new Personale();
		personale3.setMatricola("XXXXXX");
		personale3.setNome("Persona3");
		personale3.setNegozio(negozio3);
		jpa.insert(personale3);
		
		Personale personale4 = new Personale();
		personale4.setMatricola("XXXXXX");
		personale4.setNome("Persona4");
		personale4.setNegozio(negozio4);
		jpa.insert(personale4);
		
		Personale personale5 = new Personale();
		personale5.setMatricola("XXXXXX");
		personale5.setNome("Persona5");
		personale5.setNegozio(negozio5);
		jpa.insert(personale5);
		
		Personale personale6 = new Personale();
		personale6.setMatricola("XXXXXX");
		personale6.setNome("Persona6");
		personale6.setNegozio(negozio1);
		jpa.insert(personale6);
		
		Personale personale7 = new Personale();
		personale7.setMatricola("XXXXXX");
		personale7.setNome("Persona7");
		personale7.setNegozio(negozio7);
		jpa.insert(personale7);
		
		Personale personale8 = new Personale();
		personale8.setMatricola("XXXXXX");
		personale8.setNome("Persona8");
		personale8.setNegozio(negozio8);
		jpa.insert(personale8);
		
		Personale personale10 = new Personale();
		personale10.setMatricola("XXXXXX");
		personale10.setNome("Persona10");
		Set<Attrazione> attrPers10 = new HashSet<>();
		attrPers10.add(attrazione1);
		attrPers10.add(attrazione2);
		jpa.insert(personale10);
		
		Personale personale11 = new Personale();
		personale11.setMatricola("XXXXXX");
		personale11.setNome("Persona11");
		Set<Attrazione> attrPers11 = new HashSet<>();
		attrPers11.add(attrazione3);
		attrPers11.add(attrazione4);
		jpa.insert(personale11);
		
		Personale personale12 = new Personale();
		personale12.setMatricola("XXXXXX");
		personale12.setNome("Persona12");
		Set<Attrazione> attrPers12 = new HashSet<>();
		attrPers12.add(attrazione1);
		jpa.insert(personale12);
		
		Personale personale13 = new Personale();
		personale13.setMatricola("XXXXXX");
		personale13.setNome("Persona13");
		Set<Attrazione> attrPers13 = new HashSet<>();
		attrPers13.add(attrazione2);
		jpa.insert(personale13);
		
		Personale personale14 = new Personale();
		personale14.setMatricola("XXXXXX");
		personale14.setNome("Persona14");
		Set<Attrazione> attrPers14 = new HashSet<>();
		attrPers14.add(attrazione3);
		jpa.insert(personale14);
		
		Personale personale15 = new Personale();
		personale15.setMatricola("XXXXXX");
		personale15.setNome("Persona15");
		Set<Attrazione> attrPers15 = new HashSet<>();
		attrPers15.add(attrazione4);
		jpa.insert(personale15);
		
		personale10.setAttrazioni(attrPers10);
		jpa.update(personale10);
		personale11.setAttrazioni(attrPers11);
		jpa.update(personale11);
		personale12.setAttrazioni(attrPers12);
		jpa.update(personale12);
		personale13.setAttrazioni(attrPers13);
		jpa.update(personale13);
		personale14.setAttrazioni(attrPers14);
		jpa.update(personale14);
		personale15.setAttrazioni(attrPers15);
		jpa.update(personale15);
		
		// Oggetti ParcoGiochi
		ParcoGiochi parcoGiochi1 = new ParcoGiochi();
		parcoGiochi1.setNomeParco("Parco1");
		Set<Attrazione> attrParcoGiochi1 = new HashSet<>();
		attrParcoGiochi1.add(attrazione1);
		attrParcoGiochi1.add(attrazione2);
		attrParcoGiochi1.add(attrazione3);
		attrParcoGiochi1.add(attrazione4);
		parcoGiochi1.setAttrazioni(attrParcoGiochi1);
		Set<Negozio> negParcoGiochi1 = new HashSet<>();
		negParcoGiochi1.add(negozio1);
		negParcoGiochi1.add(negozio2);
		negParcoGiochi1.add(negozio3);
		negParcoGiochi1.add(negozio4);
		negParcoGiochi1.add(negozio5);
		negParcoGiochi1.add(negozio6);
		negParcoGiochi1.add(negozio7);
		negParcoGiochi1.add(negozio8);
		parcoGiochi1.setNegozi(negParcoGiochi1);
		jpa.insert(parcoGiochi1);
		
		//System.out.println(parcoGiochi1.toString());
		
		
*/
		/*HashMap<String, Object> params1 = new HashMap<>();
		params1.put("nome", "Parco1");
		List<?> attrazioniQu = jpa.runNamedQuery("AttrazioniPerParco", params1);
		System.out.println(attrazioniQu.toString() + "\n\n");*/
		
		HashMap<String, Object> params2 = new HashMap<>();
		params2.put("nome", "Parco1");
		params2.put("tipo", "tipo2");
		List<?> negoziQu = jpa.runNamedQuery("NegoziPerTipo", params2);
		System.out.println(negoziQu.toString() + "\n\n");
		
		jpa.close();

	}

}
