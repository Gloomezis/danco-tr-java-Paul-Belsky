package com.danco.controller.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface IImportExportCsvController.
 */
public interface IImportExportCsvController {

	/**
	 * Guest read csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String guestReadCsvFile(String userInputFileName);

	/**
	 * Guest write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String guestWriteCsvFile(String userInputFileName);

	/**
	 * Hotel room read csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String hotelRoomReadCsvFile(String userInputFileName);

	/**
	 * Hotel room write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String hotelRoomWriteCsvFile(String userInputFileName);

	/**
	 * Service read csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String serviceReadCsvFile(String userInputFileName);

	/**
	 * Service write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String serviceWriteCsvFile(String userInputFileName);

}