package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.sgp.entite.Departement;

public class DepartementService {

	private List<Departement> listeDepartement = new ArrayList<>();



	public List<Departement> listerDepartement() {

		return this.listeDepartement;

	}

	public void sauvegarderDepartement(Departement dep) {

		listeDepartement.add(dep);

	}
	
	public Optional<Departement> rechercheDepartement(String nomDep){
		
		
		
		return listeDepartement.stream().filter(dep-> dep.getNom().equals(nomDep)).findAny();
		
	}

}
