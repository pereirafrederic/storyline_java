package fr.grapidee.application.services.entite.idee;

import java.util.ArrayList;
import java.util.List;

import fr.grapidee.application.services.association.idee.IdeeEsclaveDTO;
import fr.grapidee.application.services.commun.dto.CommunDTO;
import fr.grapidee.application.services.entite.grappe.GrappeDTO;

public class IdeeDTO extends CommunDTO {

	private OganisationIdeeDTO Idees;

	private List<GrappeDTO> grappes = new ArrayList<GrappeDTO>();

	public List<GrappeDTO> getGrappes() {
		return grappes;
	}

	public void setGrappes(List<GrappeDTO> grappes) {
		this.grappes = grappes;
	}

	public OganisationIdeeDTO getIdees() {
		return Idees;
	}

	public void setIdees(OganisationIdeeDTO idees) {
		Idees = idees;
	}

}
