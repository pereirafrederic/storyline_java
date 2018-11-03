package fr.grapidee.application.services.tag;

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
@RequestMapping(value = "/grapidee/tag")
public class ControllerTag {

	
	@Autowired
	private TagService tagService;
		
	@RequestMapping( method = RequestMethod.GET)
	public List<CommunDTO> recupererTousTag() {
		return this.tagService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TagDTO recupererGrappe(@PathVariable Long id, @RequestParam (value="niveauInferieur", required=false) Integer niveauInferieur ) {
		niveauInferieur = RequestParamUtils.getNiveauInferieur(niveauInferieur);
		return this.tagService.findOne(id, niveauInferieur);
	}

	@RequestMapping(method = RequestMethod.POST)
	public TagDTO creerTag(@RequestBody TagBodyDTO tag) throws Exception {
		return this.tagService.postOne(tag);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public TagDTO majTag(@RequestBody  TagBodyDTO tag) throws Exception {
		return this.tagService.putOne(tag);
	}

}
