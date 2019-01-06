package fr.grapidee.application.services.entite.idee;

import java.util.List;

import fr.grapidee.application.services.association.idee.IdeeEsclaveDTO;
import fr.grapidee.application.services.commun.dto.CommunDTO;
import fr.grapidee.application.services.entite.grappe.GrappeDTO;

public class IdeeDTO extends CommunDTO {

		private List<IdeeEsclaveDTO> Idees;
		
		private List<GrappeDTO> grappes;

		public List<IdeeEsclaveDTO> getIdees() {
			return Idees;
		}

		public void setIdees(List<IdeeEsclaveDTO> idees) {
			Idees = idees;
		}

		public List<GrappeDTO> getGrappes() {
			return grappes;
		}

		public void setGrappes(List<GrappeDTO> grappes) {
			this.grappes = grappes;
		}
		
		
}
