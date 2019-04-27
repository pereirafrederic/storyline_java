package fr.storyline.application.entity.acces;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.storyline.application.entity.commun.AbstractId;
import fr.storyline.application.entity.contenu.Livre;
import fr.storyline.application.entity.user.Utilisateur;

@Entity(name = "AccesLivre")
@Table(name = "acces_livre", schema = "storyline")
public class AccesLivre extends AbstractId {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6422730408713046220L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Livre livre;
	
	private EnumEtatLecture etat;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public EnumEtatLecture getEtat() {
		return etat;
	}

	public void setEtat(EnumEtatLecture etat) {
		this.etat = etat;
	}


}
