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
		
		resp.getWriter().write("<h1>Edition de collaborateur</h1>");
		
		if(matricule == null || "".equals(matricule.trim())){
			
			resp.setStatus(400);
			resp.getWriter().write("<p>Un matricule est attendu </p>");
			
			
		}else{
								
			resp.setStatus(200);			
			resp.getWriter().write("<p>Matricule : "+matricule+"  </p>");
		}
		
		

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");

		Map<String, String> mapParam = new HashMap<>();

		mapParam.put("titre", titre);
		mapParam.put("nom", nom);
		mapParam.put("matricule", matricule);
		mapParam.put("prenom", prenom);

		resp.getWriter().write("<h1>Liste des collaborateurs</h1>");

		boolean isParam = true;

		String chaine = "";

		for (String par : mapParam.keySet()) {

			if (mapParam.get(par) == null) {

				if (isParam == true) {
					isParam = false;
					chaine += "<p>Les paramètres suivant sont incorrects : </p>";
				}

				chaine += "<p>" + par + "</p>";

			}
		}

		if (isParam == false) {

			resp.setStatus(400);
				
		} else {

			resp.setStatus(201);
			chaine += "<p>Creation d'un collaborateur avec les informations suivantes :</p>";
			
			for (String par : mapParam.keySet()) {
					chaine +="<p>"+par+"="+mapParam.get(par)+"</p>";				
			}
			

		}
		
		resp.getWriter().write(chaine);
	}
	
	

}
