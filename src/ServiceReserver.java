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
			
			socketOut.println("Veuillez rentrer votre numéro d'abonné");
			str = socketIn.readLine();
			numAbo = Integer.parseInt(str);
			
			
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
