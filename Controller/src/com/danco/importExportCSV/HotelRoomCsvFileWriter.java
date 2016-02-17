package com.danco.importExportCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.cvs.ICsvFileWriter;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.HotelRoom;
import com.danco.servise.api.IHotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomCsvFileWriter.
 */
public class HotelRoomCsvFileWriter implements ICsvFileWriter{
	
	private IHotelRoomService hotelRoomService = (IHotelRoomService)DependencyInjectionManager.getClassInstance(IHotelRoomService.class);

	/** The LO g1. */
	private final Logger LOG1 = Logger.getLogger(HotelRoomCsvFileWriter.class.getName());
	
	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
			private static final String COMMA_DELIMITER = ",";
			
			/** The Constant NEW_LINE_SEPARATOR. */
			private static final String NEW_LINE_SEPARATOR = "\n";

			/** The Constant FILE_HEADER. */
			// CSV file header
			private static final String FILE_HEADER = "number,roomPrice,sleepingNumber,starCategory,busy,dateOfArrival,dateOfDeparture,status";

			/** The Constant DATE_FORMAT. */
			private static final String DATE_FORMAT = "dd-MM-yyyy";

			/** The df. */
			private static final DateFormat DF = new SimpleDateFormat(DATE_FORMAT);
			
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
				List<HotelRoom> hotelRooms= hotelRoomService.getRooms();

				// Write a new student object list to the CSV file
				for (HotelRoom hotelRoom : hotelRooms) {
					fileWriter.append(String.valueOf(hotelRoom.getNumber()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(hotelRoom.getRoomPrice()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(hotelRoom.getSleepingNumbers()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(hotelRoom.getStarCategory()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(hotelRoom.getBusy()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(DF.format((hotelRoom.getDateOfArrival())));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(DF.format((hotelRoom.getDateOfDeparture())));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(hotelRoom.getStatys()));
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


