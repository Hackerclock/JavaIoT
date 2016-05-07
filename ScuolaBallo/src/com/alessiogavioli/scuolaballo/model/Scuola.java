package com.alessiogavioli.scuolaballo.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQueries ({

	@NamedQuery(name = "CorsiPerScuola", query = "SELECT u.corsi FROM com.alessiogavioli.scuolaballo.model.Scuola u WHERE u.ragioneSociale=:nome"),
	@NamedQuery(name = "DocentiConQualifica", query = "SELECT d FROM com.alessiogavioli.scuolaballo.model.Scuola u JOIN u.docenti d JOIN d.qualifiche q WHERE u.ragioneSociale=:nome AND q.nome=:qualifica"),					
	@NamedQuery(name = "StudentiPerCorso", query = "SELECT c.studenti FROM com.alessiogavioli.scuolaballo.model.Corso c WHERE c.nome=:nome"),
	@NamedQuery(name = "UltimoCorsoAvviato", query = "SELECT c FROM com.alessiogavioli.scuolaballo.model.Scuola s JOIN s.corsi c WHERE s.ragioneSociale=:nome AND c.dataInizio=(SELECT max(c1.dataInizio) FROM com.alessiogavioli.scuolaballo.model.Corso c1)"),
	@NamedQuery(name = "StudentiPerCorsoDocente", query = "SELECT c.studenti FROM com.alessiogavioli.scuolaballo.model.Scuola s JOIN s.corsi c JOIN c.docente d WHERE s.ragioneSociale=:nomeScuola AND d.nome=:nomeDocente AND c.nome=:nomeCorso")
	
	
})

@Entity(name = "Scuole")
public class Scuola implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1948463081183556650L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String ragioneSociale;
	
	private String pIva;
	
	@OneToMany
	private Set<Corso> corsi;
	
	@ManyToMany
	private Set<Docente> docenti;
	
	

	public Scuola() {
	}

	public Scuola(String ragioneSociale, String pIva, Set<Corso> corsi, Set<Docente> docenti) {
		this.ragioneSociale = ragioneSociale;
		this.pIva = pIva;
		this.corsi = corsi;
		this.docenti = docenti;
	}

	
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	
	public String getpIva() {
		return pIva;
	}
	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	
	public Set<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(Set<Corso> corsi) {
		this.corsi = corsi;
	}

	
	public Set<Docente> getDocenti() {
		return docenti;
	}
	public void setDocenti(Set<Docente> docenti) {
		this.docenti = docenti;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder c = new StringBuilder();
		StringBuilder d = new StringBuilder();
		
		for (Iterator<Corso> it = corsi.iterator(); it.hasNext(); )
			c.append(it.next().toString() + " - ");
		for (Iterator<Docente> itD = docenti.iterator(); itD.hasNext(); )
			d.append(itD.next().toString() + " - ");
		
		return ragioneSociale + " " + pIva + " "+ c.toString() + " " + d.toString() + "\n\n";
	}

	
	

	
	

}
