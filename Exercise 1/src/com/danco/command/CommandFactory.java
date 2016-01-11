package com.danco.command;

import com.danco.command.guestCommand.AddGuest;
import com.danco.command.guestCommand.AddServiceToGuest;
import com.danco.command.guestCommand.ReadGuestFromFile;
import com.danco.command.guestCommand.ShowAllGuestNumber;
import com.danco.command.guestCommand.ShowAllGuests;
import com.danco.command.guestCommand.ShowListOfService;
import com.danco.command.guestCommand.ShowSummToPaidGuest;
import com.danco.command.guestCommand.WriteGuestToFile;
import com.danco.command.hotelRoomCommand.AddRooms;
import com.danco.command.hotelRoomCommand.ChangePriceOfHotelRoom;
import com.danco.command.hotelRoomCommand.ChangeStatus;
import com.danco.command.hotelRoomCommand.DepartGuestFromHotelRoom;
import com.danco.command.hotelRoomCommand.SettleGuestToHotelRoom;
import com.danco.command.hotelRoomCommand.ShowAllFreeRooms;
import com.danco.command.hotelRoomCommand.ShowAllRooms;
import com.danco.command.hotelRoomCommand.ShowDetailOfHotelRoom;
import com.danco.command.hotelRoomCommand.ShowFreeRomsAfterDate;
import com.danco.command.hotelRoomCommand.ShowLast3GuestOfHotelRoom;
import com.danco.command.hotelRoomCommand.ShowNumberOfFreeHotelRooms;
import com.danco.command.serviceCommand.AddServices;
import com.danco.command.serviceCommand.ChangePriceOfService;
import com.danco.command.serviceCommand.ShowPriceServiceAndHotelRoom;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Command objects.
 */
public abstract class CommandFactory {
	
	/** The add guest. */
	// Guest methods
	static AddGuest addGuest = new AddGuest();
	
	/** The add service to guest. */
	static AddServiceToGuest addServiceToGuest = new AddServiceToGuest();
	
	/** The read guest from file. */
	static ReadGuestFromFile readGuestFromFile = new ReadGuestFromFile();
	
	/** The show all guest number. */
	static ShowAllGuestNumber showAllGuestNumber = new ShowAllGuestNumber();
	
	/** The show all guests. */
	static ShowAllGuests showAllGuests = new ShowAllGuests();
	
	/** The show list of service. */
	static ShowListOfService showListOfService = new ShowListOfService();
	
	/** The show summ to paid guest. */
	static ShowSummToPaidGuest showSummToPaidGuest = new ShowSummToPaidGuest();
	
	/** The write guest to file. */
	static WriteGuestToFile writeGuestToFile = new WriteGuestToFile();

	/** The add rooms. */
	// Hotel rooms methods
	static AddRooms addRooms = new AddRooms();
	
	/** The change price of hotel room. */
	static ChangePriceOfHotelRoom changePriceOfHotelRoom = new ChangePriceOfHotelRoom();
	
	/** The change status. */
	static ChangeStatus changeStatus = new ChangeStatus();
	
	/** The depart guest from hotel room. */
	static DepartGuestFromHotelRoom departGuestFromHotelRoom = new DepartGuestFromHotelRoom();
	
	/** The settle guest to hotel room. */
	static SettleGuestToHotelRoom settleGuestToHotelRoom = new SettleGuestToHotelRoom();
	
	/** The show all rooms. */
	static ShowAllRooms showAllRooms = new ShowAllRooms();
	
	/** The show all free rooms. */
	static ShowAllFreeRooms showAllFreeRooms = new ShowAllFreeRooms();
	
	/** The show detail of hotel room. */
	static ShowDetailOfHotelRoom showDetailOfHotelRoom = new ShowDetailOfHotelRoom();
	
	/** The show free roms after date. */
	static ShowFreeRomsAfterDate showFreeRomsAfterDate = new ShowFreeRomsAfterDate();
	
	/** The show last3 guest of hotel room. */
	static ShowLast3GuestOfHotelRoom showLast3GuestOfHotelRoom = new ShowLast3GuestOfHotelRoom();
	
	/** The show number of free hotel rooms. */
	static ShowNumberOfFreeHotelRooms showNumberOfFreeHotelRooms = new ShowNumberOfFreeHotelRooms();
	
	/** The add services. */
	// Service methods
	static AddServices addServices = new AddServices();
	
	/** The change price of service. */
	static ChangePriceOfService changePriceOfService = new ChangePriceOfService();
	
	/** The show price service and hotel room. */
	static ShowPriceServiceAndHotelRoom showPriceServiceAndHotelRoom = new ShowPriceServiceAndHotelRoom();
	
	/** The exit command. */
	// exit
	static ExitCommand exitCommand = new ExitCommand();

	/**
	 * Creates a new Command object.
	 *
	 * @param choose the choose
	 */
	public static void createCommand(String choose) {
		
		switch (choose) {

		case "1 1":
			setCommand(addGuest);
			break;
		case "1 2":
			setCommand(addServiceToGuest);
			break;
		case "1 3":
			setCommand(readGuestFromFile);
			break;
		case "1 4":
			setCommand(showAllGuestNumber);
			break;
		case "1 5":
			setCommand(showAllGuests);
			break;
		case "1 6":
			setCommand(showListOfService);
			break;
		case "1 7":
			setCommand(showSummToPaidGuest);
			break;
		case "1 8":
			setCommand(writeGuestToFile);
			break;
		case "1 0":
			setCommand(exitCommand); // repeat in 2 0 3 0
			break;

		case "2 1":
			setCommand(addRooms);
			break;
		case "2 2":
			setCommand(changePriceOfHotelRoom);
			break;
		case "2 3":
			setCommand(changeStatus);
			break;
		case "2 4":
			setCommand(departGuestFromHotelRoom);
			break;
		case "2 5":
			setCommand(settleGuestToHotelRoom);
			break;
		case "2 6":
			setCommand(showAllFreeRooms);
			break;
		case "2 7":
			setCommand(showAllRooms);
			break;
		case "2 8":
			setCommand(showDetailOfHotelRoom);
			break;
		case "2 9":
			setCommand(showFreeRomsAfterDate);
			break;
		case "2 10":
			setCommand(showLast3GuestOfHotelRoom);
			break;
		case "2 11":
			setCommand(showNumberOfFreeHotelRooms);
			break;
		case "2 12":
			setCommand(showPriceServiceAndHotelRoom); // repeat in 3 3
			break;
		case "2 0":
			setCommand(exitCommand); // repeat in 3 0 2 0
			break;

		case "3 1":
			setCommand(addServices);
			break;
		case "3 2":
			setCommand(changePriceOfService);
			break;
		case "3 3":
			setCommand(showPriceServiceAndHotelRoom);
			break;
		case "3 0":
			setCommand(exitCommand); // repeat in 1 0 2 0
			break;
		default: // TODO ;
		}
		

	}

	/**
	 * Sets the command.
	 *
	 * @param command the new command
	 */
	public static void setCommand(Command command) {
		command.execute();
	}
}
