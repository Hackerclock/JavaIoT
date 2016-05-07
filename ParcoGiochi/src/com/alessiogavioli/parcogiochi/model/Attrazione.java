package com.alessiogavioli.parcogiochi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "attrazioni")
public class Attrazione implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2788707252963203129L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nomeAttrazione;
	
	@ManyToMany
	private Set<Categoria> categorie;
	
	private Date dataInaugurazione;
	
	private Date dataDismissione;
	
	
	public Attrazione () {
		
	}

	public Attrazione(String nomeAttrazione, Set<Categoria> categorie, Date dataInaugurazione, Date dataDismissione) {
		this.nomeAttrazione = nomeAttrazione;
		this.categorie = categorie;
		this.dataInaugurazione = dataInaugurazione;
		this.dataDismissione = dataDismissione;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAttrazione() {
		return nomeAttrazione;
	}
	public void setNomeAttrazione(String nomeAttrazione) {
		this.nomeAttrazione = nomeAttrazione;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}
	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

	public Date getDataInaugurazione() {
		return dataInaugurazione;
	}
	public void setDataInaugurazione(Date dataInaugurazione) {
		this.dataInaugurazione = dataInaugurazione;
	}

	public Date getDataDismissione() {
		return dataDismissione;
	}
	public void setDataDismissione(Date dataDismissione) {
		this.dataDismissione = dataDismissione;
	}

	@Override
	public String toString() {
		return "Attrazione [" + (id != null ? "id=" + id + ", " : "")
				+ (nomeAttrazione != null ? "nomeAttrazione=" + nomeAttrazione + ", " : "")
				+ (categorie != null ? "categorie=" + categorie + ", " : "")
				+ (dataInaugurazione != null ? "dataInaugurazione=" + dataInaugurazione + ", " : "")
				+ (dataDismissione != null ? "dataDismissione=" + dataDismissione : "") + "]";
	}

	/*@Override
	public String toString() {
		
		StringBuilder cat = new StringBuilder();
		for (Iterator<Categoria> itCat = categorie.iterator(); itCat.hasNext(); ) {
			cat.append(itCat.next().toString());
		}
		return "\n\t" + nomeAttrazione + "\n\tCategorie: " + categorie
				+ "\n\tData Inaugurazione " + dataInaugurazione.toString() + "- Data Dismissione " + dataDismissione.toString();
	}*/
	
	
}
