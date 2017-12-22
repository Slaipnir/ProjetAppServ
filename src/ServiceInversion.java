import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceInversion implements Runnable{
	
	Socket s;
	StringBuffer inverse;
	
	public ServiceInversion(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		try {
			PrintWriter socketOut = new PrintWriter(s.getOutputStream(),true);
			BufferedReader socketIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String str = new String("-1");
			
			while (!str.equals("non")) {
				socketOut.println("Veuillez rentrez un mot");
				str = socketIn.readLine();
				
				System.out.println("Le mot lu est : " + str);
				inverse = new StringBuffer(str);
				
				System.out.println("Le mot inversé est : " + inverse.reverse());				
				socketOut.println("Voici votre mot inverser : " + inverse + "##Voulez-vous continuer ?");

				str = socketIn.readLine();
			}
			System.out.println("On ferme le Service");
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
