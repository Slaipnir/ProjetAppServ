import java.io.IOException;
import java.util.List;

public class Application {
	
	public static final int _PORT_RESERVER = 2500;
	public static final int _PORT_EMPRUNTER = 2600;
	public static final int _PORT_RENDRE = 2700;
	
	public static void main(String[] args) {
		List<Abonne> listAbo;
		try {
			System.out.println("Connection au serveur !");
			
			IService s1 = new ServiceReserver();
			IService s2 = new ServiceEmprunter();
			IService s3 = new ServiceRendre();
			
			new Thread(new Serveur(_PORT_RESERVER,s1)).start();
			new Thread(new Serveur(_PORT_EMPRUNTER,s2)).start();
			new Thread(new Serveur(_PORT_RENDRE,s3)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
