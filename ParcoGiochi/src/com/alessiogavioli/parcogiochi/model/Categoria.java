package com.alessiogavioli.parcogiochi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "categorie")
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7722652403137632282L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nomeCategoria;
	
	@ManyToMany(mappedBy = "categorie")
	private Set<Attrazione> attrazioni;
	
	
	public Categoria () {
		
	}

	public Categoria(String nomeCategoria, Set<Attrazione> attrazioni) {
		this.nomeCategoria = nomeCategoria;
		this.attrazioni = attrazioni;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Set<Attrazione> getAttrazioni() {
		return attrazioni;
	}
	public void setAttrazioni(Set<Attrazione> attrazioni) {
		this.attrazioni = attrazioni;
	}

	@Override
	public String toString() {
		return "Categoria [" + (id != null ? "id=" + id + ", " : "")
				+ (nomeCategoria != null ? "nomeCategoria=" + nomeCategoria + ", " : "")
				+ (attrazioni != null ? "attrazioni=" + attrazioni : "") + "]";
	}

	/*@Override
	public String toString() {
		
		StringBuilder att = new StringBuilder();
		for (Iterator<Attrazione> itAtt = attrazioni.iterator(); itAtt.hasNext(); ) {
			att.append(itAtt.next().toString());
		}
		return "Categoria [nomeCategoria=" + nomeCategoria + "\n\tAttrazioni: " + attrazioni;
	}*/

	
}
