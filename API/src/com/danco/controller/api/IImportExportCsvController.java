package com.danco.controller.api;

public interface IImportExportCsvController {

	/**
	 * Guest read csv file.
	 */
	public void guestReadCsvFile();

	/**
	 * Guest write csv file.
	 */
	public void guestWriteCsvFile();

	/**
	 * Hotel room read csv file.
	 */
	public void hotelRoomReadCsvFile();

	/**
	 * Hotel room write csv file.
	 */
	public void hotelRoomWriteCsvFile();

	/**
	 * Service read csv file.
	 */
	public void serviceReadCsvFile();

	/**
	 * Service write csv file.
	 */
	public void serviceWriteCsvFile();

}