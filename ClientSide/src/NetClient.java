import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.danco.ui.Controller;
import com.danco.ui.Processing;
import com.danco.util.PrintUtil;


/**
 * The Class NetClient.
 */
public class NetClient {

	/** The ip. */
	private String ip;

	/** The server port. */
	private int serverPort;

	/** The s. */
	private Socket s;

	/** The processing. */
	private Processing processing;

	/** The controller. */
	private Controller controller;

	/** The Constant LOG1. */
	private final static Logger LOG1 = Logger.getLogger(NetClient.class
			.getName());

	/** The Constant LOGER_PROPERTY_FILE_PATH. */
	private static final String LOGER_PROPERTY_FILE_PATH = "log4j.properties";

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The Constant ADRESS_ATTEMPT_MESSAGE. */
	private static final String ADRESS_ATTEMPT_MESSAGE = "Adress not attempt";

	/** The Constant ERROR_THREAD. */
	private static final String ERROR_THREAD = "Error I/О thread";

	/**
	 * Instantiates a new net client.
	 *
	 * @param ip
	 *            the ip
	 * @param serverPort
	 *            the server port
	 */
	public NetClient(String ip, int serverPort) {
		this.ip = ip;
		this.serverPort = serverPort;
	}

	/**
	 * Start client.
	 */
	public void startClient() {
		try {
			// установка соединения с сервером
			// change to ip then creating working version
			s = new Socket(InetAddress.getLocalHost(), serverPort);
			processing = Processing.getInstance();
			processing.initializeStreams(s);

			// creating UI
			PropertyConfigurator.configure(LOGER_PROPERTY_FILE_PATH);
			controller = new Controller();
			controller.run();

			s.close();
		} catch (UnknownHostException e) {
			PrintUtil.printString(ADRESS_ATTEMPT_MESSAGE);
			LOG1.error(EXCEPTION, e);
		} catch (IOException e) {
			PrintUtil.printString(ERROR_THREAD);
			LOG1.error(EXCEPTION, e);

		}

	}
}