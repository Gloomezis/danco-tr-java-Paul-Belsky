package com.danco.importExportCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Guest;
import com.danco.serviñe.GuestService;
import com.danco.util.PrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestCsvFileReader.
 */
public class GuestCsvFileReader implements ICsvFileReader {

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

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(GuestCsvFileWriter.class.getName());

	/** The print util. */
	PrintUtil printUtil = new PrintUtil();

	/* (non-Javadoc)
	 * @see com.danco.importExportCSV.ICsvFileReader#readCsvFile(java.lang.String)
	 */
	@Override
	public void readCsvFile(String fileName) {

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
					Date dateArrive = new GregorianCalendar(Integer.parseInt(dateMassArrive[2]),
							Integer.parseInt(dateMassArrive[1]), Integer.parseInt(dateMassArrive[0])).getTime();
					guestReaded.setDateOfArrive(dateArrive);

					String userDateDeparture = tokens[USER__DATE_OF_DEPARTURE];
					String[] dateMassDeparture = userDateDeparture.split("-");
					Date dateDeparture = new GregorianCalendar(Integer.parseInt(dateMassDeparture[2]),
							Integer.parseInt(dateMassDeparture[1]), Integer.parseInt(dateMassDeparture[0])).getTime();
					guestReaded.setDateOfDeparture(dateDeparture);

					String numberOfRoom = tokens[USER_NUMBER_OF_ROOM];
					guestReaded.setNumberOfRoom(numberOfRoom);

					int summToPaid = Integer.parseInt(tokens[USER_SUMM_TO_PAID]);
					guestReaded.setSummToPaid(summToPaid);

					// uniq add entity
					int a = 1;
					List<Guest> guests = GuestService.getInstance().getAllGuests();
					for (Guest guest1 : guests) {
						if (guest1.getName().equals(tokens[USER_NAME])) {
							a = -1;
						}
					}
					if (a != -1) {

						GuestService.getInstance().addGuest(guestReaded);
						printUtil.printString(guestReaded.toString());

					} else {
						System.out.println("equal");

					}

				}
			}

		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			LOG1.error("Exception", e);
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				LOG1.error("Exception", e);
			}
		}

	}

}
