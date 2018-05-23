package teaching.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import teaching.client.ClientChat;

public interface ChatServer extends Remote {
	
	void addClient(ClientChat cli) throws RemoteException;
	void removeClient(ClientChat cli) throws RemoteException;
	void sendMessage(String message) throws RemoteException;

}
