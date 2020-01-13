package dev.sgp.entite;

public class Stats {

	
	private String path;
	private int nbVisite;
	private int tempsMin;
	private int tempsMax;
	private int moyenne;
	
	
	public Stats(String path,int nbV,int tMin,int tMax,int moy){
		
		this.path = path;
		this.nbVisite = nbV;
		this.tempsMin = tMin;
		this.tempsMax = tMax;
		this.moyenne =moy ;
		
		
	}


	/**Getter
	 * @return the path
	 */
	public String getPath() {
		return path;
	}


	/**Setter
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}


	/**Getter
	 * @return the nbVisite
	 */
	public int getNbVisite() {
		return nbVisite;
	}


	/**Setter
	 * @param nbVisite the nbVisite to set
	 */
	public void setNbVisite(int nbVisite) {
		this.nbVisite = nbVisite;
	}


	/**Getter
	 * @return the tempsMin
	 */
	public int getTempsMin() {
		return tempsMin;
	}


	/**Setter
	 * @param tempsMin the tempsMin to set
	 */
	public void setTempsMin(int tempsMin) {
		this.tempsMin = tempsMin;
	}


	/**Getter
	 * @return the tempsMax
	 */
	public int getTempsMax() {
		return tempsMax;
	}


	/**Setter
	 * @param tempsMax the tempsMax to set
	 */
	public void setTempsMax(int tempsMax) {
		this.tempsMax = tempsMax;
	}


	/**Getter
	 * @return the moyenne
	 */
	public int getMoyenne() {
		return moyenne;
	}


	/**Setter
	 * @param moyenne the moyenne to set
	 */
	public void setMoyenne(int moyenne) {
		this.moyenne = moyenne;
	}
	
}
