package Bibliotheque;
public class PasLibreException extends Exception {
	
	private Livre l;
	
	public PasLibreException(Livre l){
		super();
		this.l = l;
	}
	
	public String toString(){
		if (l.getEtat() == 1)
			return "Le livre est reserv� par une personne";
		else
			return "le livre a d�ja �t� emprunt� par une personne";
	}
}
