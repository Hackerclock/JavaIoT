package com.alessiogavioli.parcogiochi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "negozi")
public class Negozio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4391984400999648872L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nomeNegozio;
	
	private String posizione;
	
	@ManyToOne
	private TipoNegozio tipoNegozio;

	
	public Negozio() {
	}


	public Negozio(String nomeNegozio, String posizione, TipoNegozio tipoNegozio) {
		this.nomeNegozio = nomeNegozio;
		this.posizione = posizione;
		this.tipoNegozio = tipoNegozio;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeNegozio() {
		return nomeNegozio;
	}
	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}

	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public TipoNegozio getTipoNegozio() {
		return tipoNegozio;
	}
	public void setTipoNegozio(TipoNegozio tipoNegozio) {
		this.tipoNegozio = tipoNegozio;
	}


	@Override
	public String toString() {
		return "Negozio [" + (id != null ? "id=" + id + ", " : "")
				+ (nomeNegozio != null ? "nomeNegozio=" + nomeNegozio + ", " : "")
				+ (posizione != null ? "posizione=" + posizione + ", " : "")
				+ (tipoNegozio != null ? "tipoNegozio=" + tipoNegozio : "") + "]";
	}


	/*@Override
	public String toString() {
		return nomeNegozio + "\n\tPosizione: " + posizione + "\n\tTipo Negozio: " + tipoNegozio.toString();
	}*/
	

}
