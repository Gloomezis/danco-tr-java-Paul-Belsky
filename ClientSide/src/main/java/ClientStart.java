import java.util.Scanner;

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
		System.out.println("Enter server ip:");
		
		String ip = scanner.nextLine();
		System.out.println("Enter server port:");
		
		int serverPort = scanner.nextInt();
		NetClient client = new NetClient(ip, serverPort);
		
		client.startClient();
		scanner.close();
	}

}
