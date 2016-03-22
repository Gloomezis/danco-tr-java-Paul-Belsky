package com.danco.importExportCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.cvs.ICsvFileWriter;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Service;
import com.danco.servise.api.IServiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceCsvFileWriter.
 */
public class ServiceCsvFileWriter implements ICsvFileWriter {
	
	private IServiceService serviceService = (IServiceService)DependencyInjectionManager.getClassInstance(IServiceService.class);

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ServiceCsvFileWriter.class.getName());

	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	/** The Constant NEW_LINE_SEPARATOR. */
	private static final String NEW_LINE_SEPARATOR = "\n";

	/** The Constant FILE_HEADER. */
	// CSV file header
	private static final String FILE_HEADER = "name,price";
	
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
	public String writeCsvFile(String fileName) {
		StringBuilder sb= new StringBuilder();

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			List<Service> services = serviceService.getServises();

			// Write a new student object list to the CSV file
			for (Service service : services) {
				fileWriter.append(service.getNameOfService());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(service.getPrice()));
				fileWriter.append(COMMA_DELIMITER);
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
