package fr.grapidee.application.services.entite.idee;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.grapidee.application.services.association.AssoService;
import fr.grapidee.application.services.association.grappe.AssociationGrappeEntity;
import fr.grapidee.application.services.association.idee.AssociationIdeeEntity;
import fr.grapidee.application.services.association.idee.AssociationIdeeRepository;
import fr.grapidee.application.services.commun.CommunBodyDTO;
import fr.grapidee.application.services.commun.TypeChargement;
import fr.grapidee.application.services.entite.grappe.GrappeDTO;

@Service
public class IdeeService {

	private static final int NBRE_NIVEAU = 4;

	@Autowired
	private IdeeRepository repo;

	@Autowired
	private AssoService assoService;

	@Autowired
	private MapperIdee mapper;

	public IdeeDTO findOne(Long id, TypeChargement typeChargement) {
		return mapper.mappeOne(repo.findOne(id), typeChargement, NBRE_NIVEAU);
	}

	public List<IdeeDTO> findAll() {
		return mapper.mappeAll(repo.findAll(), NBRE_NIVEAU);
	}

	public IdeeDTO postOne(IdeeBodyDTO ideeDto) {

		IdeeEntity idee = mapper.mappeEntity(ideeDto);
		idee = repo.save(idee);

		if (null != ideeDto.getIdGrappe()) {
			assoService.associerGrappe(idee, ideeDto.getIdGrappe());
		}

		if (null != ideeDto.getIdIdeeMaitre()) {
			assoService.associerIdee(idee, ideeDto.getIdIdeeMaitre(),
					ideeDto.getLiaison(), ideeDto.getIdGrappeAsso());

		}
		return mapper.mappeOne(repo.findOne(idee.getId()),
				TypeChargement.BASIQUE, NBRE_NIVEAU);
	}

	public IdeeDTO putOne(IdeePutBodyDTO ideeDto) {
		IdeeEntity ideeExistante = repo.findOne(ideeDto.getId());
		IdeeEntity idee = mapper.mappeEntity(ideeExistante, ideeDto);
		idee = repo.save(idee);

		if (null != ideeDto.getIdGrappeAncienne()) {
			AssociationGrappeEntity assoGappeAncienne = idee
					.getListeAssoGrappe()
					.stream()
					.filter(assoGrappe -> assoGrappe.getIdee().getId() == ideeExistante
							.getId()
							&& assoGrappe.getGrappe().getId() == ideeDto
									.getIdGrappeAncienne()).findFirst().get();
			idee.getListeAssoGrappe().remove(assoGappeAncienne);
		}
		idee.getListeAssoGrappe()
				.add(assoService.associerGrappe(ideeExistante,
						ideeDto.getIdGrappe()));

		if (null != ideeDto.getIdIdeeMaitreAncienne()) {
			AssociationIdeeEntity assoIdeeAncienne = idee
					.getListeAssoIdee()
					.stream()
					.filter(assoIdee -> assoIdee.getIdeeMaitre().getId() == ideeDto
							.getIdIdeeMaitreAncienne()
							&& assoIdee.getIdeeEsclave().getId() == ideeExistante
									.getId()).findFirst().get();
			idee.getListeAssoIdee().remove(assoIdeeAncienne);
		}
		idee.getListeAssoIdee().add(
				assoService.associerIdee(ideeExistante,
						ideeDto.getIdIdeeMaitre(), ideeDto.getLiaison(),
						ideeDto.getIdGrappeAsso()));

		
		repo.save(idee);
		
		return mapper.mappeOne(repo.findOne(idee.getId()),
				TypeChargement.BASIQUE, NBRE_NIVEAU);
	}

	public void deleteOne(IdeeBodyDTO ideeDto) {
		IdeeEntity ideeExistante = repo.findOne(ideeDto.getId());
		//ideeExistante.getListeAssoGrappe().clear();
		//ideeExistante.getListeAssoIdee().clear();
		repo.delete(ideeExistante);
	
	}

}
