package com.danco.importExportCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.danco.model.HotelRoom;
import com.danco.servi�e.HotelRoomService;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomCsvFileWriter.
 */
public class HotelRoomCsvFileWriter implements ICsvFileWriter{

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
			
			/** The LO g1. */
			private final Logger LOG1 = Logger.getLogger(HotelRoomCsvFileWriter.class.getName());

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
				List<HotelRoom> hotelRooms= HotelRoomService.getInstance().getRooms();

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


