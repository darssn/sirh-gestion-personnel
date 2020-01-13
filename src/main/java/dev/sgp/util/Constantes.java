package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.StatsService;

public interface Constantes {
	
	
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	
	DepartementService DEP_SERVICE = new DepartementService();
	
	StatsService STATS_SERVICE = new StatsService();
	

}
