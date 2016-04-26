package com.alessiogavioli.scuolaballo.model;

import java.io.Serializable;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/

//@Entity(name = "qualifiche")
public class Qualifica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -320483738589659778L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nome;

	public Qualifica() {
	}

	public Qualifica(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Qualifica [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (nome != null) {
			builder.append("nome=");
			builder.append(nome);
		}
		builder.append("]");
		return builder.toString();
	}

}
