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

public class EditerCollaborateurController extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricule = req.getParameter("matricule");
		
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		
		Map<String,String> mapParam = new HashMap<>();
		
		mapParam.put("titre",titre);
		mapParam.put("nom",nom);
		mapParam.put("matricule",matricule);
		mapParam.put("prenom",prenom);
		

		resp.getWriter().write( "<h1>Liste des collaborateurs</h1>");
	
		
		
		if (matricule == null || titre == null || nom == null || prenom == null) {

			resp.setStatus(400);
			resp.getWriter().write("<p>Les paramètres suivant sont incorrects : </p>");
			if(matricule == null){
				resp.getWriter().write("<p>Matricule</p>");
			}
			if(titre ==null){
				resp.getWriter().write("<p>Titre</p>");
			}
			
			if(nom == null){
				
				resp.getWriter().write("<p>Nom</p>");
			}
			
			if (prenom == null){
				resp.getWriter().write("<p>Prenom</p>");
				
			}
			
			

		}else{
			
			resp.setStatus(200);
			resp.getWriter().write("<p>Creation d'un collaborateur avec les informations suivantes : </p>");
			resp.getWriter().write("<p>Matricule="+ matricule +",titre="+titre+",nom="+nom+",prenom="+prenom+"</p>");
			
		}
		

	}

}
