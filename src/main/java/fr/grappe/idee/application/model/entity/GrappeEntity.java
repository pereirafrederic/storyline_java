package fr.grappe.idee.application.model.entity;

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

@Entity(name="grappe")
@Table(name = "grappe", schema = "grapidee")
public class GrappeEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
