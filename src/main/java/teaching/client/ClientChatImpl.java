package teaching.client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import teaching.common.Config;
import teaching.server.ChatServer;

public class ClientChatImpl implements ClientChat  {


	public ClientChatImpl() {
		
		try {
			ChatServer svc = getService();
			ClientChat cliStub = (ClientChat) UnicastRemoteObject.exportObject(this,0);
			svc.addClient(cliStub);

            Scanner scanner = new Scanner(System.in);

			for(;;) {
                System.out.println("Enter the text to send to the server or q to quit: ");
                String input = scanner.nextLine();

                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    svc.removeClient(cliStub);
                    break;
                }

                svc.sendMessage(input);

            }

		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}

	}

	public void callback(String msg) throws RemoteException {
		System.out.println("received: " + msg);
	}

	private static ChatServer getService() {
		try {
			ChatServer svc = (ChatServer) Naming
					.lookup("rmi://" + Config.getInstance().getServer() + ":" +
                            Config.getInstance().getPort() + "/chatServer");

			return svc;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error getting remote object"
					+ e.getMessage(), e);
		}
	}

}
