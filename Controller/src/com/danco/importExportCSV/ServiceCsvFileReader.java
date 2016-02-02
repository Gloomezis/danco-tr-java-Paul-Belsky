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
import com.danco.utils.IPrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceCsvFileReader.
 */
public class ServiceCsvFileReader implements ICsvFileReader {
	
	private IServiceService serviceService = (IServiceService)DependencyInjectionManager.getClassInstance(IServiceService.class);

	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	/** The Constant SERVICE_NAME. */
	// Student attributes index
	private static final int SERVICE_NAME = 0;
	
	/** The Constant SERVICE_PRICE. */
	private static final int SERVICE_PRICE = 1;
	

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(GuestCsvFileWriter.class.getName());

	/** The print util. */
	private IPrintUtil printUtil = (IPrintUtil)DependencyInjectionManager.getClassInstance(IPrintUtil.class);

	/* (non-Javadoc)
	 * @see com.danco.importExportCSV.ICsvFileReader#readCsvFile(java.lang.String)
	 */
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
					printUtil.printString(serviceReaded.toString());
                    }else{
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
