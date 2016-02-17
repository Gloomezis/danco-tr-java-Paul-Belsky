package com.danco.importExportCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.cvs.ICsvFileReader;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.servise.api.IGuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestCsvFileReader.
 */
public class GuestCsvFileReader implements ICsvFileReader {

	/** The guest service. */
	private IGuestService guestService = (IGuestService) DependencyInjectionManager
			.getClassInstance(IGuestService.class);
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(GuestCsvFileReader.class
			.getName());

	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	/** The Constant USER_NAME. */
	// Student attributes index
	private static final int USER_NAME = 0;

	/** The Constant USER_DATE_OF_ARRIVE. */
	private static final int USER_DATE_OF_ARRIVE = 1;

	/** The Constant USER__DATE_OF_DEPARTURE. */
	private static final int USER__DATE_OF_DEPARTURE = 2;

	/** The Constant USER_NUMBER_OF_ROOM. */
	private static final int USER_NUMBER_OF_ROOM = 3;

	/** The Constant USER_SUMM_TO_PAID. */
	private static final int USER_SUMM_TO_PAID = 4;
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	/** The Constant EQUAL. */
	private static final String EQUAL ="equal  \n";
	
	/** The Constant ERROR_CSVFILEREADER. */
	private static final String ERROR_CSVFILEREADER="Error in CsvFileReader !!!";
	
	/** The Constant ERROR_WHILE_CLOSING_FILEREADER. */
	private static final String ERROR_WHILE_CLOSING_FILEREADER="Error while closing fileReader !!!";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.importExportCSV.ICsvFileReader#readCsvFile(java.lang.String)
	 */
	@Override
	public String readCsvFile(String fileName) {
		StringBuilder sb = new StringBuilder();

		BufferedReader fileReader = null;

		try {

			String line = "";

			// Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			// Read the CSV file header to skip it
			fileReader.readLine();

			// Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				// Get all tokens available in line
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					// Create a new student object and fill his data
					Guest guestReaded = new Guest(tokens[USER_NAME]);

					String userDateArrive = tokens[USER_DATE_OF_ARRIVE];
					String[] dateMassArrive = userDateArrive.split("-");
					Date dateArrive = new GregorianCalendar(
							Integer.parseInt(dateMassArrive[2]),
							Integer.parseInt(dateMassArrive[1]),
							Integer.parseInt(dateMassArrive[0])).getTime();
					guestReaded.setDateOfArrive(dateArrive);

					String userDateDeparture = tokens[USER__DATE_OF_DEPARTURE];
					String[] dateMassDeparture = userDateDeparture.split("-");
					Date dateDeparture = new GregorianCalendar(
							Integer.parseInt(dateMassDeparture[2]),
							Integer.parseInt(dateMassDeparture[1]),
							Integer.parseInt(dateMassDeparture[0])).getTime();
					guestReaded.setDateOfDeparture(dateDeparture);

					String numberOfRoom = tokens[USER_NUMBER_OF_ROOM];
					guestReaded.setNumberOfRoom(numberOfRoom);

					int summToPaid = Integer
							.parseInt(tokens[USER_SUMM_TO_PAID]);
					guestReaded.setSummToPaid(summToPaid);

					// uniq add entity
					int a = 1;
					List<Guest> guests = guestService.getAllGuests();
					for (Guest guest1 : guests) {
						if (guest1.getName().equals(tokens[USER_NAME])) {
							a = -1;
						}
					}
					if (a != -1) {

						guestService.addGuest(guestReaded);
						sb.append(guestReaded.toString()+ "\n");

					} else {
						sb.append(EQUAL);

					}

				}
			}

		} catch (Exception e) {
			sb.append(ERROR_CSVFILEREADER);
			LOG1.error(EXCEPTION, e);
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				sb.append(ERROR_WHILE_CLOSING_FILEREADER);
				LOG1.error(EXCEPTION, e);
			}
		}
		return sb.toString();

	}

}
