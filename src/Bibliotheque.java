import java.util.List;

public class Bibliotheque {
	
	private List<Abonne> listAbo;
	private List<Document> listDoc;
	
	public Bibliotheque(List<Abonne> listAbo,List<Document> listDoc){
		this.listAbo = listAbo;
		this.listDoc = listDoc;
	}
	
	public void addDoc(Document d){
		listDoc.add(d);
	}
	
	
	public void addAbo(Abonne a){
		listAbo.add(a);
	}
}
