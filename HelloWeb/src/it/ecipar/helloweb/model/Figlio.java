package it.ecipar.helloweb.model;

public class Figlio {
	
	private String nome;
	private String eta;
	
	public Figlio () {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return " " + nome + " eta: " + eta + ", ";
	}

}
