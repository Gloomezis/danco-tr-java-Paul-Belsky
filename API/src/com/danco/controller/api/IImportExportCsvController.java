package com.danco.controller.api;

import java.sql.Connection;

// TODO: Auto-generated Javadoc
/**
 * The Interface IImportExportCsvController.
 */
public interface IImportExportCsvController {

	/**
	 * Guest read csv file.
	 * @param con 
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String guestReadCsvFile(Connection con, String userInputFileName);

	/**
	 * Guest write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String guestWriteCsvFile(Connection con,String userInputFileName);

	/**
	 * Hotel room read csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String hotelRoomReadCsvFile(Connection con,String userInputFileName);

	/**
	 * Hotel room write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String hotelRoomWriteCsvFile(Connection con,String userInputFileName);

	/**
	 * Service read csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String serviceReadCsvFile(Connection con,String userInputFileName);

	/**
	 * Service write csv file.
	 *
	 * @param userInputFileName
	 *            the user input file name
	 * @return the string
	 */
	public String serviceWriteCsvFile(Connection con,String userInputFileName);

}