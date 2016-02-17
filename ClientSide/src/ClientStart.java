import java.util.Scanner;

import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientStart.
 */
public class ClientStart {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		PrintUtil.printString("Enter server ip:");
		
		String ip = scanner.nextLine();
		PrintUtil.printString("Enter server port:");
		
		int serverPort = scanner.nextInt();
		NetClient client = new NetClient(ip, serverPort);
		
		client.startClient();
		scanner.close();
	}

}
