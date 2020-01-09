package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

public class EditerCollaborateurController extends HttpServlet {

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE ;
	private DepartementService depService = Constantes.DEP_SERVICE ;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		Collaborateur col =  collabService.rechercheCollaborateur(req.getParameter("matricule"));
		
		req.setAttribute("collaborateur", col);
		
		
		req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
		
		

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String adresse = req.getParameter("adresse");
		String tel = req.getParameter("tel");
		String poste = req.getParameter("poste");
		String iban = req.getParameter("iban");
		String bic = req.getParameter("bic");
		String civ = req.getParameter("civ");
		
		Departement dep = depService.rechercheDepartement(req.getParameter("dep"));
		
		
		if( !("".equals(adresse)) && adresse != null){
			
			Collaborateur c = collabService.rechercheCollaborateur(req.getParameter("matricule"));
			
			c.setAdresse(adresse);
			c.setIntitulePoste(poste);
			c.setIban(iban);
			c.setBic(bic);
			c.setDepartement(dep);
			c.setCivilite(civ);
			c.setTelephone(tel);
					
		}
		
		
		
		
		resp.sendRedirect(req.getContextPath()+"/collaborateurs/lister");

	}
	
	

}
