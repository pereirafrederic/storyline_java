package fr.grapidee.application.services.domaine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.grapidee.application.services.commun.CommunDTO;
import fr.grapidee.application.utilitaire.params.RequestParamUtils;

@RestController
@RequestMapping(value = "/grapidee/domaine")
public class ControllerDomaine {

	
	@Autowired
	private DomaineService domaineService;

	
	@RequestMapping(method = RequestMethod.GET)
	public List<CommunDTO> recupererToutesDomaines() {
		return this.domaineService.findAll();
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DomaineDTO recupererDomaine(@PathVariable Long id,  @RequestParam (value="niveauInferieur", required=false) Integer niveauInferieur ) {
		
		niveauInferieur = RequestParamUtils.getNiveauInferieur(niveauInferieur);
		return this.domaineService.findOne(id,niveauInferieur);
	}

	@RequestMapping( method = RequestMethod.POST)
	public DomaineDTO creerDomaine(@RequestBody DomaineBodyDTO domaine) throws Exception {
		return this.domaineService.postOne(domaine);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public DomaineDTO majDomaine(@RequestBody DomaineBodyDTO domaine) throws Exception {
		return this.domaineService.putOne(domaine);
	}
	
	
}
