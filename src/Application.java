import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	
	public static final int _PORT_RESERVER = 2500;
	public static final int _PORT_EMPRUNTER = 2600;
	public static final int _PORT_RENDRE = 2700;
	
	public static Bibliotheque creerBibliotheque(){
		List<Document> list = new ArrayList<Document>();
		List<Abonne> listA = new ArrayList<Abonne>();
		
		Document d1 = new Livre(1,"Livre1");
		list.add(d1);
		d1 = new Livre(2,"Livre2");
		list.add(d1);
		d1 = new Livre(3,"Livre3");
		list.add(d1);
		d1 = new Livre(4,"Livre4");
		list.add(d1);
		d1 = new Livre(5,"Livre5");
		list.add(d1);
		
		Abonne a = new Abonne(1,"abonne1");
		listA.add(a);
		a = new Abonne(2,"abonne2");
		listA.add(a);
		a = new Abonne(3,"abonne3");
		listA.add(a);
		a = new Abonne(4,"abonne4");
		listA.add(a);
		
		return new Bibliotheque(listA,list);
	}
	
	
	
	public static void main(String[] args) {
		try {
			Bibliotheque b = creerBibliotheque();
			System.out.println("Connection au serveur !");
			
			IService s1 = new ServiceReserver(b);
			IService s2 = new ServiceEmprunter(b);
			IService s3 = new ServiceRendre(b);
			
			new Thread(new Serveur(_PORT_RESERVER,s1)).start();
			new Thread(new Serveur(_PORT_EMPRUNTER,s2)).start();
			new Thread(new Serveur(_PORT_RENDRE,s3)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}