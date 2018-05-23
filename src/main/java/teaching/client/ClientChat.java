package teaching.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientChat extends Remote {
	
	void callback(String msg) throws RemoteException;

}
