package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {
	
	
	private List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	
	public List<Collaborateur> listerCollaborateurs(){
		
		return this.listeCollaborateurs;
		
	}
	
	
	public void sauvegarderCollaborateurs(Collaborateur col){
		
		listeCollaborateurs.add(col);
		
		
	}
	

}
 