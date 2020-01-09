package dev.sgp.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class NouveauCollaborateurController extends HttpServlet {

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("nom","");
		req.setAttribute("prenom", "");
		req.setAttribute("dateN","");
		req.setAttribute("adresse","");
		req.setAttribute("numSS","");
		
		req.setAttribute("checkNom",true);
		req.setAttribute("checkPrenom",true);
		req.setAttribute("checkDateN",true);
		req.setAttribute("checkAdresse",true);
		req.setAttribute("checkNumSS",true);
		
		
		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp").forward(req, resp);
	

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		
		ResourceBundle data = ResourceBundle.getBundle("application");		

		boolean check = true;

		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String dateNaissance = req.getParameter("dateNaissance");
		String adresse = req.getParameter("adresse");
		String numSS = req.getParameter("numSS");

		String emailPro = prenom + "." + nom +"@"+data.getString("email");
		ZonedDateTime date = ZonedDateTime.now();

		if (("".equals(nom.trim()) || nom == null)) {
			
			req.setAttribute("nom",nom);
			req.setAttribute("checkNom",false);
			check = false;
		}else{
			req.setAttribute("nom",nom);
			req.setAttribute("checkNom",true);
			
		}

		if (("".equals(prenom.trim()) || prenom == null)) {
			
			req.setAttribute("prenom",prenom);
			req.setAttribute("checkPrenom",false);
			
			check = false;
		}else{
			
			req.setAttribute("checkPrenom",true);
			req.setAttribute("prenom",prenom);
		}
		
		if (("".equals(dateNaissance.trim()) || dateNaissance == null)) {	

			req.setAttribute("checkDateN",false);
			req.setAttribute("dateN",dateNaissance);
			check = false;
		}else{
			req.setAttribute("checkDateN",true);
			req.setAttribute("dateN",dateNaissance);
			
		}
		
		if (("".equals(adresse.trim()) || adresse == null)) {
			req.setAttribute("checkAdresse",false);
			req.setAttribute("adresse",adresse);
			check = false;
		}else{
			req.setAttribute("checkAdresse",true);
			req.setAttribute("adresse",adresse);
		}

		if (!numSS.matches("[0-9]+") || numSS.length() != 15) {
			req.setAttribute("checkNumSS",false);
		
			req.setAttribute("numSS",numSS);
			check = false;
		}else{
			req.setAttribute("checkNumSS",true);
			req.setAttribute("numSS",numSS);
		}
		
		

		if (check == true) {

			collabService.sauvegarderCollaborateurs(new Collaborateur(nom, prenom, dateNaissance, adresse, numSS, emailPro, date));
				
			resp.sendRedirect(req.getContextPath()+"/collaborateurs/lister");
			

		}else{
			
			
			resp.setStatus(400);
			req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp").forward(req,resp);
			
			
			//resp.sendRedirect(req.getContextPath()+"/collaborateurs/nouveau");
			
		}
		
	}

}
