package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;


import dev.sgp.entite.Departement;

public class DepartementService {

	private List<Departement> listeDepartement = new ArrayList<>();

	public DepartementService() {

		remplirListe();
	}
	
	
	public void remplirListe(){
		
		listeDepartement.add(new Departement(1,"Comptabilité"));
		listeDepartement.add(new Departement(2,"Ressources Humaines"));
		listeDepartement.add(new Departement(3,"Informatique"));
		listeDepartement.add(new Departement(4,"Administratif"));
		
	}

	public List<Departement> listerDepartement() {

		return this.listeDepartement;

	}

	public void sauvegarderDepartement(Departement dep) {

		listeDepartement.add(dep);

	}

}
