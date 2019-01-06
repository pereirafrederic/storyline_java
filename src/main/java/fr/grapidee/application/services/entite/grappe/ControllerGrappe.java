package fr.grapidee.application.services.entite.grappe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.grapidee.application.services.commun.dto.CommunDTO;

@RestController
@RequestMapping(value = "/grapidee/grappe")
public class ControllerGrappe {

	@Autowired
	private GrappeService grappeService;

	/*@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public GrappeDTO creerGrappe(@RequestBody GrappeBodyDTO grappe)
			throws Exception {
		return this.grappeService.postOne(grappe);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@Transactional
	public GrappeDTO majGrappe(@RequestBody GrappeBodyDTO grappe)
			throws Exception {
		return this.grappeService.putOne(grappe);
	}*/

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GrappeDTO recupererGrappe(@PathVariable Long id) {
		return this.grappeService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CommunDTO> recupererToutesGrappes() {
		return this.grappeService.findAll();
	}

}
