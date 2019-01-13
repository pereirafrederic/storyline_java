package fr.grapidee.application.services.association;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.association.grappe.AssociationGrappeEntity;
import fr.grapidee.application.services.association.grappe.AssociationGrappeRepository;
import fr.grapidee.application.services.association.idee.AssociationIdeeEntity;
import fr.grapidee.application.services.association.idee.AssociationIdeeRepository;
import fr.grapidee.application.services.entite.grappe.GrappeRepository;
import fr.grapidee.application.services.entite.idee.IdeeEntity;
import fr.grapidee.application.services.entite.idee.IdeeRepository;

@Service
public class AssoService {

	@Autowired
	private AssociationIdeeRepository repoAssoIdee;
	
	@Autowired
	private AssociationGrappeRepository repoAssoGrappe;
	
	
	@Autowired
	private IdeeRepository repoIdee;
	
	@Autowired
	private GrappeRepository repoGrappe;
	
	public AssociationIdeeEntity associerIdee(IdeeEntity idee, Long idParent, String liaison, Long idGrappe) {
		
		AssociationIdeeEntity asso= new AssociationIdeeEntity();
		asso.setIdeeMaitre(repoIdee.findOne(idParent));
		asso.setIdeeEsclave(idee);
		if(null != idGrappe){
		asso.setGrappe(repoGrappe.findOne(idGrappe));
		}
		asso.setLiaison(liaison);
		
		return repoAssoIdee.save(asso);
		
	}

	public AssociationGrappeEntity associerGrappe(IdeeEntity idee, Long idGrappe) {
		AssociationGrappeEntity asso = new AssociationGrappeEntity();
		asso.setIdee(idee);
		asso.setGrappe(repoGrappe.findOne(idGrappe));

		return repoAssoGrappe.save(asso);
	}

	

}
