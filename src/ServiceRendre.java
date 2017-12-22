import java.net.Socket;

public class ServiceRendre implements IService{
	
	Socket s;
	Bibliotheque b;
	
	public ServiceRendre(Bibliotheque b) {
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
