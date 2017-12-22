import java.net.Socket;

public class ServiceEmprunter implements IService {
	
	Socket s;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSocket(Socket s) {
		this.s = s;
	}

}
