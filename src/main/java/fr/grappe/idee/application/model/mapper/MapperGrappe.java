package fr.grappe.idee.application.model.mapper;

import java.util.ArrayList;import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.dto.IdeeDTO;
import fr.grappe.idee.application.model.entity.AssociationEntity;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import fr.grappe.idee.application.model.entity.IdeeEntity;

@Service
public class MapperGrappe {

	@Autowired
	private MapperIdee mapperIdee;
	
	public GrappeDTO mapperUnitaire(GrappeEntity grappe) {
		GrappeDTO retour = new GrappeDTO();
		retour.setNom(grappe.getNom());
		retour.setId(grappe.getId());
		for (AssociationEntity asso : grappe.getListeIdee()) {
			retour.getListeIdee().add(mapperIdee.mapperUnitaire(asso.getIdeeEsclave(), 1, 2));
		}
		return retour;
	}
	
}
