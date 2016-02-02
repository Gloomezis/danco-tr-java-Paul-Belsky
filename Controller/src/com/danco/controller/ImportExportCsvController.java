/*
 * 
 */
package com.danco.controller;

import com.danco.controller.api.IImportExportCsvController;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.importExportCSV.GuestCsvFileReader;
import com.danco.importExportCSV.GuestCsvFileWriter;
import com.danco.importExportCSV.HotelRoomCsvFileReader;
import com.danco.importExportCSV.HotelRoomCsvFileWriter;
import com.danco.importExportCSV.ServiceCsvFileReader;
import com.danco.importExportCSV.ServiceCsvFileWriter;
import com.danco.utils.IInputManager;
import com.danco.utils.IPrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ImportExportCsvController.
 */
public class ImportExportCsvController implements IImportExportCsvController {
	
	private IInputManager inputManager = (IInputManager)DependencyInjectionManager.getClassInstance(IInputManager.class);

	/** The guest csv file reader. */
	private GuestCsvFileReader guestCsvFileReader = new GuestCsvFileReader();

	/** The guest csv file writer. */
	private GuestCsvFileWriter guestCsvFileWriter = new GuestCsvFileWriter();

	/** The hotel room csv file reader. */
	private HotelRoomCsvFileReader hotelRoomCsvFileReader = new HotelRoomCsvFileReader();

	/** The hotel room csv file writer. */
	private HotelRoomCsvFileWriter hotelRoomCsvFileWriter = new HotelRoomCsvFileWriter();

	/** The service csv file reader. */
	private ServiceCsvFileReader serviceCsvFileReader = new ServiceCsvFileReader();

	/** The service csv file writer. */
	private ServiceCsvFileWriter serviceCsvFileWriter = new ServiceCsvFileWriter();

	/** The print util. */
	private IPrintUtil printUtil = (IPrintUtil)DependencyInjectionManager.getClassInstance(IPrintUtil.class);

	/** The Constant SORT_INPUT_MESSAGE. */
	private static final String GUEST_INPUT_MESAGE_READ = "Write CSV file name/path(*.csv) to read guest";

	/** The Constant GUEST_INPUT_MESAGE_WRITE. */
	private static final String GUEST_INPUT_MESAGE_WRITE = "Write CSV file name/path(*.csv) to write guest";

	/** The Constant HOTEL_ROOM_INPUT_MESAGE_READ. */
	private static final String HOTEL_ROOM_INPUT_MESAGE_READ = "Write CSV file name/path(*.csv) to read hotel room";

	/** The Constant HOTEL_ROOM_INPUT_MESAGE_WRITE. */
	private static final String HOTEL_ROOM_INPUT_MESAGE_WRITE = "Write CSV file name/path(*.csv) to hotel room";

	/** The Constant SERVICE_INPUT_MESAGE_READ. */
	private static final String SERVICE_INPUT_MESAGE_READ = "Write CSV file name/path(*.csv) to read service";

	/** The Constant SERVICE_INPUT_MESAGE_WRITE. */
	private static final String SERVICE_INPUT_MESAGE_WRITE = "Write CSV file name/path(*.csv) to write service";

	/** The instance. */
//	private static IImportExportCsvController instance;

	/**
	 * Instantiates a new serialize controller.
	 */
//	private ImportExportCsvController() {
//	}

	/**
	 * Gets the single instance of SerializeController.
	 *
	 * @return single instance of SerializeController
	 */
//	public static IImportExportCsvController getInstance() {
//		if (instance == null) {
//			instance = new ImportExportCsvController();
//		}
//		return instance;
//	}
 
	/* (non-Javadoc)
	 * @see com.danco.controller.IImportExportCsvController#guestReadCsvFile()
	 */
	@Override
	public void guestReadCsvFile() {
		printUtil.printString(GUEST_INPUT_MESAGE_READ);
		String userInputFileName = inputManager.userInputString();
		guestCsvFileReader.readCsvFile(userInputFileName);

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IImportExportCsvController#guestWriteCsvFile()
	 */
	@Override
	public void guestWriteCsvFile() {
		printUtil.printString(GUEST_INPUT_MESAGE_WRITE);
		String userInputFileName = inputManager.userInputString();
		guestCsvFileWriter.writeCsvFile(userInputFileName);

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IImportExportCsvController#hotelRoomReadCsvFile()
	 */
	@Override
	public void hotelRoomReadCsvFile() {
		printUtil.printString(HOTEL_ROOM_INPUT_MESAGE_READ);
		String userInputFileName = inputManager.userInputString();
		hotelRoomCsvFileReader.readCsvFile(userInputFileName);

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IImportExportCsvController#hotelRoomWriteCsvFile()
	 */
	@Override
	public void hotelRoomWriteCsvFile() {
		printUtil.printString(HOTEL_ROOM_INPUT_MESAGE_WRITE);
		String userInputFileName = inputManager.userInputString();
		hotelRoomCsvFileWriter.writeCsvFile(userInputFileName);

	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IImportExportCsvController#serviceReadCsvFile()
	 */
	@Override
	public void serviceReadCsvFile() {
		printUtil.printString(SERVICE_INPUT_MESAGE_READ);
		String userInputFileName = inputManager.userInputString();
		serviceCsvFileReader.readCsvFile(userInputFileName);
	}

	/* (non-Javadoc)
	 * @see com.danco.controller.IImportExportCsvController#serviceWriteCsvFile()
	 */
	@Override
	public void serviceWriteCsvFile() {
		printUtil.printString(SERVICE_INPUT_MESAGE_WRITE);
		String userInputFileName = inputManager.userInputString();
		serviceCsvFileWriter.writeCsvFile(userInputFileName);

	}

}
