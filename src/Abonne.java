
public class Abonne {
	private int id;
	private String nom;
	
	public Abonne(int id,String nom){
		this.id = id;
		this.nom = nom;
	}
	
	public boolean equals(Abonne a){
		return this.id == a.id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getNom(){
		return this.nom;
	}
}
