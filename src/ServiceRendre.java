import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceRendre implements IService{
	
	Socket s;
	Bibliotheque b;
	
	public ServiceRendre(Bibliotheque b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		try {
			PrintWriter socketOut = new PrintWriter(s.getOutputStream(),true);
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = "";
			int numLivre;
			while(!str.equals("non")){
				socketOut.println("Donnez le numéro du livre à rendre");
				str = socketIn.readLine();
				numLivre = Integer.parseInt(str);
				b.getDoc(numLivre).retour();
				socketOut.println("Retour effectué !##Voulez vous rendre un autre livre");
				str = socketIn.readLine();
			}
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void setSocket(Socket s) {
		this.s = s;
	}

}
