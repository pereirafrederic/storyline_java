package fr.grapidee.application.services.associationIdee;

public class AssoBodyDTO {

	private Long id;
	private Long idMaitre;
	private Long idEsclave;
	private Long idGrappe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMaitre() {
		return idMaitre;
	}

	public void setIdMaitre(Long idMaitre) {
		this.idMaitre = idMaitre;
	}

	public Long getIdEsclave() {
		return idEsclave;
	}

	public void setIdEsclave(Long idEsclave) {
		this.idEsclave = idEsclave;
	}

	public Long getIdGrappe() {
		return idGrappe;
	}

	public void setIdGrappe(Long idGrappe) {
		this.idGrappe = idGrappe;
	}

}
