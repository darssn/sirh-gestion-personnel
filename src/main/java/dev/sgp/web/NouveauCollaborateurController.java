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
			check = false;
		}

		if (("".equals(prenom.trim()) || prenom == null)) {
			check = false;
		}
		
		if (("".equals(dateNaissance.trim()) || dateNaissance == null)) {			
			check = false;
		}
		
		if (("".equals(adresse.trim()) || adresse == null)) {
			check = false;
		}

		if (!numSS.matches("[0-9]+") || numSS.length() != 15) {
			check = false;
		}
		
		

		if (check == true) {

			collabService.sauvegarderCollaborateurs(new Collaborateur(nom, prenom, dateNaissance, adresse, numSS, emailPro, date));
				
			resp.sendRedirect("/sgp/collaborateurs/lister");
			

		}else{
			
			resp.setStatus(400);
			resp.sendRedirect("/sgp/collaborateurs/nouveau");
			
		}
		
	}

}
