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

@Entity(name="tag")
@Table(name = "tag", schema = "grapidee")
public class TagEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tag", targetEntity = IdeeEntity.class)
	private List<IdeeEntity> listeIdee;
	
	@ManyToOne
	@JoinColumn(name = "id_grappe")
	private GrappeEntity grappe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<IdeeEntity> getListeIdee() {
		return listeIdee;
	}

	public void setListeIdee(List<IdeeEntity> listeIdee) {
		this.listeIdee = listeIdee;
	}

	public GrappeEntity getGrappe() {
		return grappe;
	}

	public void setGrappe(GrappeEntity grappe) {
		this.grappe = grappe;
	}


}
