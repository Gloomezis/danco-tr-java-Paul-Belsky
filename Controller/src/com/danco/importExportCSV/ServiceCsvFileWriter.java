package com.danco.importExportCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.Service;
import com.danco.serviñe.ServiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceCsvFileWriter.
 */
public class ServiceCsvFileWriter implements ICsvFileWriter {

	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	/** The Constant NEW_LINE_SEPARATOR. */
	private static final String NEW_LINE_SEPARATOR = "\n";

	/** The Constant FILE_HEADER. */
	// CSV file header
	private static final String FILE_HEADER = "name,price";

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(GuestCsvFileWriter.class.getName());

	/* (non-Javadoc)
	 * @see com.danco.importExportCSV.ICsvFileWriter#writeCsvFile(java.lang.String)
	 */
	public void writeCsvFile(String fileName) {

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			List<Service> services = ServiceService.getInstance().getServises();

			// Write a new student object list to the CSV file
			for (Service service : services) {
				fileWriter.append(service.getNameOfService());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(service.getPrice()));
				fileWriter.append(COMMA_DELIMITER);
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
