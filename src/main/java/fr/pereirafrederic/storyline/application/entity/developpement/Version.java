package fr.pereirafrederic.storyline.application.entity.developpement;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Version")
@Table(name = "version", schema = "storyline")
public class Version extends AbstractVersionning {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651345125628872606L;

	@ManyToOne
	@JoinColumn(name = "dev_id")
	private Developpement developpement;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "version", targetEntity = Texte.class)
	private List<Texte> textes;

	public Developpement getDeveloppement() {
		return developpement;
	}

	public void setDeveloppement(Developpement developpement) {
		this.developpement = developpement;
	}

	public List<Texte> getTextes() {
		return textes;
	}

	public void setTextes(List<Texte> textes) {
		this.textes = textes;
	}

}
