import java.net.Socket;

public class ServiceEmprunter implements IService {
	
	Socket s;
	Bibliotheque b;
	
	public ServiceEmprunter(Bibliotheque b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSocket(Socket s) {
		this.s = s;
	}

}
