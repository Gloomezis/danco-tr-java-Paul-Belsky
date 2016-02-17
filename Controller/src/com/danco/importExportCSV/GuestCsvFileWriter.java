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
	
	/** The guest service. */
	private IGuestService guestService = (IGuestService)DependencyInjectionManager.getClassInstance(IGuestService.class);

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(GuestCsvFileWriter.class.getName());
	
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

	/** The Constant DF. */
	private static final DateFormat DF = new SimpleDateFormat(DATE_FORMAT);
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	/** The Constant CSV_FILE_CREATED. */
	private static final String CSV_FILE_CREATED="CSV file was created successfully !!!";
	
	/** The Constant ERROR_CSVFILEWRITER. */
	private static final String ERROR_CSVFILEWRITER="Error in CsvFileWriter !!!";
	
	/** The Constant ERROR_WHILE_CLOSING_FILEWRITER. */
	private static final String ERROR_WHILE_CLOSING_FILEWRITER="Error while flushing/closing fileWriter !!!";

	
	
	
	
	

	/* (non-Javadoc)
	 * @see com.danco.importExportCSV.ICsvFileWriter#writeCsvFile(java.lang.String)
	 */
	@Override
	public String writeCsvFile(String fileName) {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder();

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

			sb.append(CSV_FILE_CREATED);

		} catch (Exception e) {
			sb.append(ERROR_CSVFILEWRITER);
			LOG1.error(EXCEPTION, e);
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				sb.append(ERROR_WHILE_CLOSING_FILEWRITER);
				LOG1.error(EXCEPTION, e);
			}

		}
		return sb.toString();
	}
}
