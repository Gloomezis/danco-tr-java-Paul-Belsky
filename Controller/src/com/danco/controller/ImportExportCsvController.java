/*
 * 
 */
package com.danco.controller;

import com.danco.controller.api.IImportExportCsvController;
import com.danco.importExportCSV.GuestCsvFileReader;
import com.danco.importExportCSV.GuestCsvFileWriter;
import com.danco.importExportCSV.HotelRoomCsvFileReader;
import com.danco.importExportCSV.HotelRoomCsvFileWriter;
import com.danco.importExportCSV.ServiceCsvFileReader;
import com.danco.importExportCSV.ServiceCsvFileWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class ImportExportCsvController.
 */
public class ImportExportCsvController implements IImportExportCsvController {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IImportExportCsvController#guestReadCsvFile()
	 */
	@Override
	public synchronized String guestReadCsvFile(String userInputFileName) {

		return guestCsvFileReader.readCsvFile(userInputFileName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IImportExportCsvController#guestWriteCsvFile()
	 */
	@Override
	public synchronized String guestWriteCsvFile(String userInputFileName) {

		return guestCsvFileWriter.writeCsvFile(userInputFileName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IImportExportCsvController#hotelRoomReadCsvFile()
	 */
	@Override
	public synchronized String hotelRoomReadCsvFile(String userInputFileName) {

		return hotelRoomCsvFileReader.readCsvFile(userInputFileName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IImportExportCsvController#hotelRoomWriteCsvFile()
	 */
	@Override
	public synchronized String hotelRoomWriteCsvFile(String userInputFileName) {

		return hotelRoomCsvFileWriter.writeCsvFile(userInputFileName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.danco.controller.IImportExportCsvController#serviceReadCsvFile()
	 */
	@Override
	public String serviceReadCsvFile(String userInputFileName) {

		return serviceCsvFileReader.readCsvFile(userInputFileName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.controller.IImportExportCsvController#serviceWriteCsvFile()
	 */
	@Override
	public synchronized String serviceWriteCsvFile(String userInputFileName) {

		return serviceCsvFileWriter.writeCsvFile(userInputFileName);

	}

}
