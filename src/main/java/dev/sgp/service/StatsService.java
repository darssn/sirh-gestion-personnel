package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.sgp.entite.VisiteWeb;

public class StatsService {

	private List<VisiteWeb> listeVisiteWeb = new ArrayList<>();

	public List<VisiteWeb> listerVisiteWeb() {

		return this.listeVisiteWeb;

	}

	public void sauvegarderVisiteWeb(VisiteWeb visite) {

		listeVisiteWeb.add(visite);

	}

	public int nbVisite(String chemin) {

		return (int) listeVisiteWeb.stream().filter(visW -> visW.getChemin().equals(chemin)).count();

	}

	public int moyenneVisite(String chemin) {

		return (int) (listeVisiteWeb.stream().filter(visW -> visW.getChemin().equals(chemin))
				.map(visW -> visW.getTempsExecution()).reduce((x, y) -> x + y).get()) / nbVisite(chemin);

	}

	public int tMin(String chemin) {
		int result = 0;
		boolean val = true;

		for (VisiteWeb vW : listeVisiteWeb) 
		{
			if (val == true && vW.getChemin().equals(chemin)) {

				result = vW.getTempsExecution();
				val = false;
			}
			

			if (vW.getChemin().equals(chemin) && vW.getTempsExecution() < result) {

				result = vW.getTempsExecution();
			}

		}
		return result;

	}

	public int tMax(String chemin) {

		int result = 0;
		boolean val = true;

		for (VisiteWeb vW : listeVisiteWeb) {
			
		
			
			if (val == true && vW.getChemin().equals(chemin)) {
				
				result = vW.getTempsExecution();
				val = false;
				
			}

			if (vW.getChemin().equals(chemin) && vW.getTempsExecution() > result) {
				
				

				result = vW.getTempsExecution();
				
			}

		}
		
		return result;

	}

	public List<String> distinctPath() {

		List<String> list = new ArrayList<>();

		for (VisiteWeb vW : listeVisiteWeb) {

			boolean exist = false;

			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).equals(vW.getChemin())) {

					exist = true;

				}

			}

			if (exist == false) {

				list.add(vW.getChemin());

			}

		}
		return list;
	}

}
