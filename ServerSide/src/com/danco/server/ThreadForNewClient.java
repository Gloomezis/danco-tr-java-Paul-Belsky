package com.danco.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class ThreadForNewClient.
 */
public class ThreadForNewClient implements Runnable {

	/** The thread. */
	public Thread thread;

	/** The client socket. */
	private Socket clientSocket;

	/** The comman d processor. */
	private CommanDProcessor commanDProcessor;

	/** The is alive. */
	private boolean isAlive = true;

	private final static Logger LOG1 = Logger
			.getLogger(ThreadForNewClient.class.getName());

	private static final String EXCEPTION = "Exception";

	private static final String NEW_CLIENT = "New client";

	/**
	 * The Constant EXCEPTION.
	 *
	 * @param clientSocket
	 *            the client socket
	 * @param commanDProcessor
	 *            the comman d processor
	 */

	public ThreadForNewClient(Socket clientSocket,
			CommanDProcessor commanDProcessor) {
		this.clientSocket = clientSocket;
		this.commanDProcessor = commanDProcessor;
		this.thread = new Thread(this, NEW_CLIENT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String line = null;
		try {
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

			while (isAlive) {
				line = in.readObject().toString();
				if (line == null) {
					isAlive = false;
				} else {
					out.writeObject(commanDProcessor.parseStringToObject(line));
					out.flush();
				}
			}
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}finally {
			//((ISerializeController) DependencyInjectionManager.getClassInstance(ISerializeController.class)).serialToFile(MainStorage.getInstance());
		}
	}

}