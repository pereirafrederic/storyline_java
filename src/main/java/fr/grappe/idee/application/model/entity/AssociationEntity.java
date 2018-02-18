package fr.grappe.idee.application.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="asso")
@Table(name = "association", schema = "grapidee")
public class AssociationEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_idee_maitre")
	private IdeeEntity ideeMaitre;
	
	@ManyToOne
	@JoinColumn(name = "id_idee_esclave")
	private IdeeEntity ideeEsclave;
	
	@ManyToOne
	@JoinColumn(name="id_grappe")
	private GrappeEntity grappe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IdeeEntity getIdeeMaitre() {
		return ideeMaitre;
	}

	public void setIdeeMaitre(IdeeEntity ideeMaitre) {
		this.ideeMaitre = ideeMaitre;
	}

	public IdeeEntity getIdeeEsclave() {
		return ideeEsclave;
	}

	public void setIdeeEsclave(IdeeEntity ideeEsclave) {
		this.ideeEsclave = ideeEsclave;
	}

	public GrappeEntity getGrappe() {
		return grappe;
	}

	public void setGrappe(GrappeEntity grappe) {
		this.grappe = grappe;
	}
	
	
}
