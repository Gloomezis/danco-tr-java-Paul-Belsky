/*
 * 
 */
package com.danco.controller;

import com.danco.importExportCSV.GuestCsvFileReader;
import com.danco.importExportCSV.GuestCsvFileWriter;
import com.danco.importExportCSV.HotelRoomCsvFileReader;
import com.danco.importExportCSV.HotelRoomCsvFileWriter;
import com.danco.importExportCSV.ServiceCsvFileReader;
import com.danco.importExportCSV.ServiceCsvFileWriter;
import com.danco.util.InputManager;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ImportExportCsvController.
 */
public class ImportExportCsvController {

	/** The guest csv file reader. */
	GuestCsvFileReader guestCsvFileReader = new GuestCsvFileReader();

	/** The guest csv file writer. */
	GuestCsvFileWriter guestCsvFileWriter = new GuestCsvFileWriter();

	/** The hotel room csv file reader. */
	HotelRoomCsvFileReader hotelRoomCsvFileReader = new HotelRoomCsvFileReader();

	/** The hotel room csv file writer. */
	HotelRoomCsvFileWriter hotelRoomCsvFileWriter = new HotelRoomCsvFileWriter();

	/** The service csv file reader. */
	ServiceCsvFileReader serviceCsvFileReader = new ServiceCsvFileReader();

	/** The service csv file writer. */
	ServiceCsvFileWriter serviceCsvFileWriter = new ServiceCsvFileWriter();

	/** The print util. */
	private PrintUtil printUtil = new PrintUtil();

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
	private static ImportExportCsvController instance;

	/**
	 * Instantiates a new serialize controller.
	 */
	private ImportExportCsvController() {
	}

	/**
	 * Gets the single instance of SerializeController.
	 *
	 * @return single instance of SerializeController
	 */
	public static ImportExportCsvController getInstance() {
		if (instance == null) {
			instance = new ImportExportCsvController();
		}
		return instance;
	}

	/**
	 * Guest read csv file.
	 */
	public void guestReadCsvFile() {
		printUtil.printString(GUEST_INPUT_MESAGE_READ);
		String userInputFileName = InputManager.getInstance().userInputString();
		guestCsvFileReader.readCsvFile(userInputFileName);

	}

	/**
	 * Guest write csv file.
	 */
	public void guestWriteCsvFile() {
		printUtil.printString(GUEST_INPUT_MESAGE_WRITE);
		String userInputFileName = InputManager.getInstance().userInputString();
		guestCsvFileWriter.writeCsvFile(userInputFileName);

	}

	/**
	 * Hotel room read csv file.
	 */
	public void hotelRoomReadCsvFile() {
		printUtil.printString(HOTEL_ROOM_INPUT_MESAGE_READ);
		String userInputFileName = InputManager.getInstance().userInputString();
		hotelRoomCsvFileReader.readCsvFile(userInputFileName);

	}

	/**
	 * Hotel room write csv file.
	 */
	public void hotelRoomWriteCsvFile() {
		printUtil.printString(HOTEL_ROOM_INPUT_MESAGE_WRITE);
		String userInputFileName = InputManager.getInstance().userInputString();
		hotelRoomCsvFileWriter.writeCsvFile(userInputFileName);

	}

	/**
	 * Service read csv file.
	 */
	public void serviceReadCsvFile() {
		printUtil.printString(SERVICE_INPUT_MESAGE_READ);
		String userInputFileName = InputManager.getInstance().userInputString();
		serviceCsvFileReader.readCsvFile(userInputFileName);
	}

	/**
	 * Service write csv file.
	 */
	public void serviceWriteCsvFile() {
		printUtil.printString(SERVICE_INPUT_MESAGE_WRITE);
		String userInputFileName = InputManager.getInstance().userInputString();
		serviceCsvFileWriter.writeCsvFile(userInputFileName);

	}

}
