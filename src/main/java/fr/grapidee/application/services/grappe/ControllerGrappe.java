package fr.grapidee.application.services.grappe;

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
@RequestMapping(value = "/grapidee/grappe")
public class ControllerGrappe {

	@Autowired
	private GrappeService grappeService;
	
		@RequestMapping( method = RequestMethod.GET)
	public List<CommunDTO> recupererToutesGrappes() {
		return this.grappeService.findAll();
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GrappeDTO recupererGrappe(@PathVariable Long id, @RequestParam (value="niveauInferieur", required=false) Integer niveauInferieur ) {
		niveauInferieur = RequestParamUtils.getNiveauInferieur(niveauInferieur);
		return this.grappeService.findOne(id, niveauInferieur);
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public GrappeDTO creerGrappe(@RequestBody GrappeBodyDTO grappe) throws Exception {
		return this.grappeService.postOne(grappe);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public GrappeDTO majGrappe(@RequestBody GrappeBodyDTO grappe) throws Exception {
		return this.grappeService.putOne(grappe);
	}
	
}
