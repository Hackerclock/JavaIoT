package com.alessiogavioli.esempiojpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity(name = "utente")
public class Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2219764464434845629L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 255)
	private String nome;
	
	@Column(length = 255)
	private String cognome;
	
	@Column(length = 255)
	private String username;
	
	@Column(length = 255, nullable = true)
	private String email;
	
	private Date dataRegistrazione;
	private Boolean attivo;
	
	@ManyToOne
	private Azienda azienda;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Gruppo> gruppi;
	
	
	public Utente() {
		super();
	}


	public Utente(String nome, String cognome, String username, String email, Date dataRegistrazione, Boolean attivo) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.email = email;
		this.dataRegistrazione = dataRegistrazione;
		this.attivo = attivo;
		this.gruppi = new HashSet<>();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}


	public Boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}


	public Azienda getAzienda() {
		return azienda;
	}
	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}


	public Set<Gruppo> getGruppi() {
		return gruppi;
	}
	public void setGruppi(Set<Gruppo> gruppi) {
		this.gruppi = gruppi;
	}


	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", email="
				+ email + ", dataRegistrazione=" + dataRegistrazione + ", attivo=" + attivo + "]";
	}

}
