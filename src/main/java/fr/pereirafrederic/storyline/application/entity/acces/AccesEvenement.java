package fr.pereirafrederic.storyline.application.entity.acces;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import fr.pereirafrederic.storyline.application.entity.contenu.Evenement;
import fr.pereirafrederic.storyline.application.entity.user.Utilisateur;

@Entity(name = "AccesEvenement")
@Table(name = "acces_evenement", schema = "storyline")
public class AccesEvenement extends AbstractId {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6422730408713046220L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "ev_id")
	private Evenement evenement;
	
	private EnumEtatLecture etat;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public EnumEtatLecture getEtat() {
		return etat;
	}

	public void setEtat(EnumEtatLecture etat) {
		this.etat = etat;
	}
	


}
