package com.danco.server;

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.danco.controller.ISerializeController;
import com.danco.controller.api.IMainController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server {

	/** The Constant LOG1. */
	private final static Logger LOG1 = Logger.getLogger(Server.class.getName());
	private static final String EXCEPTION = "Exception";

	/** The Constant LOGER_PROPERTY_FILE_PATH. */
	private static final String LOGER_PROPERTY_FILE_PATH = "log4j.properties";

	private static final String SERVER_MESSAGE1 = "Waiting for a client...";

	private static final String SERVER_MESSAGE2 = "Got a client ...";

	public final static boolean isWorking = true;
	int serverPort;

	public Server(int serverPort) {
		this.serverPort = serverPort;
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */

	public void startServer() {

	    ServerSocket serverSocket = null;
		Socket clientSocket = null;
		ThreadForNewClient client = null;
		
		PropertyConfigurator.configure(LOGER_PROPERTY_FILE_PATH);
		MainStorage.setInstance(((ISerializeController) DependencyInjectionManager
						.getClassInstance(ISerializeController.class)).serialFromFile());
		
		IMainController mainController = (IMainController) DependencyInjectionManager
				.getClassInstance(IMainController.class);
		
		CommanDProcessor protocol = new CommanDProcessor(mainController);
		try {
			try {

				serverSocket = new ServerSocket(serverPort);
				System.out.println(SERVER_MESSAGE1);

				while (isWorking) {

					clientSocket = serverSocket.accept();
					System.out.println(SERVER_MESSAGE2);

					// create thread for connect client
					client = new ThreadForNewClient(clientSocket, protocol);
					
			
					client.thread.start();
					
					

				}
			} catch (Exception e) {
				
				LOG1.error(EXCEPTION, e);
			} finally {

				clientSocket.close();
				serverSocket.close();
				((ISerializeController) DependencyInjectionManager.getClassInstance(ISerializeController.class))
						.serialToFile(MainStorage.getInstance());
			}
		} catch (Exception e) {
		
			LOG1.error(EXCEPTION, e);
		}
	}

}
