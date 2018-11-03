package fr.grapidee.application.services.idee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.grapidee.application.services.associationIdee.AssociationEntity;
import fr.grapidee.application.services.commun.CommunEntity;
import fr.grapidee.application.services.grappe.GrappeEntity;
import fr.grapidee.application.services.projet.ProjetEntity;

@Entity(name = "idee")
@Table(name = "idee", schema = "grapidee")
public class IdeeEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ideeMaitre", targetEntity = AssociationEntity.class)
	private List<AssociationEntity> listeAssoIdee;

	@ManyToOne
	@JoinColumn(name="grappe_id")
	private GrappeEntity grappe;
	
	public GrappeEntity getGrappe() {
		return grappe;
	}

	public void setGrappe(GrappeEntity grappe) {
		this.grappe = grappe;
	}

	@ManyToOne
	@JoinColumn(name="projet_id", nullable=true)
	private ProjetEntity projet;



	public ProjetEntity getProjet() {
		return projet;
	}

	public void setProjet(ProjetEntity projet) {
		this.projet = projet;
	}

	public List<AssociationEntity> getListeAssoIdee() {
		return listeAssoIdee;
	}

	public void setListeAssoIdee(List<AssociationEntity> listeAssoIdee) {
		this.listeAssoIdee = listeAssoIdee;
	}

	
	
}
