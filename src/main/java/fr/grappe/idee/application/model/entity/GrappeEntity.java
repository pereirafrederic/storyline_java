package fr.grappe.idee.application.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.grappe.idee.application.model.dto.IdeeDTO;

@Entity
@Table(name = "grappe", schema = "grapidee")
public class GrappeEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "grappe", targetEntity = AssociationEntity.class)
	private List<AssociationEntity> listeIdee;
	
	@ManyToOne
	@JoinColumn(name = "id_domaine")
	private DomaineEntity domaine;

	public List<AssociationEntity> getListeIdee() {
		return listeIdee;
	}

	public void setListeIdee(List<AssociationEntity> listeIdee) {
		this.listeIdee = listeIdee;
	}

	public DomaineEntity getDomaine() {
		return domaine;
	}

	public void setDomaine(DomaineEntity domaine) {
		this.domaine = domaine;
	}
	

}
