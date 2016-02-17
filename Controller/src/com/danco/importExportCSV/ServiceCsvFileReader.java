package com.danco.importExportCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.cvs.ICsvFileReader;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Service;
import com.danco.servise.api.IServiceService;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceCsvFileReader.
 */
public class ServiceCsvFileReader implements ICsvFileReader {
	
	private IServiceService serviceService = (IServiceService)DependencyInjectionManager.getClassInstance(IServiceService.class);
	
	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ServiceCsvFileReader.class.getName());
	
	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	/** The Constant SERVICE_NAME. */
	// Student attributes index
	private static final int SERVICE_NAME = 0;
	
	/** The Constant SERVICE_PRICE. */
	private static final int SERVICE_PRICE = 1;
	
	private static final String EXCEPTION = "Exception";
	
	/** The Constant EQUAL. */
	private static final String EQUAL ="equal \n";
	
	/** The Constant ERROR_CSVFILEREADER. */
	private static final String ERROR_CSVFILEREADER="Error in CsvFileReader !!!";
	
	/** The Constant ERROR_WHILE_CLOSING_FILEREADER. */
	private static final String ERROR_WHILE_CLOSING_FILEREADER="Error while closing fileReader !!!";
	
	/* (non-Javadoc)
	 * @see com.danco.importExportCSV.ICsvFileReader#readCsvFile(java.lang.String)
	 */
	public String readCsvFile(String fileName) {
		StringBuilder sb= new StringBuilder();

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
					Service serviceReaded = new Service(Integer.parseInt(tokens[SERVICE_PRICE]), tokens[SERVICE_NAME]);
					
					
					
					
					//uniq add entity
					int a = 1;
					List<Service> services = serviceService.getServises();
					for(Service service:services){
						if(service.getNameOfService().equals(tokens[SERVICE_NAME])){
							a=-1;
						}
					}
                    if (a!=-1){
                    serviceService.addServices(serviceReaded);
                    sb.append(serviceReaded.toString()+"\n");
                    }else{
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
