package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Stats;
import dev.sgp.service.StatsService;
import dev.sgp.util.Constantes;

public class StatsController extends HttpServlet {

	private StatsService statsService = Constantes.STATS_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	List<Stats> listStats = new ArrayList<>();
		
	
	
	for(String chemin :	statsService.distinctPath()){
		
		String path = chemin;
		int nbVisite = statsService.nbVisite(chemin);
		int tempsMin = statsService.tMin(chemin);
		int tempsMax = statsService.tMax(chemin);
		int moyenne = statsService.moyenneVisite(chemin);
		
		listStats.add(new Stats(path,nbVisite,tempsMin,tempsMax,moyenne));
		
	}
		
		req.setAttribute("stats",listStats);
		
		req.getRequestDispatcher("/WEB-INF/views/collab/stats.jsp").forward(req,resp);
		
		
		
		
		
	}

}
