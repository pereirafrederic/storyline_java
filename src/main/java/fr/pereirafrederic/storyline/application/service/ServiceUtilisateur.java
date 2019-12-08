package fr.pereirafrederic.storyline.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.pereirafrederic.storyline.application.entity.contenu.Livre;
import fr.pereirafrederic.storyline.application.entity.user.Utilisateur;

@Service
public class ServiceUtilisateur {
	
	@Autowired
	private RepositoryUtilisateur repositoryUtilisateur;

	public Utilisateur recupererUtilisateur(Long id) throws Exception {
		Utilisateur utilisateur = repositoryUtilisateur.findById(id).orElseThrow(() -> new Exception(""));;
		
		return utilisateur;
	}

	public List<Livre> recupererLivres(Long id) throws Exception {

		Utilisateur utilisateur =recupererUtilisateur(id);
		
		List<Livre> retour =new ArrayList<Livre>();
		utilisateur.getAccesLivres().stream().forEach(acces -> retour.add(acces.getLivre()));
		return retour;
	}


}
