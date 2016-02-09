import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Start {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(3007);
		System.setSecurityManager(new RMISecurityManager());
	MyRemote service;service = new MyRemoteImpl();
	Naming.rebind("MyRemote", service);
	
	
	}
}
