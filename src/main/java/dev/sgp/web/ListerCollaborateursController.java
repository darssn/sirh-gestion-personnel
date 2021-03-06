package dev.sgp.web;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;




public class ListerCollaborateursController extends HttpServlet{
	
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE ;
	private DepartementService depService = Constantes.DEP_SERVICE;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			
		req.setAttribute("listeDep", depService.listerDepartement());
		req.setAttribute("listeCollab", collabService.listerCollaborateurs());
		
		
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req,resp);
		
		
		
		
	}
	
	
	
	
	

}
