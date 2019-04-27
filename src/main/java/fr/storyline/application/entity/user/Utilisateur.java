package fr.storyline.application.entity.user;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import fr.storyline.application.entity.acces.AccesEvenement;
import fr.storyline.application.entity.acces.AccesLivre;
import fr.storyline.application.entity.commun.AbstractId;

@Entity(name = "utilisateur")
@Table(name = "utilisateur", schema = "storyline")
@Getter
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur extends AbstractId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651345125628872606L;
	
	@NotBlank
	@NotNull
	@NotEmpty
	private String nom;
	@NotBlank
	@NotNull
	@NotEmpty
	private String email;
	@NotBlank
	@NotNull
	@NotEmpty
	@Column(name="mot_passe")
	private String motDePasse;
	@NotBlank
	@NotNull
	@NotEmpty
	private Date dateInscription;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur", targetEntity = AccesLivre.class)
	private List<AccesLivre> accesLivres;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur", targetEntity = AccesEvenement.class)
	private List<AccesEvenement> accesEvenements ;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public List<AccesLivre> getAccesLivres() {
		return accesLivres;
	}

	public void setAccesLivres(List<AccesLivre> accesLivres) {
		this.accesLivres = accesLivres;
	}

	public List<AccesEvenement> getAccesEvenements() {
		return accesEvenements;
	}

	public void setAccesEvenements(List<AccesEvenement> accesEvenements) {
		this.accesEvenements = accesEvenements;
	}
	


}
