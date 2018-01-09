import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceReserver implements IService {
	
	Socket s;
	Bibliotheque b;
	
	public ServiceReserver(Bibliotheque b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		try {
			PrintWriter socketOut = new PrintWriter(s.getOutputStream(),true);	
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str;
			int numAbo;
			int numLivre;
			
			socketOut.println("Veuillez rentrer votre numéro d'abonné");
			str = socketIn.readLine();
			numAbo = Integer.parseInt(str);
			Abonne a = b.getAbo(numAbo);
			
			
			socketOut.println("Bonjour Monsieur " + a.getNom() + ",##Veuillez rentrer le numéro du livre à reserver");
			str = socketIn.readLine();
			numLivre = Integer.parseInt(str);
			b.getDoc(numLivre).reserver(a);
			
			
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch( PasLibreException e){
			e.printStackTrace();
		}
	}

	@Override
	public void setSocket(Socket s) {
		this.s = s;
	}

}
