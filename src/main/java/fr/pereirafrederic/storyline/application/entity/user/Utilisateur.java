package fr.pereirafrederic.storyline.application.entity.user;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.*;
import lombok.experimental.FieldDefaults;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import fr.pereirafrederic.storyline.application.entity.acces.AccesEvenement;
import fr.pereirafrederic.storyline.application.entity.acces.AccesLivre;
import fr.pereirafrederic.storyline.application.entity.commun.AbstractId;

@Entity(name = "utilisateur")
@Table(name = "utilisateur", schema = "storyline")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Utilisateur extends AbstractId {

	 static final long serialVersionUID = 7651345125628872606L;

	@NotNull
	 String nom;

	@NotNull
	 String email;

	@NotNull
	@Column(name = "mot_passe")
	 String motDePasse;

	@NotNull
	 Date dateInscription;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur", targetEntity = AccesLivre.class)
	private List<AccesLivre> accesLivres;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur", targetEntity = AccesEvenement.class)
	 List<AccesEvenement> accesEvenements;
}
