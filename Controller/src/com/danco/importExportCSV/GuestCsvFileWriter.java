/*
 * 
 */
package com.danco.importExportCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.cvs.ICsvFileWriter;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.servise.api.IGuestService;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestCsvFileWriter.
 */
public class GuestCsvFileWriter implements ICsvFileWriter {
	
	private IGuestService guestService = (IGuestService)DependencyInjectionManager.getClassInstance(IGuestService.class);

	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	/** The Constant NEW_LINE_SEPARATOR. */
	private static final String NEW_LINE_SEPARATOR = "\n";

	/** The Constant FILE_HEADER. */
	// CSV file header
	private static final String FILE_HEADER = "name,dateOfArrive,dateOfDeparture,numberOfRoom,summToPaid";

	/** The Constant DATE_FORMAT. */
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	/** The df. */
	private static final DateFormat DF = new SimpleDateFormat(DATE_FORMAT);
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(GuestCsvFileWriter.class.getName());

	/* (non-Javadoc)
	 * @see com.danco.importExportCSV.ICsvFileWriter#writeCsvFile(java.lang.String)
	 */
	@Override
	public void writeCsvFile(String fileName) {
		// TODO Auto-generated method stub

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			List<Guest> guests = guestService.getAllGuests();

			// Write a new student object list to the CSV file
			for (Guest guest : guests) {
				fileWriter.append(String.valueOf(guest.getName()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(DF.format(guest.getDateOfArrive()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(DF.format(guest.getDateOfDeparture()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(guest.getNumberOfRoom());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(guest.getSummToPaid()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			LOG1.error("Exception", e);
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				LOG1.error("Exception", e);
			}

		}
	}
}
