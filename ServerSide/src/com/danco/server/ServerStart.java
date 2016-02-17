package com.danco.server;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerStart.
 */
public class ServerStart {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Server Port:");
		int serverPort = scanner.nextInt();

		Server server = new Server(serverPort);
		server.startServer();

		scanner.close();
	}
}
