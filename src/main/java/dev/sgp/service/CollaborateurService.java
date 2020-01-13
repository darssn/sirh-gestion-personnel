package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {
	
	
	private List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	

	
	public List<Collaborateur> listerCollaborateurs(){
		
		return this.listeCollaborateurs;
		
	}
	
	
	public void sauvegarderCollaborateurs(Collaborateur col){
		
		listeCollaborateurs.add(col);
		
		
	}
	
	
	public Optional<Collaborateur> rechercheCollaborateur(String matricule){
		
		
			return listeCollaborateurs.stream().filter(col -> col.getMatricule().equals(matricule)).findAny();
	
		
	}

}
 