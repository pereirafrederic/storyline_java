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

import fr.grappe.idee.application.model.dto.DomaineDTO;
import fr.grappe.idee.application.model.dto.GrappeDTO;
import fr.grappe.idee.application.model.dto.IdeeDTO;
import fr.grappe.idee.application.model.entity.AssociationEntity;
import fr.grappe.idee.application.model.entity.DomaineEntity;
import fr.grappe.idee.application.model.entity.GrappeEntity;
import fr.grappe.idee.application.model.entity.IdeeEntity;

@Service
public class MapperDomaine {

	@Autowired
	private MapperGrappe mapperGrappe;
	
	public DomaineDTO mapperUnitaire(DomaineEntity domaineEntity) {
		DomaineDTO retour = new DomaineDTO();
		retour.setNom(domaineEntity.getNom());
		retour.setId(domaineEntity.getId());
		for (GrappeEntity grappe : domaineEntity.getListeGrappe()) {
			retour.getListeGrappe().add(mapperGrappe.mapperUnitaire(grappe));
		}
		return retour;
	}
	
}
