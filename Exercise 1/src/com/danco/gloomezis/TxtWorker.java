package com.danco.gloomezis;

import java.util.ArrayList;

import com.danco.models.Guest;
import com.danco.training.TextFileWorker;

public class TxtWorker {
	MainStorage mainStorage = MainStorage.getInstance();

	TextFileWorker fw;

	/*
	 * final String FILE_PATH_HOTELROOMS = "src/src/files/hotelRooms.txt";
	 * TextFileWorker fwHotelRoms = new TextFileWorker(FILE_PATH_HOTELROOMS);
	 * 
	 * final String FILE_PATH_SERVICES = "src/src/files/services.txt";
	 * TextFileWorker fwServices = new TextFileWorker(FILE_PATH_SERVICES);
	 */

	public TxtWorker(TextFileWorker fw) {
		this.fw = fw;
	}

	public void writeGuests() {

		String[] b = new String[10];

		int i = 0;
		for (Guest g : mainStorage.getAllGuests()) {
			b[i] = g.toString();
			i++;
		}
		fw.writeToFile(b);

	}

	public ArrayList<String> readGuests() {
		String[] c = new String[10];
		c = fw.readFromFile();
		ArrayList<String> s = new ArrayList<String>();
		String[] e = new String[5];
		for (String b1 : c) {
			if (b1.equals("null")) {
			} else {
				e = b1.split(",");
				// for(String f:e){
				// System.out.println(f);
				// }

				String name = e[0];
				String dateOfDeparture = e[1];
				String dateOfArrive = e[2];
				String numberOfRoom = e[3];
				String summToPaid = e[4];
				System.out.println((new StringBuilder(name + ","
						+ dateOfDeparture + "," + dateOfArrive + ","
						+ numberOfRoom + "," + summToPaid)).toString());
			}
		}
		return s;
	}
}
