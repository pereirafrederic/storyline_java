package fr.storyline.application.entity.contenu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import fr.storyline.application.entity.commun.AbstractId;

@Entity(name = "CollectionLivre")
@Table(name = "collection_livre", schema = "storyline")
public class CollectionLivre extends AbstractId {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8457467724925851367L;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min=3, max=50)
	private String nom;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collectionLivre", targetEntity = Livre.class)
	private List<Livre> livres;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
	}
