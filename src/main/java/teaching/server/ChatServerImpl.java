package teaching.server;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import teaching.client.ClientChat;

public class ChatServerImpl implements ChatServer {

	private List<ClientChat> cliList;

	public ChatServerImpl() {
		cliList = new ArrayList<ClientChat>();
	}

	public void addClient(ClientChat cli) {
		cliList.add(cli);
	}

	public void removeClient(ClientChat cli) {
		cliList.remove(cli);
	}

	public void sendMessage(String message) throws RemoteException {
		try {
			System.out.println("message " + message + " added by "
					+ UnicastRemoteObject.getClientHost());

			for (int i = 0; i < cliList.size(); i++) {
				cliList.get(i).callback(
						"Hi, I received [" + message + "] from "
								+ UnicastRemoteObject.getClientHost());
			}
		} catch (ServerNotActiveException e) {
			throw new RuntimeException(e);
		}

	}

}
