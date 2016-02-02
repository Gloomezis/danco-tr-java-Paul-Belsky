package com.danco.servise;

import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Service;
import com.danco.servise.api.IServiceService;
import com.danco.storages.MainStorage;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceService.
 */
public class ServiceService implements IServiceService {

	/** The main storage. */
	private MainStorage mainStorage = MainStorage.getInstance();

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ServiceService.class.getName());


	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	/** The instance. */
//	private static IServiceService instance;

	/**
	 * Gets the single instance of ServiceService.
	 *
	 * @return single instance of ServiceService
	 */
	//public static IServiceService getInstance() {
	//	if (instance == null) {
	//		instance = new ServiceService();
	//	}
	//	return instance;
	//}

	/**
	 * Instantiates a new service service.
	 */
	//private ServiceService() {

	//}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IServiceService#createService(java.lang.String, int)
	 */
	@Override
	public Service createService(String nameOfService, int price) {

		try {
			return mainStorage.createService(nameOfService, price);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}

	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IServiceService#getServiceByName(java.lang.String)
	 */
	@Override
	public Service getServiceByName(String nameOfService) {

		try {
			return mainStorage.getServiceByName(nameOfService);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}

	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IServiceService#addServices(com.danco.model.Service)
	 */

	@Override
	public void addServices(Service service) {
		try {
			mainStorage.addServices(service);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IServiceService#showPriceService()
	 */

	@Override
	public List<Service> showPriceService() {
		try {
			return mainStorage.showPriceService();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IServiceService#changePriceOfService(com.danco.model.Service, int)
	 */

	@Override
	public void changePriceOfService(Service service, int price) {
		try {
			mainStorage.changePriceOfService(service, price);
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);

		}
	}

	/* (non-Javadoc)
	 * @see com.danco.serviñe.IServiceService#getServises()
	 */
	@Override
	public List<Service> getServises() {
		try {
			return mainStorage.getServises();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
			return null;
		}
	}

}
