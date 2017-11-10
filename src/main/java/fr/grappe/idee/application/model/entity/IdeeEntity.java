package fr.grappe.idee.application.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "idee", schema = "grapidee")
public class IdeeEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;

	  @ManyToMany(fetch=FetchType.LAZY, mappedBy="ideeMaitre", targetEntity=AssociationEntity.class)
	private List<AssociationEntity> listeAssoIdee;

	//  @Convert(converter = BooleanConverter.class)
	  @Transient
	private Boolean projet = true;

	@Column(length = 3000, nullable = false, updatable = true, insertable = true)
	private String contenu;


	public Boolean getProjet() {
		return projet;
	}

	public void setProjet(Boolean projet) {
		this.projet = projet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public List<AssociationEntity> getListeAssoIdee() {
		return listeAssoIdee;
	}

	public void setListeAssoIdee(List<AssociationEntity> listeAssoIdee) {
		this.listeAssoIdee = listeAssoIdee;
	}
	
	

}
