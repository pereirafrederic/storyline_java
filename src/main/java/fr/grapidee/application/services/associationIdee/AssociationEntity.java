package fr.grapidee.application.services.associationIdee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.grapidee.application.services.grappe.GrappeEntity;
import fr.grapidee.application.services.idee.IdeeEntity;
import fr.grapidee.application.services.projet.ProjetEntity;

@Entity(name="asso")
@Table(name = "asso_idee", schema = "grapidee")
public class AssociationEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name = "idee_maitre_id")
	private IdeeEntity ideeMaitre;
	
	@ManyToOne
	@JoinColumn(name = "idee_esclave_id")
	private IdeeEntity ideeEsclave;
	
	@ManyToOne
	@JoinColumn(name="grappe_id")
	private GrappeEntity grappe;
	
	
	@ManyToOne
	@JoinColumn(name="projet_id")
	private ProjetEntity projet;

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
