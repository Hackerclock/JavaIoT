package com.alessiogavioli.parcogiochi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "tipo_negozio")
public class TipoNegozio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4964392882516355036L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nomeTipo;
	
	@OneToMany(mappedBy = "tipoNegozio")
	private Set<Negozio> negozi;
	
	
	public TipoNegozio () {
		
	}

	public TipoNegozio(String nomeTipo, Set<Negozio> negozi) {
		this.nomeTipo = nomeTipo;
		this.negozi = negozi;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	public Set<Negozio> getNegozi() {
		return negozi;
	}
	public void setNegozi(Set<Negozio> negozi) {
		this.negozi = negozi;
	}

	@Override
	public String toString() {
		return "TipoNegozio [" + (id != null ? "id=" + id + ", " : "")
				+ (nomeTipo != null ? "nomeTipo=" + nomeTipo + ", " : "") + (negozi != null ? "negozi=" + negozi : "")
				+ "]";
	}

	
	/*@Override
	public String toString() {
		
		StringBuilder neg = new StringBuilder();
		for (Iterator<Negozio> itNeg = negozi.iterator(); itNeg.hasNext(); ) {
			neg.append(itNeg.next().toString());
		}
		return "Tipo Negozio: " + nomeTipo + "\n\tNegozi: " + neg.toString();
	}*/

	
}
