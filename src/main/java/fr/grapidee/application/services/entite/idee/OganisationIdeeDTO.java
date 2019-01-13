package fr.grapidee.application.services.entite.idee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.grapidee.application.services.association.idee.IdeeEsclaveDTO;
import fr.grapidee.application.services.commun.dto.CommunDTO;

public class OganisationIdeeDTO extends CommunDTO {

	private Map<Long, OganisationIdeeDTO> mapIdees = new HashMap<Long, OganisationIdeeDTO>();
	private List<IdeeEsclaveDTO> Idees = new ArrayList<IdeeEsclaveDTO>();

	public Map<Long, OganisationIdeeDTO> getMapIdees() {
		return mapIdees;
	}

	public void setMapIdees(Map<Long, OganisationIdeeDTO> mapIdees) {
		this.mapIdees = mapIdees;
	}

	public List<IdeeEsclaveDTO> getIdees() {
		return Idees;
	}

	public void setIdees(List<IdeeEsclaveDTO> idees) {
		Idees = idees;
	}

}
