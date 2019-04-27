package fr.storyline.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.storyline.application.entity.contenu.Livre;
import fr.storyline.application.entity.user.Utilisateur;

@Service
public class ServiceUtilisateur {
	
	@Autowired
	private RepositoryUtilisateur repositoryUtilisateur;

	public Utilisateur recupererUtilisateur(Long id) {
		Utilisateur utilisateur = repositoryUtilisateur.findOne(id);
		
		return utilisateur;
	}

	public List<Livre> recupererLivres(Long id) {

		Utilisateur utilisateur =recupererUtilisateur(id);
		
		List<Livre> retour =new ArrayList<Livre>();
		utilisateur.getAccesLivres().stream().forEach(acces -> retour.add(acces.getLivre()));
		return retour;
	}


}
