package fr.grappe.idee.application.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="domaine")
@Table(name = "domaine", schema = "grapidee")
public class DomaineEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "domaine", targetEntity = GrappeEntity.class)
	private List<GrappeEntity> listeGrappe;

	public List<GrappeEntity> getListeGrappe() {
		return listeGrappe;
	}

	public void setListeGrappe(List<GrappeEntity> listeGrappe) {
		this.listeGrappe = listeGrappe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
