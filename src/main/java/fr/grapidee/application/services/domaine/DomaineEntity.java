package fr.grapidee.application.services.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.grapidee.application.services.commun.CommunEntity;
import fr.grapidee.application.services.grappe.GrappeEntity;

@Entity(name="domaine")
@Table(name = "domaine", schema = "grapidee")
public class DomaineEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "domaine", targetEntity = GrappeEntity.class)
	private List<GrappeEntity> listeGrappe;

	public List<GrappeEntity> getListeGrappe() {
		return listeGrappe;
	}

	public void setListeGrappe(List<GrappeEntity> listeGrappe) {
		this.listeGrappe = listeGrappe;
	}


	

}
