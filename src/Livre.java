
public class Livre implements Document {
	private int id;
	private String nom;
	private int etat; // 0  = libre, 1 = reserv�, 2 = emprunt�
	private Abonne ab;
	
	public Livre(int id, String nom){
		this.id = id;
		this.nom = nom;
		this.etat = 0;
		ab = null;
	}
	
	
	@Override
	public int numero() {
		return id;
	}

	@Override
	public void reserver(Abonne ab) throws PasLibreException {
		if ( (this.etat == 1 && !this.ab.equals(ab)) || this.etat == 2)
			throw new PasLibreException(this);
		this.etat = 1;
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		if (this.etat == 1 && !this.ab.equals(ab))
			throw new PasLibreException(this);
		this.etat = 2;
	}

	@Override
	public void retour() {
		etat = 0;
	}

	public int getEtat() {
		return etat;
	}
	
	
	public int getId(){
		return this.id;
	}
}
