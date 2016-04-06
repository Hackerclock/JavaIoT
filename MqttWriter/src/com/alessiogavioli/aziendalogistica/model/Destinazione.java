package com.alessiogavioli.aziendalogistica.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Destinazione {
	
	private String latitudine;
	private String longitudine;
	private String nome;
	private Date dataPartenza;
	private Date dataArrivo;

	public Destinazione(String latitudine, String longitudine, String nome, Date dataPartenza, Date dataArrivo) {
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.nome = nome;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;

	}
	
	public String getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}


	public String getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	@Override
	public String toString() {
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.ITALY);
		String dataPart = df.format(dataPartenza);
		String dataArr = df.format(dataArrivo);
		
		return "\n\tDestinazione:\n\t\tLatitudine " + latitudine + " - longitudine " + longitudine + "\n\t\tPresso " + nome
				+ "\n\t\tPartenza il " + dataPart + " - Arrivo il " + dataArr;
	}

}
