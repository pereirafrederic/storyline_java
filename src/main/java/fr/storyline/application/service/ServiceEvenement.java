package fr.storyline.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.storyline.application.entity.acces.AccesEvenement;
import fr.storyline.application.entity.contenu.Evenement;
import fr.storyline.application.entity.user.Utilisateur;

@Service
public class ServiceEvenement {
	
	@Autowired
	private RepositoryEvenement repoEvenement;
	
	@Autowired
	private RepositoryAccesEvenement repoAccesEvenement;
	
	@Autowired
	private ServiceUtilisateur serviceUtilisateur;



	public Evenement recupererEvenement(Long id, Long idUser) {
		Utilisateur utilisateur = serviceUtilisateur.recupererUtilisateur(idUser);
		
		Boolean droitOK = utilisateur.getAccesEvenements().stream().anyMatch( acces -> acces.getEvenement().getId() == id);
		if(droitOK){
			return repoEvenement.findOne(id);
		}
		
		return null;
	}

	public List<Evenement> recupererEvenements(Long idUser, Long idTemps, Long idEspace) {
		Utilisateur utilisateur = serviceUtilisateur.recupererUtilisateur(idUser); 
		
		List<Evenement> liste=	repoEvenement.findByTempsAndEspace(idTemps, idEspace);
		
		List<Evenement> retour = new ArrayList<Evenement>();
		for (Evenement evenement : liste) {
			List<AccesEvenement> acces =repoAccesEvenement.findByUtilisateurAndEvenement(utilisateur.getId(), evenement.getId());
			retour.add(acces.get(0).getEvenement());
		}
	
		return retour;
	}


}
