package teaching.server;

import teaching.common.Config;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatServerRun {

	public static void main(String[] args) {

		try {
			// Creating the chat server remote object
			ChatServer srv = new ChatServerImpl();

			// Creating the chat server stub
			ChatServer stub = (ChatServer) 
									UnicastRemoteObject.exportObject(srv, 0);

			// Creating the registry
			Registry registry = LocateRegistry.createRegistry(Config.getInstance().getPort());

			// Adding the remote object into the registry
			registry.bind("chatServer", stub);

            System.out.println("Server running on host " + Config.getInstance().getServer() + ":" + Config.getInstance().getPort());

		} catch (RemoteException e) {
			throw new RuntimeException(e);
		} catch (AlreadyBoundException e) {
			throw new RuntimeException(e);
		}

	}

}
