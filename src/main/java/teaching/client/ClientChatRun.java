package teaching.client;

import teaching.common.Config;

public class ClientChatRun {

	public static void main(String[] args) {

		if(args.length > 0) {
			updateParams(args);
		}
		new ClientChatImpl();

	}

	private static void updateParams(String[] args) {
		Config.getInstance().setServer(args[0]);
		if(args.length > 1) {
			Config.getInstance().setPort(Integer.parseInt(args[1]));
		}
	}
}
