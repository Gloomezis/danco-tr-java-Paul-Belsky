package com.danco.controller.api;

import org.hibernate.Session;

// TODO: Auto-generated Javadoc
/**
 * The Interface IImportExportCsvController.
 */
public interface IImportExportCsvController {

	/**
	 * Guest read csv file.
	 *
	 * @param session the session
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public String guestReadCsvFile(Session session, String userInputFileName);

	/**
	 * Guest write csv file.
	 *
	 * @param session the session
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public String guestWriteCsvFile(Session session,String userInputFileName);

	/**
	 * Hotel room read csv file.
	 *
	 * @param session the session
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public String hotelRoomReadCsvFile(Session session,String userInputFileName);

	/**
	 * Hotel room write csv file.
	 *
	 * @param session the session
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public String hotelRoomWriteCsvFile(Session session,String userInputFileName);

	/**
	 * Service read csv file.
	 *
	 * @param session the session
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public String serviceReadCsvFile(Session session,String userInputFileName);

	/**
	 * Service write csv file.
	 *
	 * @param session the session
	 * @param userInputFileName the user input file name
	 * @return the string
	 */
	public String serviceWriteCsvFile(Session session,String userInputFileName);

}