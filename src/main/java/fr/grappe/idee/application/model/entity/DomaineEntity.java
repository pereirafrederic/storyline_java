package fr.grappe.idee.application.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fr.grappe.idee.application.model.dto.IdeeDTO;

@Entity
@Table(name = "domaine", schema = "grapidee")
public class DomaineEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "domaine", targetEntity = GrappeEntity.class)
	private List<GrappeEntity> listeGrappe;

	public List<GrappeEntity> getListeGrappe() {
		return listeGrappe;
	}

	public void setListeGrappe(List<GrappeEntity> listeGrappe) {
		this.listeGrappe = listeGrappe;
	}


	

}
