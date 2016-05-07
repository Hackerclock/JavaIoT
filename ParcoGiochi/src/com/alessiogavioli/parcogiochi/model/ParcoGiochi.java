package com.alessiogavioli.parcogiochi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries ({
	
	@NamedQuery(name = "AttrazioniPerParco", query = "SELECT a.nomeAttrazione FROM com.alessiogavioli.parcogiochi.model.ParcoGiochi p JOIN p.attrazioni a WHERE p.nomeParco=:nome ORDER BY a.nomeAttrazione"),
	@NamedQuery(name = "NegoziPerTipo", query = "SELECT n.nomeNegozio FROM com.alessiogavioli.parcogiochi.model.ParcoGiochi p JOIN p.negozi n JOIN n.tipoNegozio t WHERE t.nomeTipo=:tipo and p.nomeParco=:nome"),
	//@NamedQuery(name = "PersonalePerNegozio", query = "SELECT n.nomeNegozio, p.nome FROM com.alessiogavioli.parcogiochi.model.ParcoGiochi p JOIN p.negozi n JOIN n.tipoNegozio t JOIN ")
})

@Entity(name = "parco_giochi")
public class ParcoGiochi implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6028035305513360899L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nomeParco;
	
	@OneToMany
	private Set<Attrazione> attrazioni;
	
	@OneToMany
	private Set<Negozio> negozi;

	
	public ParcoGiochi() {
		
	}

	public ParcoGiochi(String nomeParco, Set<Attrazione> attrazioni, Set<Negozio> negozi) {
		this.nomeParco = nomeParco;
		this.attrazioni = attrazioni;
		this.negozi = negozi;
	}
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeParco() {
		return nomeParco;
	}
	public void setNomeParco(String nomeParco) {
		this.nomeParco = nomeParco;
	}

	public Set<Attrazione> getAttrazioni() {
		return attrazioni;
	}
	public void setAttrazioni(Set<Attrazione> attrazioni) {
		this.attrazioni = attrazioni;
	}

	public Set<Negozio> getNegozi() {
		return negozi;
	}
	public void setNegozi(Set<Negozio> negozi) {
		this.negozi = negozi;
	}

	@Override
	public String toString() {
		return "ParcoGiochi [" + (id != null ? "id=" + id + ", " : "")
				+ (nomeParco != null ? "nomeParco=" + nomeParco + ", " : "")
				+ (attrazioni != null ? "attrazioni=" + attrazioni + ", " : "")
				+ (negozi != null ? "negozi=" + negozi : "") + "]";
	}

	
/*	@Override
	public String toString() {
		
		StringBuilder att = new StringBuilder();
		for (Iterator<Attrazione> itAtt = attrazioni.iterator(); itAtt.hasNext(); ) {
			att.append(itAtt.next().toString());
		}
		
		StringBuilder neg = new StringBuilder();
		for (Iterator<Negozio> itNeg = negozi.iterator(); itNeg.hasNext(); ) {
			neg.append(itNeg.next().toString());
		}
		return "Parco Giochi: " + " " + nomeParco + "\n\tAttrazioni: " + att.toString() + "\n\tNegozi: "
				+ neg.toString();
	}*/
	
	
	

}
