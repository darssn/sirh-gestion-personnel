package dev.sgp.service;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

		
	return (int) listeVisiteWeb.stream().filter(visW -> visW.getChemin().equals(chemin)).collect(Collectors.summarizingDouble(VisiteWeb::getTempsExecution)).getAverage();
	
	}

	public int tMin(String chemin) {
	
		
		return (int)listeVisiteWeb.stream().filter(visW -> visW.getChemin().equals(chemin)).collect(Collectors.summarizingDouble(VisiteWeb::getTempsExecution)).getMin();

		

	}

	public int tMax(String chemin) {

		return (int)listeVisiteWeb.stream().filter(visW -> visW.getChemin().equals(chemin)).collect(Collectors.summarizingDouble(VisiteWeb::getTempsExecution)).getMax();

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
