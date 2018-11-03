package fr.grapidee.application.services.grappe;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.grapidee.application.services.associationIdee.AssociationEntity;
import fr.grapidee.application.services.commun.CommunEntity;
import fr.grapidee.application.services.domaine.DomaineEntity;
import fr.grapidee.application.services.idee.IdeeEntity;

@Entity(name="grappe")
@Table(name = "grappe", schema = "grapidee")
public class GrappeEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;
	

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "grappe", targetEntity = IdeeEntity.class)
	private List<IdeeEntity> listeIdee;
	
	@ManyToOne
	@JoinColumn(name = "domaine_id")
	private DomaineEntity domaine;

	public List<IdeeEntity> getListeIdee() {
		return listeIdee;
	}

	public void setListeIdee(List<IdeeEntity> listeIdee) {
		this.listeIdee = listeIdee;
	}

	public DomaineEntity getDomaine() {
		return domaine;
	}

	public void setDomaine(DomaineEntity domaine) {
		this.domaine = domaine;
	}


}
