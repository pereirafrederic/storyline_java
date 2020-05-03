package fr.pereirafrederic.storyline.application.entity.acces;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;
import fr.pereirafrederic.storyline.application.entity.contenu.Livre;
import fr.pereirafrederic.storyline.application.entity.user.Utilisateur;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity(name = "AccesLivre")
@Table(name = "acces_livre", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class AccesLivre extends AbstractId {

	
	/**
	 * 
	 */
	static final long serialVersionUID = -6422730408713046220L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	Livre livre;
	
	EnumEtatLecture etat;

}
