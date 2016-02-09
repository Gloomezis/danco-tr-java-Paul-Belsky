import java.io.*;
import java.net.*;

public class NetClient {
	public static void main(String[] args) {
		try {
			
			Socket s = new Socket(InetAddress.getLocalHost(), 8071);
			// ��� Socket s = new Socket("���_�������", 8071);
			PrintStream ps = new PrintStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			for (int i = 1; i <= 10; i++) {
				ps.println("PING");
				System.out.println(br.readLine());
				Thread.sleep(1000);
			}
			s.close();
		} catch (UnknownHostException e) {
			System.out.println("����� ����������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("������ I/� ������");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("������ ������ ����������");
			e.printStackTrace();
		}
	}
}