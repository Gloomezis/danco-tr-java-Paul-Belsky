import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serv = new ServerSocket(8071);
			System.out.println("initialized");
			while (true) {
		
				Socket sock = serv.accept();
				System.out.println(sock.getInetAddress().getHostName() + " connected");
				ServerThread server = new ServerThread(sock);
				server.start();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}

class ServerThread extends Thread {
	private PrintStream os;
	private BufferedReader is;
	private InetAddress addr;

	public ServerThread(Socket s) throws IOException {
		os = new PrintStream(s.getOutputStream());
		is = new BufferedReader(new InputStreamReader(s.getInputStream()));
		addr = s.getInetAddress();
	}

	public void run() {
		int i = 0;
		String str;
		try {
			while ((str = is.readLine()) != null) {
				if ("PING".equals(str))
					os.println("PONG " + ++i);
				System.out.println("PING-PONG" + i + " with " + addr.getHostName());
			}
		} catch (IOException e) {
			
			System.out.println("Disconnect");
		} finally

		{
			disconnect();
		}

	}

	public void disconnect() {
		try {
			System.out.println(addr.getHostName() + " disconnected");
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.interrupt();
		}
	}
}