package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Collaborateur {
	
	

	private String matricule;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String adresse;
	private String numSS;
	private String emailPro;	
	private ZonedDateTime dateHeureCreation;
	private String intitulePoste;
	private Departement departement;
	
	private String photo = "photo.png";
	private boolean actif = true ;
	
	public Collaborateur(String nom,String prenom,String dateNaissance,String adresse,String numSS,String email,ZonedDateTime date){
		
		this.matricule = UUID.randomUUID().toString();
		this.nom=nom;
		this.prenom = prenom;
		this.dateNaissance = LocalDate.parse(dateNaissance);
		this.adresse = adresse;
		this.numSS = numSS;
		this.dateHeureCreation = date;
		this.emailPro =email;
		
	}

	/**Getter
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**Getter
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**Getter
	 * @return the numSS
	 */
	public String getNumSS() {
		return numSS;
	}

	/**Setter
	 * @param numSS the numSS to set
	 */
	public void setNumSS(String numSS) {
		this.numSS = numSS;
	}

	/**Getter
	 * @return the emailPro
	 */
	public String getEmailPro() {
		return emailPro;
	}

	/**Setter
	 * @param emailPro the emailPro to set
	 */
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	/**Getter
	 * @return the dateHeureCreation
	 */
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**Setter
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**Getter
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**Setter
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**Getter
	 * @return the actif
	 */
	public boolean isActif() {
		return actif;
	}

	/**Setter
	 * @param actif the actif to set
	 */
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	

}
