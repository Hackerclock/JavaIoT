package com.alessiogavioli.catalogoarte.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Autore {
	
	private String nome;
	private String cognome;
	private String nomeArte;
	private String luogoNascita;
	private Date dataNascita;
	private Date dataMorte;
	
	public Autore() {
		
	}

	public Autore(String nome, String cognome, String nomeArte, String luogoNascita, Date dataNascita, Date dataMorte) {
		this.nome = nome;
		this.cognome = cognome;
		this.nomeArte = nomeArte;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNomeArte() {
		return nomeArte;
	}

	public void setNomeArte(String nomeArte) {
		this.nomeArte = nomeArte;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}

	@Override
	public String toString() {
		
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		
		return "\tAutore " + nome + " " + cognome + ", nome d'arte " + nomeArte + "\n\tLuogo di nascita "
				+ luogoNascita + ". Data di nascita " + f.format(dataNascita) + " - Data di morte " + f.format(dataMorte) + "\n";
	}
	
	

}
