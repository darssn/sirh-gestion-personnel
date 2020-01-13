package dev.sgp.ecouteur;

import java.time.ZonedDateTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class Listener implements ServletContextListener {
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService depService = Constantes.DEP_SERVICE;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		
		collabService.sauvegarderCollaborateurs(new Collaborateur("bob", "bobby","2020-01-01","12 rue frf grdr", "123456789123456", "bobby.bob@test.com", ZonedDateTime.now()));
		depService.sauvegarderDepartement(new Departement(1,"Comptabilité"));
		depService.sauvegarderDepartement(new Departement(2,"Ressources Humaines"));
		depService.sauvegarderDepartement(new Departement(3,"Informatique"));
		depService.sauvegarderDepartement(new Departement(4,"Administratif"));
		

		System.out.println("demarrage");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
		System.out.println("arret");
		
	}

}
