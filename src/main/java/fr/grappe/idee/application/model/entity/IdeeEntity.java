package fr.grappe.idee.application.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "idee")
@Table(name = "idee", schema = "grapidee")
public class IdeeEntity extends CommunEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "ideeMaitre", targetEntity = AssociationEntity.class)
	private List<AssociationEntity> listeAssoIdee;

	private Boolean projet = false;

	@Column(length = 3000, nullable = false, updatable = true, insertable = true)
	private String contenu;
	
	@ManyToOne
	@JoinColumn(name="id_tag")
	private TagEntity tag;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TagEntity getTag() {
		return tag;
	}

	public void setTag(TagEntity tag) {
		this.tag = tag;
	}

}
