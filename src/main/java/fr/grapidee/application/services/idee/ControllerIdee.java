package fr.grapidee.application.services.idee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.grapidee.application.utilitaire.params.RequestParamUtils;

@RestController
@RequestMapping(value = "/grapidee/idee")
public class ControllerIdee {

	@Autowired
	private IdeeService ideeService;

	@RequestMapping(method = RequestMethod.POST)
	public IdeeDTO creerIdee(@RequestBody IdeeBodyDTO idee) {
		return this.ideeService.postOne(idee);
	}
	
	
	@RequestMapping( method = RequestMethod.GET)
	public List<IdeeDTO>  recupererIdees() {		
		return this.ideeService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public IdeeDTO recupererIdee(@PathVariable Long id,
			@RequestParam(value = "niveauInferieur", required = false) Integer niveauInferieur) {
		niveauInferieur = RequestParamUtils.getNiveauInferieur(niveauInferieur);
		return this.ideeService.findOne(id, niveauInferieur);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public IdeeDTO majIdee(@RequestBody IdeeBodyDTO idee) {
		return this.ideeService.putOne(idee);
	}
}
