/*
 * 
 */
package com.danco.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.danco.controller.api.IImportExportCsvController;
import com.danco.dao.api.IGuestDAO;
import com.danco.dao.api.IHotelRoomDAO;
import com.danco.dao.api.IServiceDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;
import com.danco.model.HotelRoom;
import com.danco.model.Service;


// TODO: Auto-generated Javadoc
/**
 * The Class ImportExportCsvController.
 */
public class ImportExportCsvController implements IImportExportCsvController{

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(ImportExportCsvController.class
			.getName());
	
	/** The guest dao. */
	private IGuestDAO guestDAO = (IGuestDAO) DependencyInjectionManager
			.getClassInstance(IGuestDAO.class);

	/** The service dao. */
	private IServiceDAO serviceDAO = (IServiceDAO) DependencyInjectionManager
			.getClassInstance(IServiceDAO.class);


	/** The hotel room dao. */
	private IHotelRoomDAO hotelRoomDAO = (IHotelRoomDAO) DependencyInjectionManager
			.getClassInstance(IHotelRoomDAO.class);

	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	/** The Constant USER_NAME. */
	// Student attributes index
	private static final int USER_NAME = 0;

	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";

	/** The Constant EQUAL. */
	private static final String EQUAL = "equal  \n";

	/** The Constant ERROR_CSVFILEREADER. */
	private static final String ERROR_CSVFILEREADER = "Error in CsvFileReader !!!";

	/** The Constant ERROR_WHILE_CLOSING_FILEREADER. */
	private static final String ERROR_WHILE_CLOSING_FILEREADER = "Error while closing fileReader !!!";

	/** The Constant NEW_LINE_SEPARATOR. */
	private static final String NEW_LINE_SEPARATOR = "\n";

	/** The Constant FILE_HEADER1. */
	// CSV file header
	private static final String FILE_HEADER1 = "name";

	
	/** The Constant CSV_FILE_CREATED. */
	private static final String CSV_FILE_CREATED = "CSV file was created successfully !!!";

	/** The Constant ERROR_CSVFILEWRITER. */
	private static final String ERROR_CSVFILEWRITER = "Error in CsvFileWriter !!!";

	/** The Constant ERROR_WHILE_CLOSING_FILEWRITER. */
	private static final String ERROR_WHILE_CLOSING_FILEWRITER = "Error while flushing/closing fileWriter !!!";

	/** The Constant HOTEL_ROOM_NUMBER. */
	// Student attributes index
	private static final int HOTEL_ROOM_NUMBER = 0;

	/** The Constant HOTEL_ROOM_PRICE. */
	private static final int HOTEL_ROOM_PRICE = 1;

	/** The Constant HOTEL_ROOM_SLEEPING_NUMBERS. */
	private static final int HOTEL_ROOM_SLEEPING_NUMBERS = 2;

	/** The Constant HOTEL_ROOM_STAR_CATEGORY. */
	private static final int HOTEL_ROOM_STAR_CATEGORY = 3;

	/** The Constant HOTEL_ROOM_BUSY. */
	private static final int HOTEL_ROOM_BUSY = 4;

	/** The Constant HOTEL_ROOM_STATUS. */
	private static final int HOTEL_ROOM_STATUS = 5;

	/** The Constant FILE_HEADER2. */
	// CSV file header
	private static final String FILE_HEADER2 = "number,roomPrice,sleepingNumber,starCategory,busy,dateOfArrival,dateOfDeparture,status";

	/** The Constant SERVICE_NAME. */
	
	
	// Student attributes index
	private static final int SERVICE_NAME = 0;

	/** The Constant SERVICE_PRICE. */
	private static final int SERVICE_PRICE = 1;

	/** The Constant FILE_HEADER3. */
	// CSV file header
	private static final String FILE_HEADER3 = "name,price";
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.importExportCSV.ICsvFileReader#readCsvFile(java.lang.String)
	 */
	@Override
	public String guestReadCsvFile(Session session,String fileName) {
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

					// uniq add entity
					int a = 1;
					
					List<Guest> guests = guestDAO.getList(session, "name");
					for (Guest guest1 : guests) {
						if (guest1.getName().equals(tokens[USER_NAME])) {
							a = -1;
						}
					}
					if (a != -1) {

						guestDAO.create(session, guestReaded);
						sb.append(guestReaded.toString() + "\n");
						

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.importExportCSV.ICsvFileWriter#writeCsvFile(java.lang.String)
	 */
	@Override
	public String guestWriteCsvFile(Session session,String fileName) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER1.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			List<Guest> guests = guestDAO.getList(session,"name");

			// Write a new student object list to the CSV file
			for (Guest guest : guests) {
				fileWriter.append(String.valueOf(guest.getName()));
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.importExportCSV.ICsvFileReader#readCsvFile(java.lang.String)
	 */
	@Override
	public String hotelRoomReadCsvFile(Session session,String fileName) {
		// TODO Auto-generated method stub
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
					HotelRoom hotelRoomReaded = new HotelRoom(
							tokens[HOTEL_ROOM_NUMBER],
							Integer.parseInt(tokens[HOTEL_ROOM_PRICE]),
							Integer.parseInt(tokens[HOTEL_ROOM_SLEEPING_NUMBERS]),
							Integer.parseInt(tokens[HOTEL_ROOM_STAR_CATEGORY]));
					hotelRoomReaded.setBusy(Boolean
							.parseBoolean(tokens[HOTEL_ROOM_BUSY]));

					

					String status = tokens[HOTEL_ROOM_STATUS];
					hotelRoomReaded.setStatus(Boolean.parseBoolean(status));

					// uniq add entity
					int a = 1;
					List<HotelRoom> hotelRooms = hotelRoomDAO.getList(session, "", "number");
					for (HotelRoom hotelRoom : hotelRooms) {
						if (hotelRoom.getNumber().equals(
								tokens[HOTEL_ROOM_NUMBER])) {
							a = -1;
						}
					}
					if (a != -1) {

						hotelRoomDAO.create(session, hotelRoomReaded);
						sb.append(hotelRoomReaded.toString() + "\n");

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.importExportCSV.ICsvFileWriter#writeCsvFile(java.lang.String)
	 */
	@Override
	public String hotelRoomWriteCsvFile(Session session,String fileName) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER2.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			List<HotelRoom> hotelRooms = hotelRoomDAO.getList(session, "", "number");

			// Write a new student object list to the CSV file
			for (HotelRoom hotelRoom : hotelRooms) {
				fileWriter.append(String.valueOf(hotelRoom.getNumber()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(hotelRoom.getRoomPrice()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter
						.append(String.valueOf(hotelRoom.getSleepingNumber()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(hotelRoom.getStarCategory()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(hotelRoom.isBusy()));
				fileWriter.append(COMMA_DELIMITER);
				
				fileWriter.append(String.valueOf(hotelRoom.isStatus()));
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.importExportCSV.ICsvFileReader#readCsvFile(java.lang.String)
	 */
	public String serviceReadCsvFile(Session session,String fileName) {
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
					Service serviceReaded = new Service(tokens[SERVICE_NAME],
							Integer.parseInt(tokens[SERVICE_PRICE]));

					// uniq add entity
					int a = 1;
					List<Service> services = serviceDAO.getList(session, "name");
					for (Service service : services) {
						if (service.getName().equals(
								tokens[SERVICE_NAME])) {
							a = -1;
						}
					}
					if (a != -1) {
						serviceDAO.create(session, serviceReaded);
						sb.append(serviceReaded.toString() + "\n");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.danco.importExportCSV.ICsvFileWriter#writeCsvFile(java.lang.String)
	 */
	public String serviceWriteCsvFile(Session session,String fileName) {
		StringBuilder sb = new StringBuilder();

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(fileName);

			// Write the CSV file header
			fileWriter.append(FILE_HEADER3.toString());

			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			List<Service> services = serviceDAO.getList(session, "name");

			// Write a new student object list to the CSV file
			for (Service service : services) {
				
				
				fileWriter.append(service.getName());
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
