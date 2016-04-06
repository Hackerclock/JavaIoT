package com.alessiogavioli.aziendalogistica.model;

public class Articolo {
	
	private final String codice;
	private String nome;
	private String descrizione;
	private float prezzo;
	private float pesoNetto;
	private int qta;
	
	public Articolo(String codice) {
		this.codice = codice;
	}

	public Articolo(String codice, String nome, String descrizione, float prezzo, float pesoNetto, int qta) {
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.pesoNetto = pesoNetto;
		this.qta = qta;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public float getPesoNetto() {
		return pesoNetto;
	}
	public void setPesoNetto(float pesoNetto) {
		this.pesoNetto = pesoNetto;
	}

	public int getQta() {
		return qta;
	}
	public void setQta(int qta) {
		this.qta = qta;
	}

	public String getCodice() {
		return codice;
	}
	
	@Override
	public Articolo clone() throws CloneNotSupportedException {
		
		Articolo art = new Articolo(codice);
		art.setDescrizione(descrizione);
		art.setNome(nome);
		art.setPrezzo(prezzo);
		art.setQta(qta);
		return art;
	}
	
	public String toString() {
		return "\t  -- " + codice + " " + nome + " " + descrizione + " € " + String.format("%.2f", prezzo) +
				" - Peso " + String.format("%.2f", pesoNetto) + " - Quantita' " + qta + " --";
	}
	
}
