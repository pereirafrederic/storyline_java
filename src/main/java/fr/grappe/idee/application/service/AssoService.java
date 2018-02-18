package fr.grappe.idee.application.service;

import fr.grappe.idee.application.model.body.AssoBodyDTO;
import fr.grappe.idee.application.model.body.AssoIdeeBodyDTO;

public interface AssoService {

	AssoBodyDTO putOne(AssoBodyDTO asso);

	AssoBodyDTO postOne(AssoBodyDTO asso) throws Exception;

	AssoBodyDTO creerAssoIdee(AssoIdeeBodyDTO assoIdee) throws Exception;

	AssoBodyDTO injecterAsso(String nomMaitre, String nomEsclave, String nomGrappe) throws Exception;

}
