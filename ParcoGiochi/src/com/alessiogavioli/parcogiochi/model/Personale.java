package com.alessiogavioli.parcogiochi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "perosnale")
public class Personale implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5139238326556654955L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String matricola;
	
	private String nome;
	
	@ManyToMany
	private Set<Attrazione> attrazioni;
	
	@ManyToOne
	private Negozio negozio;
	
	
	public Personale () {
		
	}

	public Personale(String matricola, String nome, Set<Attrazione> attrazioni, Negozio negozio) {
		this.matricola = matricola;
		this.nome = nome;
		this.attrazioni = attrazioni;
		this.negozio = negozio;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Attrazione> getAttrazioni() {
		return attrazioni;
	}
	public void setAttrazioni(Set<Attrazione> attrazioni) {
		this.attrazioni = attrazioni;
	}

	public Negozio getNegozio() {
		return negozio;
	}
	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}

	@Override
	public String toString() {
		return "Personale [" + (id != null ? "id=" + id + ", " : "")
				+ (matricola != null ? "matricola=" + matricola + ", " : "")
				+ (nome != null ? "nome=" + nome + ", " : "")
				+ (attrazioni != null ? "attrazioni=" + attrazioni + ", " : "")
				+ (negozio != null ? "negozio=" + negozio : "") + "]";
	}

	
	/*@Override
	public String toString() {
		
		StringBuilder att = new StringBuilder();
		for (Iterator<Attrazione> itAtt = attrazioni.iterator(); itAtt.hasNext(); ) {
			att.append(itAtt.next().toString());
		}
		
		return "\n\tMatricola: " + matricola + "\n\tNome: " + nome + "Attrazioni: " + att.toString() + "\n\tAddetto al Negozio: "
				+ negozio.toString();
	}*/

	
}
