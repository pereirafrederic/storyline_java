package fr.pereirafrederic.storyline.application.entity.acces;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import fr.pereirafrederic.storyline.application.entity.contenu.Evenement;
import fr.pereirafrederic.storyline.application.entity.user.Utilisateur;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity(name = "AccesEvenement")
@Table(name = "acces_evenement", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class AccesEvenement extends AbstractId {

	
	/**
	 * 
	 */
	static final long serialVersionUID = -6422730408713046220L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "ev_id")
	Evenement evenement;
	
	EnumEtatLecture etat;
}
