package com.danco.importExportCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.danco.cvs.ICsvFileReader;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.HotelRoom;
import com.danco.servise.api.IHotelRoomService;
import com.danco.utils.IPrintUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class HotelRoomCsvFileReader.
 */
public class HotelRoomCsvFileReader implements ICsvFileReader {
	
	private IHotelRoomService hotelRoomService = (IHotelRoomService)DependencyInjectionManager.getClassInstance(IHotelRoomService.class);

	/** The Constant COMMA_DELIMITER. */
	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

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
	
	/** The Constant HOTEL_ROOM_DATE_OF_ARRIVAL. */
	private static final int HOTEL_ROOM_DATE_OF_ARRIVAL = 5;
	
	/** The Constant HOTEL_ROOM_DATE_OF_DEPARTURE. */
	private static final int HOTEL_ROOM_DATE_OF_DEPARTURE = 6;
	
	/** The Constant HOTEL_ROOM_STATUS. */
	private static final int HOTEL_ROOM_STATUS = 7;

	/** The print util. */
	private IPrintUtil printUtil = (IPrintUtil)DependencyInjectionManager.getClassInstance(IPrintUtil.class);

	/* (non-Javadoc)
	 * @see com.danco.importExportCSV.ICsvFileReader#readCsvFile(java.lang.String)
	 */
	@Override
	public void readCsvFile(String fileName) {
		// TODO Auto-generated method stub

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
					HotelRoom hotelRoomReaded = new HotelRoom(tokens[HOTEL_ROOM_NUMBER],
							Integer.parseInt(tokens[HOTEL_ROOM_PRICE]),
							Integer.parseInt(tokens[HOTEL_ROOM_SLEEPING_NUMBERS]),
							Integer.parseInt(tokens[HOTEL_ROOM_STAR_CATEGORY]));
					hotelRoomReaded.setBusy(Boolean.parseBoolean(tokens[HOTEL_ROOM_BUSY]));

					String userDateArrive = tokens[HOTEL_ROOM_DATE_OF_ARRIVAL];
					String[] dateMassArrive = userDateArrive.split("-");
					Date dateArrive = new GregorianCalendar(Integer.parseInt(dateMassArrive[2]),
							Integer.parseInt(dateMassArrive[1]), Integer.parseInt(dateMassArrive[0])).getTime();
					hotelRoomReaded.setDateOfArrival(dateArrive);

					String userDateDeparture = tokens[HOTEL_ROOM_DATE_OF_DEPARTURE];
					String[] dateMassDeparture = userDateDeparture.split("-");
					Date dateDeparture = new GregorianCalendar(Integer.parseInt(dateMassDeparture[2]),
							Integer.parseInt(dateMassDeparture[1]), Integer.parseInt(dateMassDeparture[0])).getTime();
					hotelRoomReaded.setDateOfDeparture(dateDeparture);

					String status = tokens[HOTEL_ROOM_STATUS];
					hotelRoomReaded.setStatys(Boolean.parseBoolean(status));

					// uniq add entity
					int a = 1;
					List<HotelRoom> hotelRooms = hotelRoomService.getRooms();
					for (HotelRoom hotelRoom : hotelRooms) {
						if (hotelRoom.getNumber().equals(tokens[HOTEL_ROOM_NUMBER])) {
							a = -1;
						}
					}
					if (a != -1) {

						hotelRoomService.addRooms(hotelRoomReaded);
						printUtil.printString(hotelRoomReaded.toString());

					} else {
						System.out.println("equal");

					}

				}
			}

		} catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}

	}

}
