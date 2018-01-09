
public class Livre implements Document {
	private int id;
	private String nom;
	private int etat; // 0  = libre, 1 = reservé, 2 = emprunté
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
	public synchronized void reserver(Abonne ab) throws PasLibreException {
		if ( (this.etat == 1 && !ab.equals(this.ab)) || this.etat == 2)
			throw new PasLibreException(this);
		this.etat = 1;
		this.ab = ab;
	}

	@Override
	public synchronized void emprunter(Abonne ab) throws PasLibreException {
		if (this.etat == 1 && !ab.equals(this.ab))
			throw new PasLibreException(this);
		this.etat = 2;
		this.ab = ab;
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
