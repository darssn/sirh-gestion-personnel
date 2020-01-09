package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {
	
	
	private List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	
	public CollaborateurService(){
		
		listeCollaborateurs.add(new Collaborateur("bob", "bobby","2020-01-01","12 rue frf grdr", "123456789123456", "bobby.bob@test.com", ZonedDateTime.now()));
	}
	
	
	
	public List<Collaborateur> listerCollaborateurs(){
		
		return this.listeCollaborateurs;
		
	}
	
	
	public void sauvegarderCollaborateurs(Collaborateur col){
		
		listeCollaborateurs.add(col);
		
		
	}
	
	
	public Collaborateur rechercheCollaborateur(String matricule){
		
		
		Collaborateur c  = null;
		
		for(Collaborateur col : listeCollaborateurs){
			
			if(matricule.equals(col.getMatricule())){
							
				c = col;				
			}
				
		}
		
		return c ;
	}

}
 