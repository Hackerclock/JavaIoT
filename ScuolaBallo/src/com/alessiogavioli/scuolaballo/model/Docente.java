package com.alessiogavioli.scuolaballo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "docenti")
public class Docente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -182381189068238660L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Qualifica> qualifiche;
	
	

	public Docente() {
		super();
	}

	public Docente(String nome, Set<Qualifica> qualifiche) {
		this.nome = nome;
		this.qualifiche = qualifiche;
	}

	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Set<Qualifica> getQualifiche() {
		return qualifiche;
	}
	public void setQualifiche(Set<Qualifica> qualifiche) {
		this.qualifiche = qualifiche;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Docente [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (nome != null) {
			builder.append("nome=");
			builder.append(nome);
			builder.append(", ");
		}
		if (qualifiche != null) {
			builder.append("qualifiche=");
			builder.append(qualifiche);
		}
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	

}
